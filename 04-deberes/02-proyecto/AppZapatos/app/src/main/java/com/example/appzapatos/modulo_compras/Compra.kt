package com.example.appzapatos.modulo_compras

import java.util.*

class Compra(
    var id: Int,
    private var createdAt: Long,
    private var updatedAt: Long,
    var fecha: String,
    var cantidad: Int,
    var total: Double,
    var validez: Boolean,
    var codigoZap: Int,
    var codigoCli: Int
) {

}