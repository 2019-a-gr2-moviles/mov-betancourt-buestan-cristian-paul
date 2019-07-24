package com.example.examen2b.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.examen2b.R
import com.example.examen2b.modelo.Medicamento
import com.example.examen2b.valoresEstaticos.Datos
import com.example.examen2b.valoresEstaticos.Servidor
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_crear_medicamento.*
import java.lang.Exception

class CrearMedicamento : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_medicamento)
        val idPaciente: Int = this.intent.getIntExtra("idPaciente", -1)
        btn_ins_med.setOnClickListener {
            try {
                val medicamento = Medicamento(
                    -1,
                    txt_gra_med.text.toString().toDouble(),
                    txt_nom_med.text.toString(),
                    txt_comp_med.text.toString(),
                    txt_uso_med.text.toString(),
                    fec_cad_med.text.toString(),
                    txt_num_pas_med.text.toString().toInt(),
                    idPaciente,
                    txt_longitud.text.toString(),
                    txt_latitud.text.toString()
                )

                ingresarMedicamento(medicamento)
            } catch (e: Exception) {
                Toast.makeText(
                    this,
                    "${Datos.nombreUsuario}: Operación fallida",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun ingresarMedicamento(medicamento: Medicamento) {

        try {
            val url = Servidor.url("medicamento")

            val json = """
            {
            "nombre" : "${medicamento.nombre}",
            "composicion" : "${medicamento.composicion}",
            "usadoPara" : "${medicamento.usadoPara}",
            "gramosAIngerir" : ${medicamento.gramosAIngerir},
            "fechaCaducidad" : "${medicamento.fechaCaducidad}",
            "numeroPastillas" : ${medicamento.numeroPastillas},
            "latitud" : "${medicamento.latitud}",
            "longitud" : "${medicamento.longitud}",
            "idPaciente": ${medicamento.idPaciente}
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
                                    "${Datos.nombreUsuario}: Operación exitosa",
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
            ListaPacientes()::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
