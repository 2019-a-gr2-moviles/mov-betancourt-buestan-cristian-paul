package com.example.examen2b.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examen2b.R
import kotlinx.android.synthetic.main.activity_gestion_pacientes.*

class GestionPacientes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_pacientes)
        btn_gestion_paciente.setOnClickListener {
            irListaPacientes()
        }
        btn_crear_paciente.setOnClickListener {
            irCrearPaciente()
        }

        btn_mapa2.setOnClickListener {
            obtenerMedicamentos()
            irMapa()
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

    fun irCrearPaciente() {
        val intent = Intent(
            this,
            CrearPaciente::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
        startActivity(intent)
    }

    fun obtenerMedicamentos() {

    }

    private fun irMapa() {
        val intent = Intent(
            this,
            MapsActivity::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
