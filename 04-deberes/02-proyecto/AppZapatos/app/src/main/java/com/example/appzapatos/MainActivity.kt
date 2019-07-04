package com.example.appzapatos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.appzapatos.modulo_clientes.MenuClientes
import com.example.appzapatos.modulo_compras.MenuCompras
import com.example.appzapatos.modulo_zapatos.MenuZapatos
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_zapatos.setOnClickListener {
            irMenuZapatos()
        }

        btn_clientes.setOnClickListener {
            irMenuClientes()
        }
        btn_compras.setOnClickListener {
            irMenuCompras()
        }
    }

    fun irMenuZapatos() {
        val intent = Intent(
            this,
            MenuZapatos::class.java
        )
        startActivity(intent)
    }
    fun irMenuClientes() {
        val intent = Intent(
            this,
            MenuClientes::class.java
        )
        startActivity(intent)
    }   fun irMenuCompras() {
        val intent = Intent(
            this,
            MenuCompras::class.java
        )
        startActivity(intent)
    }
}
