package com.example.aplicacion2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_parcelable.*

class Parcelable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)

        btn_menu.setOnClickListener{
            irMenu()
        }

        val cristian: Usuario? = this.intent.getParcelableExtra<Usuario>("usuario")
//        Log.i("parcelable", "Nombre: ${cristian?.nombre}")
//        Log.i("parcelable", "Edad: ${cristian?.edad}")
//        Log.i("parcelable", "Fecha: ${cristian?.fechaNacimiento}")
//        Log.i("parcelable", "Sueldo: ${cristian?.sueldo}")

        val firulais: Mascota = this.intent.getParcelableExtra<Mascota>("mascota")
        Log.i("parcelable", "Mascota: ${firulais.nombre}")
        Log.i("parcelable", "Mascota: ${firulais.dueño.nombre}")
        Log.i("parcelable", "Mascota: ${firulais.dueño.edad}")
        Log.i("parcelable", "Mascota: ${firulais.dueño.fechaNacimiento}")
        Log.i("parcelable", "Mascota: ${firulais.dueño.sueldo}")

    }

    fun irMenu(){
        val intentExplicito = Intent(
            this,
            MainActivity::class.java
        )
        startActivity(intentExplicito)
    }
}
