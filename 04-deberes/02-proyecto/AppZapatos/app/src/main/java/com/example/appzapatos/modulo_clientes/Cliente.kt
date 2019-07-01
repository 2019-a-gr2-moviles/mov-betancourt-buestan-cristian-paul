package com.example.appzapatos.modulo_clientes

import com.example.appzapatos.modulo_compras.Compra
import java.util.*

class Cliente(
    var compraDeCliente: ArrayList<Compra>,
    var createdAt: Long,
    var updatedAt: Long,
    var id: Int,
    var nombre: String,
    var cedula: String,
    var apellido: String
) {
    var fechaCreacion: Date
    var fechaActualizacion: Date

    init {
        fechaCreacion = Date(createdAt)
        fechaActualizacion = Date(updatedAt)
    }
}