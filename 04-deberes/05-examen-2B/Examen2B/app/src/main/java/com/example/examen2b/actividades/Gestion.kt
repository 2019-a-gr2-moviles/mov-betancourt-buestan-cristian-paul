package com.example.examen2b.actividades

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.examen2b.R
import com.example.examen2b.valoresEstaticos.Datos
import kotlinx.android.synthetic.main.activity_gestion.*
import kotlinx.android.synthetic.main.activity_main.*

class Gestion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion)
        btn_gestion_paciente.setOnClickListener {
            irListaPacientes()
        }

    }
    private fun irListaPacientes() {
        val intent = Intent(
            this,
            ListaPacientes::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun irMapa() {

    }

}
