package com.example.examen1b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_gestion_pacientes.*

class GestionPacientes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_pacientes)

        btn_ges_pac.setOnClickListener {
            irListaPacientes()
        }

        btn_crear_pac.setOnClickListener {
            irCrearPaciente()
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

    private fun irCrearPaciente() {
        val intent = Intent(
            this,
            CrearPaciente::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
