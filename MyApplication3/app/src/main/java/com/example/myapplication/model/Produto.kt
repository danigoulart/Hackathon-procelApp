package com.example.myapplication.model

class Produto(
    var nome: String,
    var kw: Float?
) {
    override fun toString(): String {
        return nome
    }
}