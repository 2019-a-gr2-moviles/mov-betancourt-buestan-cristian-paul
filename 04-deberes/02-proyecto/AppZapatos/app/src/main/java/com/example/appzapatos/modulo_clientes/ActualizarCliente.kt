package com.example.appzapatos.modulo_clientes

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.appzapatos.Constantes
import com.example.appzapatos.R
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_actualizar_cliente.*

class ActualizarCliente : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_cliente)

        val clienteNombre: String? = this.intent.getStringExtra("cliente-nombre")
        val clienteApellido: String? = this.intent.getStringExtra("cliente-apellido")
        val clienteCedula: String? = this.intent.getStringExtra("cliente-cedula")
        val clienteId: Int? = this.intent.getIntExtra("cliente-id", -1)

        txt_act_nom_cli.hint = clienteNombre
        txt_act_ape_cli.hint = clienteApellido
        txt_act_ced_cli.hint = clienteCedula
        txt_act_id_cli.text = clienteId.toString()

        btn_eje_act_cli.setOnClickListener {
            val cliente =
                Cliente(
                    null,
                    null,
                    null,
                    txt_act_id_cli.text.toString().toInt(),
                    txt_act_nom_cli.text.toString(),
                    txt_act_ape_cli.text.toString(),
                    txt_act_ced_cli.text.toString()
                )
            actualizarCliente(cliente)

        }

    }


    fun validar(): Boolean {
        if (txt_act_ape_cli.text == null || txt_act_nom_cli.text == null || txt_act_ced_cli.text == null) {
            return false
        }
        return true
    }

    fun actualizarCliente(cliente: Cliente) {
        val url = Constantes.ip + Constantes.cliente + "/${cliente.id}"
        val json = """
            {
            "nombre": "${cliente.nombre}",
            "apellido": "${cliente.apellido}",
            "cedula": "${cliente.cedula}"
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
}
