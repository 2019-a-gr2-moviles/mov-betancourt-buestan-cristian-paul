package com.example.gmail

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_bandeja.setOnClickListener {
            irBandejaEntrada()
        }
    }

    fun irBandejaEntrada() {
        val intent = Intent(
            this,
            BandejaEntrada::class.java
        )
        Log.i("nnn","click")
        startActivity(intent)
    }

}
