package com.example.appzapatos.modulo_clientes

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.beust.klaxon.Klaxon
import com.example.aplicacion2.AdaptadorListaClientes
import com.example.appzapatos.Constantes
import com.example.appzapatos.R
import com.github.kittinunf.fuel.core.interceptors.LogRequestAsCurlInterceptor
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_lista_clientes.*
import kotlinx.android.synthetic.main.activity_menu_clientes.*
import java.lang.Exception

class ListaClientes : AppCompatActivity() {
    private val listaClientes: ArrayList<Cliente> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_clientes)
        obtenerClientes()
        Log.i("http", "Tamaño lista: ${listaClientes.size}")

    }

    fun iniciarRecyclerView(listaClientes: ArrayList<Cliente>, actividad: ListaClientes, recyclerView: RecyclerView) {
        val adaptadorCliente = AdaptadorListaClientes(listaClientes, actividad, recyclerView)
        rv_clientes.adapter = adaptadorCliente
        rv_clientes.itemAnimator = DefaultItemAnimator()
        rv_clientes.layoutManager = LinearLayoutManager(actividad)

        adaptadorCliente.notifyDataSetChanged()
    }

    fun obtenerClientes() {
        //this.listaClientes.clear()
        try {
            val url = (Constantes.ip + Constantes.cliente)
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

                            val clientes = Klaxon()
                                .parseArray<Cliente>(data)

                            Log.i("http", "////////////Arreglo: ${clientes?.size}")
                            runOnUiThread {
                                clientes?.forEach { cliente ->
                                    (
                                            this.listaClientes.add(cliente)
                                            )
                                }
                                iniciarRecyclerView(listaClientes, this, rv_clientes)
                            }
                        }
                    }
                }
        } catch (e: Exception) {
            Log.i("http", "${e}")
        }
    }

    fun eliminarCliente(cliente: Cliente) {
        val url = "${Constantes.ip}${Constantes.cliente}/${cliente.id}"

        url.httpDelete()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        Log.i("http", "Resultado: ${request}")
                        runOnUiThread {
                            irListaClientes()
                        }

                    }
                }
            }

    }

    fun irListaClientes() {
        intent = Intent(
            this,
            ListaClientes::class.java
        )
        startActivity(intent)
    }

    fun irActulizarCliente(cliente: Cliente) {
        intent = Intent(
            this,
            ActualizarCliente::class.java
        )
        Log.i("http", "Cliente: ${cliente.id} ${cliente.nombre} ${cliente.apellido} ${cliente.cedula}")
        intent.putExtra("cliente-nombre", cliente.nombre)
        intent.putExtra("cliente-apellido", cliente.apellido)
        intent.putExtra("cliente-cedula", cliente.cedula)
        intent.putExtra("cliente-id", cliente.id)
//        intent.putExtra("cliente", cliente)
        startActivity(intent)
    }
}
