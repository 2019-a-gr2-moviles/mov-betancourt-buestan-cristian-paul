package com.example.appzapatos.modulo_compras

import com.example.appzapatos.clases_auxiliares.ClienteAux
import com.example.appzapatos.clases_auxiliares.ZapatoAux

class Compra(
    var id: Int?,
    var fecha: String?,
    var cantidad: Int?,
    var total: Double?,
    var validez: Boolean?,
    var codigoCli: ClienteAux?,
    var codigoZap: ZapatoAux?

) {

}