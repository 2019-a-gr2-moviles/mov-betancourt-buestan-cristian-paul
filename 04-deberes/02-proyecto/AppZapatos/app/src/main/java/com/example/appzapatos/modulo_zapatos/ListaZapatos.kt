package com.example.appzapatos.modulo_zapatos

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
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_lista_zapatos.*

class ListaZapatos : AppCompatActivity() {

    private val listaZapatos: ArrayList<Zapato> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_zapatos)
        obtenerZapatos()
    }

    fun iniciarRecyclerView(listaZapatos: ArrayList<Zapato>, actividad: ListaZapatos, recyclerView: RecyclerView) {
        val adaptadorZapato = AdaptadorListaZapatos(listaZapatos, actividad, recyclerView)
        rv_zapatos.adapter = adaptadorZapato
        rv_zapatos.itemAnimator = DefaultItemAnimator()
        rv_zapatos.layoutManager = LinearLayoutManager(actividad)

        adaptadorZapato.notifyDataSetChanged()
    }

    fun obtenerZapatos() {
        //this.listaClientes.clear()

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

                        zapatos?.forEach { zapato ->
                            (
                                    this.listaZapatos.add(zapato)
                                    )
                        }
                        runOnUiThread {
                            iniciarRecyclerView(listaZapatos, this, rv_zapatos)
                        }
                    }
                }
            }
    }

    fun irActulizarZapato(zapato: Zapato) {
        intent = Intent(
            this,
            ActualizarZapato::class.java
        )
        intent.putExtra("zapato-marca", zapato.marca)
        intent.putExtra("zapato-color", zapato.color)
        intent.putExtra("zapato-talla", zapato.talla)
        intent.putExtra("zapato-tipo", zapato.tipo)
        intent.putExtra("zapato-cantidad", zapato.cantidad)
        intent.putExtra("zapato-precio", zapato.precio)
        intent.putExtra("zapato-id", zapato.id)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun eliminarZapato(zapato: Zapato) {
        val url = "${Constantes.ip}${Constantes.zapato}/${zapato.id}"

        url.httpDelete()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        runOnUiThread {
                            irListaZapatos()
                        }
                    }
                }
            }
    }

    fun irListaZapatos() {
        intent = Intent(
            this,
            ListaZapatos::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
