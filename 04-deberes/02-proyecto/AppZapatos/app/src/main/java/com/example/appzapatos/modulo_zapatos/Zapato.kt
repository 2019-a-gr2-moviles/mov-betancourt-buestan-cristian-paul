package com.example.appzapatos.modulo_zapatos

import com.example.appzapatos.modulo_compras.Compra
import java.util.*
import kotlin.collections.ArrayList

class Zapato(
    var compras: ArrayList<Compra>,
    var createdAt: Long,
    var updatedAt: Long,
    var id: Int,
    var marca: String,
    var color: String,
    var talla: Int,
    var tipo: String,
    var cantidad: Int,
    var precio: Double

) {
    var fechaCreacion: Date
    var fechaActualizacion: Date

    init {
        fechaCreacion = Date(createdAt)
        fechaActualizacion = Date(updatedAt)
    }
}