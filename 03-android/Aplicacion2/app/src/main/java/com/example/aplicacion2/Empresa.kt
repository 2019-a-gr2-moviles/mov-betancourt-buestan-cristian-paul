package com.example.myapplication

import java.util.*

class Empresa(
    var nombre: String,
    var id: Int,
    var createdAt: Long,
    var updatedAt: Long,
    var usuariosDeEmpresa: ArrayList<UsuarioEmpresa>
) {
    var fechaCreacion: Date
    var fechaActualizacion: Date

    init {
        fechaCreacion = Date(createdAt)
        fechaActualizacion = Date(updatedAt)
    }
}