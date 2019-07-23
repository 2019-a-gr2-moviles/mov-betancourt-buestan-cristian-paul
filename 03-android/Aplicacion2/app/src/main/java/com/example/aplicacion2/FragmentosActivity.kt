package com.example.aplicacion2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fragmentos.*

class FragmentosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentos)

        btn_uno.setOnClickListener {
            abrirFragmentoUno()
        }
        btn_dos.setOnClickListener {
            abrirFragmentoDos()
        }
        btn_tres.setOnClickListener {
            abrirFragmentoTres()
        }
    }

    fun abrirFragmentoUno() {
        // 1) Manager
        val fragmentManager = supportFragmentManager
        // 2) Empezar la transacción
        val transaccion = fragmentManager.beginTransaction()
        // 3) Definir la instancia del fragmento
        val primerFragmento = fragment_uno()
        // 4) Reemplazamos el fragmento
        transaccion.replace(R.id.ly_fragmentos, primerFragmento)
        // 5) Terminar transaccion
        transaccion.commit()
    }

    fun abrirFragmentoDos() {
        // 1) Manager
        val fragmentManager = supportFragmentManager
        // 2) Empezar la transacción
        val transaccion = fragmentManager.beginTransaction()
        // 3) Definir la instancia del fragmento
        val segundoFragmento = fragment_dos()
        // 4) Reemplazamos el fragmento
        transaccion.replace(R.id.ly_fragmentos, segundoFragmento)
        // 5) Terminar transaccion
        transaccion.commit()
    }

    fun abrirFragmentoTres() {
        // 1) Manager
        val fragmentManager = supportFragmentManager
        // 2) Empezar la transacción
        val transaccion = fragmentManager.beginTransaction()
        // 3) Definir la instancia del fragmento
        val tercerFragmento = fragment_tres()
        // 4) Reemplazamos el fragmento

        val argumentos = Bundle()
        argumentos.putInt("contador", 1)
        tercerFragmento.arguments = argumentos
        transaccion.replace(R.id.ly_fragmentos, tercerFragmento)
        // 5) Terminar transaccion
        transaccion.commit()
    }
}
