plugins {
    kotlin("jvm")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.23")
    implementation("io.github.classgraph:classgraph:4.8.173")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(18)
}