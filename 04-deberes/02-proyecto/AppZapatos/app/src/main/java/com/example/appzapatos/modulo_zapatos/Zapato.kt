package com.example.appzapatos.modulo_zapatos

import com.example.appzapatos.modulo_compras.Compra
import java.util.*
import kotlin.collections.ArrayList

class Zapato(
    var id: Int,
    private var createdAt: Long,
    private var updatedAt: Long,
    var marca: String,
    var color: String,
    var talla: Int,
    var tipo: String,
    var cantidad: Int,
    var precio: Int,
    var compras: ArrayList<Compra>
) {
    var fechaCreacion: Date
    var fechaActualizacion: Date

    init {
        fechaCreacion = Date(createdAt)
        fechaActualizacion = Date(updatedAt)
    }
}