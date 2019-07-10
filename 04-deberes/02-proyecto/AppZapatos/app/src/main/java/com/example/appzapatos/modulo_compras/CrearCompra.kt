package com.example.appzapatos.modulo_compras

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.beust.klaxon.Klaxon
import com.example.appzapatos.Constantes
import com.example.appzapatos.R
import com.example.appzapatos.clases_auxiliares.ClienteAux
import com.example.appzapatos.clases_auxiliares.ZapatoAux
import com.example.appzapatos.modulo_clientes.Cliente
import com.example.appzapatos.modulo_zapatos.Zapato
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_crear_compra.*
import java.lang.Exception


class CrearCompra : AppCompatActivity() {
    private var listaClientes: ArrayList<Cliente>
    private var listaZapatos: ArrayList<Zapato>

    init {
        listaZapatos = arrayListOf<Zapato>()
        listaClientes = arrayListOf<Cliente>()

        obtenerZapatos()
        obtenerClientes()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_compra)

        btn_ing_com.setOnClickListener {
            try {


                //                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {


//                val current = LocalDateTime.now()
//                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
//                val formatted = current.format(formatter)
//            Log.i("http", "CEDULA CLIENTE: ${txt_ing_ced_cli_com.text.toString()}")
//            Log.i("http", "CODIGO ZAPATO: ${txt_ing_id_zap_com.text.toString().toInt()}")

//            listaClientes.forEach { cliente ->
//                Log.i("http", "${cliente.id} ${cliente.cedula}")
//            }
//
//            listaZapatos.forEach { zapato ->
//                Log.i("http", "${zapato.id} ${zapato.marca}")
//            }
                val zapato = listaZapatos.find { zapato ->
                    zapato.id == txt_ing_id_zap_com.text.toString().toInt()
                }

                val cliente = listaClientes.find { cliente ->
                    cliente.cedula == txt_ing_ced_cli_com.text.toString()
                }

//                Log.i("http", "Cliente: ${cliente.cedula}")
//                Log.i("http", "Zapato: ${zapato.id}")

                if (zapato != null && cliente != null) {
                    val fechaActual = "2019/07/14"
                    val total: Double = zapato.precio * (txt_ing_can_zap_com.text.toString().toInt())
                    val compra = Compra(
                        null,
                        fechaActual,
                        txt_ing_can_zap_com.text.toString().toInt(),
                        total,
                        null,
                        ClienteAux(cliente.id, null, null, null),
                        ZapatoAux(txt_ing_id_zap_com.text.toString().toInt(), null, null, null, null, null, null)
                    )

                    ingresarCompra(compra)
                    Toast.makeText(this, "Compra ingresada correctamente", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(this, "Cédula o código del zapato no valido", Toast.LENGTH_LONG).show();
                }
//            }
            } catch (e: Exception) {
                Toast.makeText(this, "Cédula o código del zapato no valido", Toast.LENGTH_LONG).show();
            }
        }
    }

    fun obtenerZapatos() {
        val url = "${Constantes.ip}${Constantes.zapato}"
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
//                        Log.i("http", "Data: ${data}")

                        val zapatos = Klaxon()
                            .parseArray<Zapato>(data)

                        zapatos?.forEach { zapato ->
                            (
                                    this.listaZapatos.add(zapato)
                                    )
                        }
                    }
                }
            }
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
//                            Log.i("http", "Data: ${data}")

                            val clientes = Klaxon()
                                .parseArray<Cliente>(data)

                            clientes?.forEach { cliente ->
                                (
                                        this.listaClientes.add(cliente)
                                        )
                            }
                        }
                    }
                }
        } catch (e: Exception) {
            Log.i("http", "${e}")
        }
    }

    fun ingresarCompra(compra: Compra) {
        val url = Constantes.ip + Constantes.compra
        val json = """
            {
            "fecha": "${compra.fecha}",
            "cantidad": ${compra.cantidad},
            "total": ${compra.total},
            "codigoCli": ${compra.codigoCli!!.id},
            "codigoZap": ${compra.codigoZap!!.id}
                        }
                    """

        url.httpPost().body(json)
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
        startActivity(intent)
    }
}
