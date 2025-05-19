package org.example.models

import org.example.Visitor.Visitor

interface Visitable {
    fun accept(v : Visitor)
}