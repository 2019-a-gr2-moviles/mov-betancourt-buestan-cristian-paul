package com.example.examen1b

import android.os.Parcel
import android.os.Parcelable

class Medicamento(
    var id: Int,
    var gramosAIngerir: Double,
    var nombre: String,
    var composicion: String,
    var usadoPara: String,
    var fechaCaducidad: String,
    var numeroPastillas: Int,
    var idPaciente: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeDouble(gramosAIngerir)
        parcel.writeString(nombre)
        parcel.writeString(composicion)
        parcel.writeString(usadoPara)
        parcel.writeString(fechaCaducidad)
        parcel.writeInt(numeroPastillas)
        parcel.writeInt(idPaciente)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Medicamento> {
        override fun createFromParcel(parcel: Parcel): Medicamento {
            return Medicamento(parcel)
        }

        override fun newArray(size: Int): Array<Medicamento?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "${nombre.toUpperCase()}"
    }

}