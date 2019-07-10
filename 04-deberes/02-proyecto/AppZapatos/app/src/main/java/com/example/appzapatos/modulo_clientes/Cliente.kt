package com.example.appzapatos.modulo_clientes

class Cliente(
//    var compraDeCliente: ArrayList<Compra>?,
    var createdAt: Long?,
    var updatedAt: Long?,
    var id: Int?,
    var nombre: String,
    var cedula: String,
    var apellido: String
) {

}


//parcel.readSerializable() as? ArrayList<Compra>,
//parcel.writeSerializable(compraDeCliente)