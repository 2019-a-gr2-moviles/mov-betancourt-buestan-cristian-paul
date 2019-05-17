package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_actividad2.*

class Actividad2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2)

        val nombre: String?= intent.getStringExtra("nombre")
        val edad: Int? = intent.getIntExtra("edad",0)
        println(nombre)
        println(edad)
        btn_actividad_uno.setOnClickListener {
            irActividadUno()
            //finish()
        }
    }

    fun irActividadUno() {
        val intent = Intent(
            this, MainActivity::class.java
        )
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}

