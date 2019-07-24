package com.example.examen2b.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.examen2b.R
import com.example.examen2b.modelo.Paciente
import com.example.examen2b.valoresEstaticos.Datos
import com.example.examen2b.valoresEstaticos.Servidor
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_crear_medicamento.*
import kotlinx.android.synthetic.main.activity_crear_paciente.*
import kotlinx.android.synthetic.main.activity_lista_pacientes.*

class CrearPaciente : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_paciente)
        btn_ins_pac.setOnClickListener {
            try {
                val paciente = Paciente(
                    null,
                    -1,
                    txt_nom_pac.text.toString(),
                    txt_ape_pac.text.toString(),
                    dp_fec_nac_pac.text.toString(),
                    txt_hij_pac.text.toString().toInt(),
                    sw_seg_pac.text.toString().toBoolean()
                )
                ingresarPaciente(paciente)
            } catch (e: Exception) {
                Toast.makeText(
                    this,
                    "${Datos.nombreUsuario}: Operación fallida",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun ingresarPaciente(paciente: Paciente) {
        try {
            val url = Servidor.url("paciente")
            val json = """
            {
            "nombres": "${paciente.nombres}",
            "apellidos": "${paciente.apellidos}",
            "fechaNacimiento": "${paciente.fechaNacimiento}",
            "hijos": ${paciente.hijos},
            "tieneSeguro" : ${paciente.tieneSeguro}
                                         }
                    """.trimIndent()

            Log.i("http", json)
            url.httpPost().body(json)
                .responseString { request, response, result ->
                    when (result) {
                        is Result.Failure -> {
                            val ex = result.getException()
                            Log.i("http", "Error: ${ex.message}")
                        }
                        is Result.Success -> {
                            runOnUiThread {
                                Toast.makeText(
                                    this,
                                    "${Datos.nombreUsuario}: Operación fallida",
                                    Toast.LENGTH_LONG
                                ).show()
                                irListaPacientes()
                            }
                        }
                    }
                }
        } catch (e: Exception) {
            Toast.makeText(
                this,
                "${Datos.nombreUsuario}: Operación fallida",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun irListaPacientes() {
        val intent = Intent(
            this,
            ListaPacientes::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }
}
