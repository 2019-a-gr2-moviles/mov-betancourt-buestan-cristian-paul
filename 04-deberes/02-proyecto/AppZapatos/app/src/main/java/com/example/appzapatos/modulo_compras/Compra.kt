package com.example.appzapatos.modulo_compras

import java.util.*

class Compra(
    var id: Int,
    private var createdAt: Long,
    private var updatedAt: Long,
    var fecha: Date,
    var cantidad: Int,
    var total: String,
    var validez: Int,
    var codigoZap: Int,
    var codigoCli: Int
) {
    var fechaCreacion: Date
    var fechaActualizacion: Date

    init {
        fechaCreacion = Date(createdAt)
        fechaActualizacion = Date(updatedAt)
        fecha =fechaCreacion
    }
}