package controlador

import modelo.Compra
import modelo.Zapato
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class ListaCompras : Serializable {

    private var listaZapatos: ArrayList<Zapato>
    private var listaCompras: ArrayList<Compra>

    init {
        listaCompras = LeerEscribirArchivo.leerArchivoCompras()
        listaZapatos = obtenerListaZapatos()
        if (listaZapatos == null) {
            listaZapatos = ArrayList<Zapato>()
        }

        if (listaCompras == null) {
            listaCompras = ArrayList<Compra>()
        }

    }

    fun obtenerCompras(): ArrayList<Compra> {
        return listaCompras
    }

    private fun obtenerListaZapatos(): ArrayList<Zapato> {
        return LeerEscribirArchivo.leerArchivoZapatos()
    }

    fun existeZapato(codigo: String): Boolean {
        return listaZapatos.filter { zapatoActual: Zapato -> zapatoActual.getCantidad() > 0 }
            .any { zapatoActual: Zapato -> zapatoActual.getCodigo() == codigo }
    }

    fun existeZapatos(codigo: String, cantidad: Int): Boolean {
        val cantidad = 0
        listaZapatos.forEach { zapatoActual: Zapato ->
            if ((zapatoActual.getCodigo() == codigo) && (zapatoActual.getCantidad() > 0)) {
                println(zapatoActual.toString())
            }
        }
        return listaZapatos.any { zapatoActual: Zapato ->
            ((zapatoActual.getCodigo() == codigo) && (zapatoActual.getCantidad() >= cantidad))
        }

    }

    fun obtenerValorTotal(listaCodigosZapatos: HashMap<String, Int>): Double {
        var valorTotal: Double = 0.0

        listaCodigosZapatos.forEach { codigo, cantidad ->
            listaZapatos.forEach { zapatoActual: Zapato ->
                if (zapatoActual.getCodigo() == codigo) {
                    valorTotal += (zapatoActual.getPrecio() * cantidad.toDouble())
                }
            }
        }
        return valorTotal
    }

    fun ingresarCompra(
        fecha: Date,
        nombre: String,
        apellido: String,
        cedula: String,
        listaCodigosZapatos: HashMap<String, Int>
    ) {

        listaCodigosZapatos.forEach { (codigoZapato: String, cantidad: Int) ->
            listaZapatos.map { zapatoActual: Zapato ->
                if (zapatoActual.getCodigo() == codigoZapato) {
                    zapatoActual.setCantidad(zapatoActual.getCantidad() - cantidad)
                }
            }
        }
        var numeroCompra = 1
        listaCompras.forEach { compra: Compra ->
            if (compra.getNumeroCompra() >= numeroCompra) numeroCompra = compra.getNumeroCompra()
        }

        listaCompras.add(
            Compra(
                numeroCompra,
                fecha,
                nombre,
                apellido,
                cedula,
                listaCodigosZapatos,
                obtenerValorTotal(listaCodigosZapatos),
                true
            )
        )
        guardarListaZapatos()
        guardarListaCompras()
    }

    fun existe(numeroCompra: Int): Boolean {
        return listaCompras.any { compra: Compra ->
            compra.getNumeroCompra() == numeroCompra
        }
    }

    fun obtenerCompra(numeroCompra: Int): String {
        return listaCompras.filter { compra: Compra ->
            compra.getNumeroCompra() == numeroCompra
        }.get(0).toString()
    }

    fun eliminarCompra(numeroCompra: Int) {
        restaurarNumeroZapatos(numeroCompra)

        val listaComprasAux = listaCompras.filter { compra: Compra ->
            compra.getNumeroCompra() != numeroCompra
        }

        listaCompras = listaComprasAux as ArrayList<Compra>
        guardarListaZapatos()
        guardarListaCompras()

    }

    fun restaurarNumeroZapatos(numeroCompra: Int) {
        val aBorrar = listaCompras.filter { compra: Compra ->
            compra.getNumeroCompra() == numeroCompra
        }

        aBorrar.get(0).getListaCodigosZapatos().forEach { codigo: String, cantidad: Int ->
            listaZapatos.map { zapato: Zapato ->
                if (zapato.getCodigo() == codigo) {
                    zapato.setCantidad(zapato.getCantidad() + cantidad)
                }
            }
        }
    }

    fun modificarCompra(numeroCompra: Int) {
        val listaCompraAux = listaCompras.map { compra: Compra ->
            if (compra.getNumeroCompra() == numeroCompra) {
                compra.setValidez(false)
            }
        }
        guardarListaZapatos()
        guardarListaCompras()
    }

    fun guardarListaZapatos() {
        LeerEscribirArchivo.escribirArchivoZapatos(listaZapatos)
    }

    fun guardarListaCompras() {
        LeerEscribirArchivo.escribirArchivoCompras(listaCompras)
    }

}