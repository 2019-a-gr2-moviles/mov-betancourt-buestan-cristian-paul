package com.example.appzapatos.modulo_clientes

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.appzapatos.Constantes
import com.example.appzapatos.R
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_crear_cliente.*

class CrearCliente : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cliente)
        btn_acc_ing_cli.setOnClickListener {
            if (validar()) {
                val cliente = Cliente(
//                    null,
                    null,
                    null,
                    null,
                    txt_acc_nom_cli.text.toString(),
                    txt_acc_ced_cli.text.toString(),
                    txt_acc_ape_cli.text.toString()
                )
                ingresarCliente(cliente)
            }
        }
    }

    fun ingresarCliente(cliente: Cliente) {
        val url = Constantes.ip + Constantes.cliente
        val json = """
            {
            "nombre": "${cliente.nombre}",
            "apellido": "${cliente.apellido}",
            "cedula": "${cliente.cedula}"
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
                            irListaClientes()
                        }
                    }
                }
            }
    }

    fun validar(): Boolean {
        if (txt_acc_ape_cli.text == null || txt_acc_nom_cli.text == null || txt_acc_ced_cli.text == null) {
            return false
        }
        return true
    }

    fun irListaClientes() {
        intent = Intent(
            this,
            ListaClientes::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
