package com.example.examen2b.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.examen2b.R
import com.example.examen2b.modelo.Medicamento
import com.example.examen2b.valoresEstaticos.Datos
import kotlinx.android.synthetic.main.activity_gestion_medicamentos.*

class GestionMedicamentos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_medicamentos)
        val idPaciente = this.intent.getIntExtra("idPaciente", -1)

        btn_gestion_med.setOnClickListener {
            irListaMedicamentos(idPaciente)
        }


        btn_crear_medicamento.setOnClickListener {
            irCrearMedicamento(idPaciente)
        }
        btn_mapa.setOnClickListener {
            irMapa(idPaciente)
        }
    }

    fun irListaMedicamentos(idPaciente: Int) {
        val intent = Intent(
            this,
            ListaMedicamentos::class.java
        )
        intent.putExtra("idPaciente", idPaciente)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun irCrearMedicamento(idPaciente: Int) {
        val intent = Intent(
            this,
            CrearMedicamento::class.java
        )
        intent.putExtra("idPaciente", idPaciente)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun irMapa(idPaciente: Int) {
        val intent = Intent(
            this,
            MapsActivity::class.java
        )
        intent.putExtra("idPaciente", idPaciente)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
