package com.example.examen2b.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import com.beust.klaxon.Klaxon
import com.example.examen2b.R
import com.example.examen2b.adaptador.AdaptadorListaPacientes
import com.example.examen2b.modelo.*
import com.example.examen2b.valoresEstaticos.Datos
import com.example.examen2b.valoresEstaticos.Servidor
import com.github.kittinunf.fuel.httpDelete
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
    }

    fun iniciarRecyclerView(
        listaPacientes: ArrayList<Paciente>,
        actividad: ListaPacientes,
        recyclerView: androidx.recyclerview.widget.RecyclerView
    ) {
        val adaptadorCliente = AdaptadorListaPacientes(listaPacientes, actividad, recyclerView)
        rv_pacientes.adapter = adaptadorCliente
        rv_pacientes.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        rv_pacientes.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(actividad)

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

    fun eliminarPaciente(idPaciente: Int) {
        val url = Servidor.url("paciente") + "?id=${idPaciente}"
        url.httpDelete()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        runOnUiThread {
                            startActivity(this.intent)
                        }
                    }
                }
            }
    }

    fun irGestionarMedicamentos(idPaciente: Int, listaMedicamentos: ArrayList<Medicamento>?) {
        val intent = Intent(
            this,
            GestionMedicamentos::class.java
        )
        Datos.listaMedicamento = listaMedicamentos!!
        intent.putExtra("idPaciente", idPaciente)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun irActualizarPaciente(paciente: Paciente) {
        val intent = Intent(
            this,
            ActualizarPaciente::class.java
        )
        intent.putExtra("id", paciente.id)
        intent.putExtra("nombres", paciente.nombres)
        intent.putExtra("apellidos", paciente.apellidos)
        intent.putExtra("fechaNacimiento", paciente.fechaNacimiento)
        intent.putExtra("hijos", paciente.hijos)
        intent.putExtra("seguro", paciente.tieneSeguro)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }

}
