package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_actividad2.*

class Actividad2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2)

        btn_actividad_uno.setOnClickListener {
            irActividadUno()
        }
    }

    fun irActividadUno() {
        val intent = Intent(
            this, MainActivity::class.java
        )
        startActivity(intent)
    }
}

