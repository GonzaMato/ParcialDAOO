package org.errors.models

import org.errors.Visitor.Visitor

interface Visitable {
    fun accept(v : Visitor)
}