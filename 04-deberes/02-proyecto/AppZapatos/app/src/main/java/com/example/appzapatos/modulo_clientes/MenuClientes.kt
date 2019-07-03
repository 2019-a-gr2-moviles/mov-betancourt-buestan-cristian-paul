package com.example.appzapatos.modulo_clientes

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.appzapatos.R
import kotlinx.android.synthetic.main.activity_menu_clientes.*

class MenuClientes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_clientes)
        btn_ver_cli.setOnClickListener {
            irListaClientes()
        }

        btn_ing_cli.setOnClickListener {
            irCrearCliente()
        }

        btn_mod_cli.setOnClickListener {
            irActualizarCliente()
        }
    }

    fun irListaClientes(){
        intent = Intent(
            this,
            ListaClientes::class.java
        )
        startActivity(intent)
    }

    fun irCrearCliente(){
        intent = Intent(
            this,
            CrearCliente::class.java
        )
        startActivity(intent)
    }

    fun irActualizarCliente(){
        intent = Intent(
            this,
            ActualizarCliente::class.java
        )
        startActivity(intent)
    }



}
