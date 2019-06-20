package com.example.gmail

import android.os.Parcel
import android.os.Parcelable

class Mensaje(
    val remitente: String,
    val asunto: String,
    val contenido: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(remitente)
        parcel.writeString(asunto)
        parcel.writeString(contenido)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Mensaje> {
        override fun createFromParcel(parcel: Parcel): Mensaje {
            return Mensaje(parcel)
        }

        override fun newArray(size: Int): Array<Mensaje?> {
            return arrayOfNulls(size)
        }
    }


}
