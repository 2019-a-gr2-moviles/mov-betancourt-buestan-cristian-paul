import controlador.*
import modelo.Zapato
import vista.*
import javax.swing.JOptionPane

fun main(args: Array<String>) {

    /*var zapato: Zapato = Zapato ("rojo","hombre", 34, "H-01", "Nike")
    var zapatos: ArrayList<Zapato> = arrayListOf<Zapato>(zapato)
    zapatos.add(Zapato("verde", "mujer", 30, "M-01", "Adidas"))
    //print(zapatos)
    //zapatos.forEach { valor: Zapato -> print(valor.getColor())}

    //LeerEscribirArchivo.escribirArchivo(zapatos)*/
    /*var zapatos = LeerEscribirArchivo.leerArchivo()
    zapatos.forEach { valor: Zapato -> print(valor.getColor())}*/
    //val zap: ArrayList<Zapato> = LeerEscribirArchivo.leerArchivo()
    //zap.forEach { valor: Zapato -> print(valor.getColor())}

    //val crud = ListaZapatos()
    /*crud.actualizarZapato("verde", "mujer", 25, "H-01", "Rol")
    crud.insertarZapato("rojo","hombre", 34, "M-02", "Nike")
    crud.eliminarZapato("H-01")
    crud.guardarLista()*/


    //val aux = crud.obtenerZapatos()
   // aux.forEach { zapato: Zapato -> println(zapato.toString()) }

    val frame: Menu = Menu("CATÁLOGO DE ZAPATOS")
    frame.showEventDemo()
    frame.show()

    //val tabla = Tabla("Tabla")
    //tabla.show()

}