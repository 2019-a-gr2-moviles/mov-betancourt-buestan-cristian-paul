package com.example.appzapatos.modulo_compras

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.appzapatos.R
import kotlinx.android.synthetic.main.activity_menu_compras.*

class MenuCompras : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_compras)

        btn_ing_com.setOnClickListener {
            irCrearCompra()
        }
        btn_ver_com.setOnClickListener {
            irListaCompras()
        }
        btn_mod_com.setOnClickListener {
            irListaCompras()
        }
    }

    fun irCrearCompra() {
        intent = Intent(
            this,
            CrearCompra::class.java
        )
        startActivity(intent)
    }

    fun irListaCompras() {
        intent = Intent(
            this,
            ListaCompras::class.java
        )
        startActivity(intent)
    }
}
