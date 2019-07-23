package com.example.examen2b.actividades

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.beust.klaxon.Klaxon
import com.example.examen1b.Paciente
import com.example.examen2b.R
import com.example.examen2b.valoresEstaticos.Servidor
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

class ListaPacientes : AppCompatActivity() {
    private var listaPacientes: ArrayList<Paciente> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        obtenerPacientes()
        setContentView(R.layout.activity_lista_pacientes)

    }

    private fun obtenerPacientes() {

        val url = Servidor.url("paciente")
        Log.i("http", url)
        url.httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("http", "Data: ${data}")

                        listaPacientes = Klaxon()
                            .parseArray<Paciente>(data)!! as ArrayList<Paciente>

                        Log.i("http", "$data")
//                        runOnUiThread {
//
//                        }
                    }
                }
            }
    }


}
