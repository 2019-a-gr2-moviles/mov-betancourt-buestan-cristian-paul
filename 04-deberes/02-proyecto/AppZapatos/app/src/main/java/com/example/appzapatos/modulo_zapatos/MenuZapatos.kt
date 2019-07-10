package com.example.appzapatos.modulo_zapatos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.appzapatos.R
import com.example.appzapatos.modulo_clientes.ListaClientes
import kotlinx.android.synthetic.main.activity_menu_clientes.*
import kotlinx.android.synthetic.main.activity_menu_zapatos.*

class MenuZapatos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_zapatos)
        btn_ver_zap.setOnClickListener {
            irListaZapatos()
        }

        btn_ing_zap.setOnClickListener {
            irCrearZapato()
        }
    }

    fun irListaZapatos() {
        intent = Intent(
            this,
            ListaZapatos::class.java
        )
        startActivity(intent)
    }

    fun irCrearZapato() {
        intent = Intent(
            this,
            CrearZapato::class.java
        )
        startActivity(intent)
    }
}
