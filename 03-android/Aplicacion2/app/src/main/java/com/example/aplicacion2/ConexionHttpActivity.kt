package com.example.aplicacion2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.beust.klaxon.Klaxon
import com.example.myapplication.Empresa
import com.github.kittinunf.fuel.httpGet
import java.lang.Exception
import com.github.kittinunf.result.Result.*
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost


class ConexionHttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conexion_http)
//
//        val json = """
//            {
//                "createdAt": 1561663800282,
//                "updatedAt": 1561663800282,
//                "id": 1,
//                "nombre": "Plus"
//            }
//                    """.trimIndent()
//
//        try {
//            val empresaInstancia = Klaxon()
//                .parse<Empresa>(json)
//
//            Log.i("http", "Nombre ${empresaInstancia?.nombre}")
//            Log.i("http", "Id: ${empresaInstancia?.id}")
//            Log.i("http", "Fecha creación: ${empresaInstancia.fechaCreacion}")
//            Log.i("http", "Fecha actualización: ${empresaInstancia.fechaActualizacion}")
//
//        } catch (e: Exception) {
//            Log.i("http","Error instanciando la empresa")
//            Log.i("http","e: ${e}")
//        }

/////////ARREGLO DE OBJETOS /////////////////////////////////////////////////////////
//        val json = """
//            [
//            {
//                "usuariosDeEmpresa": [],
//                "createdAt": 1561663800282,
//                "updatedAt": 1561663800282,
//                "id": 1,
//                "nombre": "Plus"
//            }
//            ]
//                    """.trimIndent()
//
//        try {
//            val empresaInstancia = Klaxon()
//                .parseArray<Empresa>(json)
//            empresaInstancia?.forEach {
//                Log.i("http", "Nombre: ${it.nombre}")
//                Log.i("http", "Id: ${it.id}")
//                Log.i("http", "Fecha: ${it.fechaCreacion}")
//            }
//        } catch (e: Exception) {
//            Log.i("http", "Error instanciando la empresa")
//            Log.i("http", "e: ${e}")
//        }

//////////////////////////////////////////////////////////////////////////
//        val json = """
//            [
//                {
//                  "usuariosDeEmpresa": [
//                      {
//                          "createdAt": 1561663617636,
//                          "updatedAt": 1561663617636,
//                          "id": 1,
//                          "nombre": "Adrian",
//                          "fkEmpresa": 1,
//                      }
//                  ],
//                  "createdAt": 1561663617636,
//                  "updatedAt": 1561663617636,
//                  "id": 1,
//                  "nombre": "AAAAA"
//                }
//            ]
//        """.trimIndent()
//
//        try {
//            val empresaInstancia = Klaxon()
//                .parseArray<Empresa>(json)
//
//            empresaInstancia?.forEach {
//
//                Log.i("http",
//                    "Nombre ${it.nombre}")
//
//                Log.i("http",
//                    "Id ${it.id}")
//
//                Log.i("http",
//                    "Fecha ${it.fechaCreacion}")
//
//                it.usuariosDeEmpresa.forEach {
//                    Log.i("http",
//                        "Nombre ${it.nombre}")
//                    Log.i("http",
//                        "FK ${it.fkEmpresa}")
//                }
//
//            }
//        } catch (e:Exception){
//            Log.i("http","${e.message}")
//            Log.i("http",
//                "Error instanciando la empresa")
//        }
//
//
//
// //////////////////////////////////////////////
//        val url = "http://172.31.104.91:1337/empresa/1"
//
//        url.httpGet()
//            .responseString { request, response, result ->
//                when (result) {
//                    is Failure -> {
//                        val ex = result.getException()
//                        Log.i("http", "Error: ${ex.message}")
//                    }
//                    is Success -> {
//                        val data = result.get()
//                        Log.i("http", "Data: ${data}")
//
//                        val empresaParseada = Klaxon().parse<Empresa>(data)
//                        if (empresaParseada != null) {
//                            Log.i("http", "iiiiiiiiiiiiii")
//                            Log.i("http", "${empresaParseada.nombre}")
//                            Log.i("http", "${empresaParseada.id}")
//                        }
//                    }
//                }
//            }

////////////////////////////////////////////////////////////////////////////////////
        // node app.js -> package.json
        val url = "http://172.31.104.91:1337/empresa"

        val parametrosCrearEmpresa = listOf(
            "nombre" to "Cristian",
            "apellido" to "Betancourt",
            "sueldo" to 12.20,
            "casado" to false,
            "hijos" to null
        )

        url.httpPost(parametrosCrearEmpresa).responseString { request, response, result ->
            when (result) {
                is Failure -> {
                    val ex = result.getException()
                    Log.i("http", "Error: ${ex.message}")
                }
                is Success -> {
                    val data = result.get()
                    Log.i("http", "Data: ${data}")

                }
            }

        }
    }
}

