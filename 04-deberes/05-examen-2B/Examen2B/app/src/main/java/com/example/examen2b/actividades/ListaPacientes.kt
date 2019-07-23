package com.example.examen2b.actividades

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.beust.klaxon.Klaxon
import com.example.examen2b.R
import com.example.examen2b.adaptador.AdaptadorListaPacientes
import com.example.examen2b.modelo.*
import com.example.examen2b.valoresEstaticos.Datos
import com.example.examen2b.valoresEstaticos.Servidor
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_lista_medicamentos.*
import kotlinx.android.synthetic.main.activity_lista_pacientes.*

class ListaPacientes : AppCompatActivity() {
    private var listaPacientes: ArrayList<Paciente> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        obtenerPacientes()
        setContentView(R.layout.activity_lista_pacientes)

        btn_crear_paciente.setOnClickListener {
            irCrearPaciente()
        }
    }

    fun iniciarRecyclerView(
        listaPacientes: ArrayList<Paciente>,
        actividad: ListaPacientes,
        recyclerView: RecyclerView
    ) {
        val adaptadorCliente = AdaptadorListaPacientes(listaPacientes, actividad, recyclerView)
        rv_pacientes.adapter = adaptadorCliente
        rv_pacientes.itemAnimator = DefaultItemAnimator()
        rv_pacientes.layoutManager = LinearLayoutManager(actividad)

        adaptadorCliente.notifyDataSetChanged()
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
                        runOnUiThread {
                            iniciarRecyclerView(listaPacientes, this, rv_pacientes)
                        }
                    }
                }
            }
    }

    fun irListaMedicamentos(idPaciente: Int, listaMedicamentos: ArrayList<Medicamento>?) {
        val intent = Intent(
            this,
            ListaMedicamentos::class.java
        )
        Datos.listaMedicamento = listaMedicamentos!!
        intent.putExtra("idPaciente", idPaciente)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun irCrearPaciente() {
        val intent = Intent(
            this,
            CrearPaciente::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }

}
