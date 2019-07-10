package com.example.appzapatos.modulo_compras

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.beust.klaxon.Klaxon
import com.example.appzapatos.Constantes
import com.example.appzapatos.R
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_lista_compras.*

class ListaCompras : AppCompatActivity() {

    private val listaCompras: ArrayList<Compra> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_compras)
        obtenerCompras()
    }

    fun iniciarRecyclerView(listaCompras: ArrayList<Compra>, actividad: ListaCompras, recyclerView: RecyclerView) {
        val adaptadorCompra = AdaptadorListaCompras(listaCompras, actividad, recyclerView)
        rv_compras.adapter = adaptadorCompra
        rv_compras.itemAnimator = DefaultItemAnimator()
        rv_compras.layoutManager = LinearLayoutManager(actividad)

        adaptadorCompra.notifyDataSetChanged()
    }

    fun obtenerCompras() {

        val url = (Constantes.ip + Constantes.compra)
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

                        val compras = Klaxon()
                            .parseArray<Compra>(data)

                        compras?.forEach { compra ->
                            (
                                    this.listaCompras.add(compra)
                                    )
                        }

                        runOnUiThread {
                            iniciarRecyclerView(listaCompras, this, rv_compras)
                        }
                    }
                }
            }
    }

    fun actualizarCompra(compra: Compra) {
        val url = Constantes.ip + Constantes.compra + "/${compra.id}"
        val json = """
            {
            "validez": "${compra.validez}"
            }
                    """
        Log.i("http", url)
        Log.i("http", json)
        url.httpPut().body(json)
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        runOnUiThread {
                            irListaCompras()
                        }
                    }
                }
            }
    }

    fun irListaCompras() {
        intent = Intent(
            this,
            ListaCompras::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
