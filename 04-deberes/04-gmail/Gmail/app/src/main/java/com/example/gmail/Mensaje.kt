package com.example.gmail

class Mensaje{

    var remitente: String = ""
    var asunto: String = ""
    var contenido: String = ""
    var incial: String = ""

    constructor(remitente: String, asunto: String, contenido: String) {
        this.remitente = remitente
        this.asunto = asunto
        this.contenido = contenido
        this.incial = remitente.substring(0,1).toUpperCase()
    }
}