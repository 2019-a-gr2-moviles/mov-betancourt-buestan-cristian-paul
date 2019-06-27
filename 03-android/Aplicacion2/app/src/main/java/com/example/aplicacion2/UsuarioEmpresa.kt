package com.example.myapplication

import java.util.*

class UsuarioEmpresa(
    var nombre: String,
    var id: Int,
    var createdAt: Long,
    var updatedAt: Long,
    var fkEmpresa: Int
) {
    var fechaCreacion: Date
    var fechaActualizacion: Date

    init {
        fechaCreacion = Date(createdAt)
        fechaActualizacion = Date(updatedAt)
    }
}