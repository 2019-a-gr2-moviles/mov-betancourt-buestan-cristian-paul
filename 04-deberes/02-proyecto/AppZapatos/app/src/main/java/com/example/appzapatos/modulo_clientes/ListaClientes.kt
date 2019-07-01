package com.example.appzapatos.modulo_clientes

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
        iniciarRecyclerView(listaClientes, this, rv_clientes)
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
                            clientes?.forEach { cliente ->
                                (
                                        if (cliente != null) {
                                            Log.i("http", "iiiiiiiiiiiiii")
                                            Log.i("http", "${cliente.nombre}")
                                            Log.i("http", "${cliente.apellido}")
                                            Log.i("http", "${cliente.cedula}")
                                            this.listaClientes.add(cliente)
                                        }
                                        )
                            }
                        }
                    }
                }
        } catch (e: Exception) {
            Log.i("http", "${e}")
        }
    }
}
