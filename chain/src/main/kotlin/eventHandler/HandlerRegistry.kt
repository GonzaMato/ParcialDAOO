package org.example.eventHandler

import io.github.classgraph.ClassGraph
import org.example.events.Event
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

/** Descubre todos los Handler y arma la cadena en el primer acceso. */
object HandlerRegistry {

    /** Primer eslabón de la cadena (root). */
    private val root: Handler by lazy { buildChain() }

    fun handleEvent(event : Event) {
        root.handle(event)
    }

    private fun buildChain(): Handler {
        val handlers = discoverHandlers()
        require(handlers.isNotEmpty()) { "No se encontró ningún Handler concreto. ¿Están en el mismo módulo y extienden Handler?" }
        // Encadena en el orden devuelto por `discoverHandlers`
        handlers.zipWithNext { a, b -> a.setNextHandler(b) }

        return handlers.first()
    }

    /** Reflexión → obtiene todas las subclases, las instancia y las ordena. */
    private fun discoverHandlers(): List<Handler> =
        ClassGraph()
            .acceptPackages("org.example.eventHandler")
            .enableClassInfo()
            .scan()
            .use { scan ->
                scan.getSubclasses(Handler::class.qualifiedName)
                    .filter { !it.isAbstract }
                    .loadClasses(Handler::class.java)
                    .map { cls ->
                        cls.kotlin.objectInstance ?: cls.kotlin.safeNew()
                    }
                    .filterNotNull()
            }


    /** Recorre recursivamente si hay más niveles sealed. */
    private fun <T : Any> collectSubclasses(root: KClass<T>): List<KClass<out T>> =
        buildList {
            add(root)
            if (root.isSealed)
                root.sealedSubclasses.forEach { addAll(collectSubclasses(it)) }
        }.filterNot { it == root }       // quitamos la propia raíz

    /** Instancia sólo si hay ctor sin parámetros. */
    private fun <T : Any> KClass<T>.safeNew(): T? =
        takeIf { constructors.singleOrNull()?.parameters?.isEmpty() == true }
            ?.createInstance()
}
