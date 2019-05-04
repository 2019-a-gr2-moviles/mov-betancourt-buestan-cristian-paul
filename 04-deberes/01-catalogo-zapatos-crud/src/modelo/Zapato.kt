package modelo

import java.io.Serializable

class Zapato : Serializable {

    private var color: String
    private var tipo: String
    private var talla: Int
    private var codigo: String
    private var marca: String
    private var cantidad: Int
    private var precio: Double

    constructor(color: String, tipo: String, talla: Int, codigo: String, marca: String, cantidad: Int, precio: Double) {
        this.color = color
        this.tipo = tipo
        this.talla = talla
        this.codigo = codigo
        this.marca = marca
        this.cantidad = cantidad
        this.precio = precio
    }

    fun getColor(): String {
        return color
    }

    fun setColor(color: String) {
        this.color = color
    }

    fun getTalla(): Int {
        return talla
    }

    fun setTalla(talla: Int) {
        this.talla = talla
    }

    fun getTipo(): String {
        return tipo
    }

    fun setTipo(tipo: String) {
        this.tipo = tipo
    }

    fun getCodigo(): String {
        return codigo
    }

    fun getMarca(): String {
        return marca
    }

    fun setMarca(marca: String) {
        this.marca = marca
    }

    fun getCantidad(): Int{
        return cantidad
    }

    fun setCantidad(cantidad: Int){
        this.cantidad=cantidad
    }

    fun getPrecio(): Double{
        return precio
    }

    fun setPrecio(precio: Double){
        this.precio=precio
    }

    override fun toString(): String {
        return "Codigo: $codigo\n" +
                "Color: $color\n" +
                "Talla: $talla\n" +
                "Tipo: $tipo\n" +
                "Marca: $marca\n" +
                "Cantidad: $cantidad\n" +
                "Precio: $precio"
    }
}