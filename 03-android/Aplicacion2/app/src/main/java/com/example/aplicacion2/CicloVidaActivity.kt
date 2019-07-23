package com.example.aplicacion2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_ciclo_vida.*

class CicloVidaActivity : AppCompatActivity() {

    var contador = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciclo_vida)
        Log.i("ciclo-vida", "OnCreate")
        btn_contador.setOnClickListener {
            aumentarContador()
            txt_contador.text = contador.toString()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("ciclo-vida", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ciclo-vida", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ciclo-vida", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ciclo-vida", "OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ciclo-vida", "OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ciclo-vida", "OnDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        Log.i("ciclo-vida", "OnSaveInstanceState")
        outState?.run {
            putInt("contadorGuardado", contador)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.runCatching {
            contador = this!!.getInt("contadorGuardado", -5)
        }
        txt_contador.text = contador.toString()
        Log.i("ciclo-vida", "OnRestoreInstanceState")
    }

    fun aumentarContador() {
        contador++
    }
}
