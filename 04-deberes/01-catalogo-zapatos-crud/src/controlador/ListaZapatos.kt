package controlador

import modelo.Zapato
import java.io.Serializable

class ListaZapatos() : Serializable {


    private var zapatos: ArrayList<Zapato>

    init {
        zapatos = LeerEscribirArchivo.leerArchivoZapatos()
        if (zapatos == null) {
            println("entro nulo")
            zapatos = ArrayList<Zapato>()
        }
    }

    fun obtenerZapatos(): ArrayList<Zapato> {
        return zapatos
    }

    fun actualizarZapato(
        color: String,
        tipo: String,
        talla: Int,
        codigo: String,
        marca: String,
        cantidad: Int,
        precio: Double
    ) {
        println("cambio $codigo, $talla, $color, $tipo, $marca")
        zapatos.map { zapatoActual: Zapato ->
            if (zapatoActual.getCodigo() == codigo) {
                zapatoActual.setTalla(talla)
                zapatoActual.setColor(color)
                zapatoActual.setTipo(tipo)
                zapatoActual.setMarca(marca)
                zapatoActual.setCantidad(cantidad)
                zapatoActual.setPrecio(precio)
            }
        }
        guardarLista()
    }

    fun existe(codigo: String): Boolean {
        return zapatos.any { zapato: Zapato ->
            zapato.getCodigo().equals(codigo)
        }
    }

    fun eliminarZapato(codigo: String) {

        val zapatosAux = zapatos.filter { zapatoActual: Zapato ->
            zapatoActual.getCodigo() != codigo
        }
        igualarLista(zapatosAux as ArrayList<Zapato>)
        guardarLista()
    }

    fun insertarZapato(
        color: String,
        tipo: String,
        talla: Int,
        codigo: String,
        marca: String,
        cantidad: Int,
        precio: Double
    ) {
        zapatos.add(Zapato(color, tipo, talla, codigo, marca, cantidad, precio))
        guardarLista()
    }

    private fun guardarLista() {
        LeerEscribirArchivo.escribirArchivoZapatos(zapatos)
    }

    private fun igualarLista(zapatosAux: ArrayList<Zapato>) {
        this.zapatos = zapatosAux
    }

    fun obtenerZapato(codigo: String): String {
        if (existe(codigo)) {
            return zapatos.filter { zapatoAux: Zapato -> zapatoAux.getCodigo() == codigo }.get(0).toString()
        }
        return ""
    }

}