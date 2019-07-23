package com.example.examen1b

import android.os.Parcel
import android.os.Parcelable
import java.lang.StringBuilder

class Paciente(
    var id: Int,
    var nombres: String,
    var apellidos: String,
    var fechaNacimiento: String,
    var hijos: Int,
    var tieneSeguro: Boolean,
    var opc: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt()

    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nombres)
        parcel.writeString(apellidos)
        parcel.writeString(fechaNacimiento)
        parcel.writeInt(hijos)
        parcel.writeByte(if (tieneSeguro) 1 else 0)
        parcel.writeInt(opc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Paciente> {
        override fun createFromParcel(parcel: Parcel): Paciente {
            return Paciente(parcel)
        }

        override fun newArray(size: Int): Array<Paciente?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "${nombres.toUpperCase()} ${apellidos.toUpperCase()}"
    }

}