package com.example.appzapatos.modulo_clientes

import android.os.Parcel
import android.os.Parcelable
import com.example.appzapatos.modulo_compras.Compra
import kotlin.collections.ArrayList

class Cliente(
    var compraDeCliente: ArrayList<Compra>?,
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