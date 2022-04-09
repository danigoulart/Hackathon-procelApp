package com.example.myapplication.model

data class Estados(
    var estado : String,
    var sigla : String,
    var kw : Float? = null,
) {
    override fun toString(): String {
        return estado.toString()
    }
}