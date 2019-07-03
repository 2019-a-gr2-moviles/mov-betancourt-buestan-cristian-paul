package com.example.appzapatos.modulo_clientes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import com.example.appzapatos.Constantes
import com.example.appzapatos.R
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_actualizar_cliente.*
import kotlinx.android.synthetic.main.activity_crear_cliente.*

class ActualizarCliente : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_cliente)

        val clienteNombre: String? = this.intent.getStringExtra("cliente-nombre")
        val clienteApellido: String? = this.intent.getStringExtra("cliente-apellido")
        val clienteCedula: String? = this.intent.getStringExtra("cliente-cedula")
        val clienteId: Int? = this.intent.getIntExtra("cliente-id", 0)

        txt_act_nom_cli.hint = clienteNombre
//        txt_act_ape_cli.text = clienteApellido as Editable
//        txt_act_ced_cli.text = clienteCedula as Editable
//        txt_act_id_cli.text = clienteId.toString()

        Log.i("http", "Cliente: ${clienteNombre} ${clienteApellido} ${clienteCedula} ${clienteId}")
    }

//
//    fun validar(): Boolean {
//        if (txt_act_ape_cli.text == null || txt_act_nom_cli.text == null || txt_act_ced_cli.text == null) {
//            return false
//        }
//        return true
//    }

//    fun ingresarCliente(cliente: Cliente) {
////        val url = Constantes.ip + Constantes.cliente
////        val json = """
////            {
////            "nombre": "${cliente.nombre}",
////            "apellido": "${cliente.apellido}",
////            "cedula": "${cliente.cedula}"
////                        }
////                    """
////
////        Log.i("http-crear", "${json}")
////        Log.i("http-crear", "${url}")
////        Log.i("http-crear", "${cliente.nombre} ${cliente.apellido} ${cliente.cedula} ")
////
////        url.httpPost().body(json)
////            .responseString { request, response, result ->
////                when (result) {
////                    is Result.Failure -> {
////                        val ex = result.getException()
////                        Log.i("http", "Error: ${ex.message}")
////                    }
////                    is Result.Success -> {
//////                        Log.i("http", "rEQUEST!!!!!!!!!1TODO BIIIIIIIIIIIIIIIIIEN: ${request}")
////                        irListaClientes()
////
////                    }
////                }
////            }
////    }

}
