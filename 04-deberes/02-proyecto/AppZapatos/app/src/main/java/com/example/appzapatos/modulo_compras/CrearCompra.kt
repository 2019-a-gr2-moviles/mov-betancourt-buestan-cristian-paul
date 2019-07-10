package com.example.appzapatos.modulo_compras

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.appzapatos.R
import kotlinx.android.synthetic.main.activity_crear_compra.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CrearCompra : AppCompatActivity() {
//    private listaClientes: ArrayList<Cliente>
//    private listaZapatos: ArrayList<Zapato>
//
    init {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_compra)
        btn_ing_com.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val current = LocalDateTime.now()
                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
                val formatted = current.format(formatter)
//                val compra = Compra(null, null, null, formatted, txt_ing_can_zap_com.text.toString().toInt(),)
            }


        }
    }
}
