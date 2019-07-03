package com.example.appzapatos.modulo_zapatos

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
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_lista_clientes.*
import kotlinx.android.synthetic.main.activity_lista_zapatos.*
import java.lang.Exception

class ListaZapatos : AppCompatActivity() {

    private val listaZapatos: ArrayList<Zapato> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_zapatos)
        obtenerClientes()

    }

    fun iniciarRecyclerView(listaZapatos: ArrayList<Zapato>, actividad: ListaZapatos, recyclerView: RecyclerView) {
        val adaptadorZapato = AdaptadorListaZapatos2(listaZapatos, actividad, recyclerView)
        rv_clientes.adapter = adaptadorZapato
        rv_clientes.itemAnimator = DefaultItemAnimator()
        rv_clientes.layoutManager = LinearLayoutManager(actividad)

        adaptadorZapato.notifyDataSetChanged()
    }

    fun obtenerClientes() {
        //this.listaClientes.clear()
        try {
            val url = (Constantes.ip + Constantes.zapato)
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

                            val zapatos = Klaxon()
                                .parseArray<Zapato>(data)


                            Log.i("http", "////////////Arreglo: ${zapatos?.size}")
                            zapatos?.forEach { zapato ->
                                (
                                        if (zapato != null) {
                                            Log.i("http", "iiiiiiiiiiiiii")
                                            this.listaZapatos.add(zapato)
                                        }
                                        )
                            }
                            runOnUiThread {
                                iniciarRecyclerView(listaZapatos, this, rv_zapatos)
                            }
                        }
                    }
                }
        } catch (e: Exception) {
            Log.i("http", "${e}")
        }
    }
}
