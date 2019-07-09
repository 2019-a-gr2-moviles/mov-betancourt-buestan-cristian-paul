package com.example.appzapatos.modulo_zapatos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.appzapatos.Constantes
import com.example.appzapatos.R
import com.example.appzapatos.modulo_clientes.Cliente
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_crear_zapato.*

class CrearZapato : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_zapato)
        btn_ing_zap.setOnClickListener {
            val zapato = Zapato(
                null,
                null,
                null,
                null,
                txt_ing_mar_zap.text.toString(),
                txt_ing_col_zap.text.toString(),
                txt_ing_tal_zap.text.toString().toInt(),
                txt_ing_tip_zap.text.toString(),
                txt_ing_can_zap.text.toString().toInt(),
                txt_ing_pre_zap.text.toString().toDouble()
            )
            ingresarZapato(zapato)
        }
    }

    fun ingresarZapato(zapato: Zapato) {

        val url = Constantes.ip + Constantes.zapato
        val json = """
            {
            "marca": "${zapato.marca}",
            "color": "${zapato.color}",
            "tipo": "${zapato.tipo}",
            "cantidad": ${zapato.cantidad},
            "precio": ${zapato.precio},
            "talla": ${zapato.talla}
            }
                    """
        Log.i("http-json", json)
        url.httpPost().body(json)
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
        startActivity(intent)
    }
}
