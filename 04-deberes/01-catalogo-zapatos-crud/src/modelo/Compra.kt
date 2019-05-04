package modelo

import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Compra : Serializable {
    private var numeroCompra: Int
    private var fechaCompra: Date
    private var nombre: String
    private var apellido: String
    private var cedula: String
    private var listaCodigosZapatos: HashMap<String, Int>
    private var valorTotal: Double
    private var validez: Boolean

    constructor(
        numeroCompra: Int,
        fechaCompra: Date,
        nombre: String,
        apellido: String,
        cedula: String,
        listaCodigosZapatos: HashMap<String, Int>,
        valorTotal: Double,
        validez: Boolean
    ) {
        this.numeroCompra = numeroCompra
        this.fechaCompra = fechaCompra
        this.nombre = nombre
        this.apellido = apellido
        this.cedula = cedula
        this.listaCodigosZapatos = listaCodigosZapatos
        this.valorTotal = valorTotal
        this.validez = validez
    }

    fun getNumeroCompra(): Int {
        return numeroCompra
    }

    fun getFechaCompra(): Date {
        return fechaCompra
    }

    fun getNombre(): String {
        return nombre
    }

    fun getApellido(): String {
        return apellido
    }

    fun getCedula(): String {
        return cedula
    }

    fun getListaCodigosZapatos(): HashMap<String, Int> {
        return listaCodigosZapatos
    }

    fun getValorTotal(): Double {
        return valorTotal
    }

    fun getValidez(): Boolean {
        return validez
    }

    fun setValidez(validez: Boolean) {
        this.validez = validez
    }

    override fun toString(): String {
        var string = "Numero de compra: $numeroCompra\n" +
                "Fecha: $fechaCompra\n" +
                "Nombre: $nombre\n" +
                "Apellido: $apellido\n" +
                "Cedula: $cedula\n"

        listaCodigosZapatos.forEach { codigo: String, cantidad: Int ->
            string += "\t Codigo: $codigo => Cantidad: $cantidad\n"
        }
        string += "Valor total: $valorTotal"
        return string
    }


}