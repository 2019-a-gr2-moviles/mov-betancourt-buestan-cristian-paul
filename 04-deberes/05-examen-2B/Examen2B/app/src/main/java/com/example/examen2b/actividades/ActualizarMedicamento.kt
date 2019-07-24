package com.example.examen2b.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.examen2b.R
import com.example.examen2b.modelo.Medicamento
import com.example.examen2b.modelo.Paciente
import com.example.examen2b.valoresEstaticos.Datos
import com.example.examen2b.valoresEstaticos.Servidor
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_actualizar_medicamento.*
import java.lang.Exception

class ActualizarMedicamento : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_medicamento)
        val id: Int = this.intent.getIntExtra("id", -1)
        val numeroPastillas = this.intent.getIntExtra("pastillas", -1)
        val nombre = this.intent.getStringExtra("nombre")
        val fechaCaducidad = this.intent.getStringExtra("fechaCaducidad")
        val gramosAIngerir = this.intent.getDoubleExtra("gramos", -1.0)
        val usadoPara = this.intent.getStringExtra("uso")
        val composicion = this.intent.getStringExtra("composicion")

        txt_num_pas_med_act.hint = numeroPastillas.toString()
        txt_nom_med_act.hint = nombre
        fec_cad_med_act.hint = fechaCaducidad
        txt_gra_med_act.hint = gramosAIngerir.toString()
        txt_uso_med_act.hint = usadoPara
        txt_comp_med_act.hint = composicion
        btn_act_med_conf.setOnClickListener {
            try {
                val medicamento = Medicamento(
                    id,
                    txt_gra_med_act.text.toString().toDouble(),
                    txt_nom_med_act.text.toString(),
                    txt_comp_med_act.text.toString(),
                    txt_uso_med_act.text.toString(),
                    fec_cad_med_act.text.toString(),
                    txt_num_pas_med_act.text.toString().toInt(),
                    -1,
                    txt_lon_act.text.toString(),
                    txt_lat_act.text.toString()
                )

                actualizarMedicamento(medicamento)
            } catch (e: Exception) {
                Toast.makeText(
                    this,
                    "${Datos.nombreUsuario}: Operación fallida",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun actualizarMedicamento(medicamento: Medicamento) {
        try{
        val url = Servidor.url("medicamento") + "/${medicamento.id}"
        val json = """
            {
             "nombre" : "${medicamento.nombre}",
            "composicion" : "${medicamento.composicion}",
            "usadoPara" : "${medicamento.usadoPara}",
            "gramosAIngerir" : ${medicamento.gramosAIngerir},
            "fechaCaducidad" : "${medicamento.fechaCaducidad}",
            "numeroPastillas" : ${medicamento.numeroPastillas},
            "latitud" : "${medicamento.latitud}",
            "longitud" : "${medicamento.longitud}"
                                                     }
                    """.trimIndent()
        Log.i("http", url)
        Log.i("http", json)
        url.httpPut().body(json)
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                        Toast.makeText(
                            this,
                            "${Datos.nombreUsuario}: Operación fallida",
                            Toast.LENGTH_LONG
                        ).show()
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
            }}catch (e:Exception){
            Toast.makeText(
                this,
                "${Datos.nombreUsuario}: Operación fallida",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun irListaPacientes() {
        intent = Intent(
            this,
            ListaPacientes::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }
}
