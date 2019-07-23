package com.example.examen2b.valoresEstaticos

class Servidor {

    companion object {

        private val ip = "192.168.0.106"
        private val puerto = "1337"

        fun url(ruta: String): String {
            var rutaAux = ""
            when (ruta) {
                "paciente" -> rutaAux = "paciente"
                "medicamento" -> rutaAux = "medicamento"
                else -> rutaAux = ""
            }
            return "http://$ip:$puerto/${rutaAux}"
        }
    }
}