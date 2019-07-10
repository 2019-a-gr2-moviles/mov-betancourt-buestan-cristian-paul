package com.example.appzapatos.modulo_zapatos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.appzapatos.Constantes
import com.example.appzapatos.R
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_actualizar_zapato.*

class ActualizarZapato : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_zapato)

        val zapatoMarca: String? = this.intent.getStringExtra("zapato-marca")
        val zapatoColor: String? = this.intent.getStringExtra("zapato-color")
        val zapatoTipo: String? = this.intent.getStringExtra("zapato-tipo")
        val zapatoTalla: Int? = this.intent.getIntExtra("zapato-talla", -1)
        val zapatoId: Int? = this.intent.getIntExtra("zapato-id", -1)
        val zapatoCantidad: Int? = this.intent.getIntExtra("zapato-cantidad", -1)
        val zapatoPrecio: Double? = this.intent.getDoubleExtra("zapato-precio", -1.0)

        Log.i(
            "http",
            "$zapatoId $zapatoMarca $zapatoColor $zapatoTalla $zapatoTipo $zapatoCantidad $zapatoPrecio"
        )

        txt_act_id_zap.text = zapatoId.toString()
        txt_act_mar_zap.hint = zapatoMarca
        txt_act_col_zap.hint = zapatoColor
        txt_act_tip_zap.hint = zapatoTipo
        txt_act_tal_zap.hint = zapatoTalla.toString()
        txt_act_can_zap.hint = zapatoCantidad.toString()
        txt_act_pre_zap.hint = zapatoPrecio.toString()

        btn_act_zap.setOnClickListener {
            val zapato = Zapato(
//                null,
                null,
                null,
                txt_act_id_zap.text.toString().toInt(),
                txt_act_mar_zap.text.toString(),
                txt_act_col_zap.text.toString(),
                txt_act_tal_zap.text.toString().toInt(),
                txt_act_tip_zap.text.toString(),
                txt_act_can_zap.text.toString().toInt(),
                txt_act_pre_zap.text.toString().toDouble()
            )
            actualizarZapato(zapato)
        }
    }

    fun actualizarZapato(zapato: Zapato) {

        val url = Constantes.ip + Constantes.zapato + "/${zapato.id}"
        val json = """
            {
            "marca": "${zapato.marca}",
            "color": "${zapato.color}",
            "tipo": "${zapato.tipo}",
            "talla": ${zapato.talla},
            "cantidad": ${zapato.cantidad},
            "precio": ${zapato.precio}
                                   }
                    """

        url.httpPut().body(json)
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        Log.i("http", "$response")
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
