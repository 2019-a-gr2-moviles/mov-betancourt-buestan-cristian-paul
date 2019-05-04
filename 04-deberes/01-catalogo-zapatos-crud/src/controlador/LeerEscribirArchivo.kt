package controlador

import modelo.Compra
import modelo.Zapato
import java.io.IOException
import java.io.FileNotFoundException
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.io.FileOutputStream
import java.io.ObjectOutputStream
import java.io.Serializable


class LeerEscribirArchivo {

    companion object {
        private var rutaArchivo: String = ""
        private var nombreArchivoZapatos: String = "listaZapatos.zp"
        private var nombreArchivoCompras: String = "listaCompras.zp"

        fun leerArchivoZapatos(): ArrayList<Zapato> {

            var arregloZapatos: ArrayList<Zapato> = ArrayList<Zapato>()
            try {
                var lectorArchivo = ObjectInputStream(FileInputStream(rutaArchivo + nombreArchivoZapatos))
                arregloZapatos = lectorArchivo.readObject() as ArrayList<Zapato>
            } catch (fnfex: FileNotFoundException) {
                //fnfex.printStackTrace()
            } catch (ioex: IOException) {
                //ioex.printStackTrace()
            } catch (cnfex: ClassNotFoundException) {
                // cnfex.printStackTrace()
            }
            return arregloZapatos
        }

        fun escribirArchivoZapatos(listaZapatos: ArrayList<Zapato>) {
            try {
                val escritorArchivo = ObjectOutputStream(FileOutputStream(rutaArchivo + nombreArchivoZapatos))
                escritorArchivo.writeObject(listaZapatos as Serializable)
            } catch (fnfex: FileNotFoundException) {
                fnfex.printStackTrace()
            } catch (ioex: IOException) {
                ioex.printStackTrace()
            }

        }


        fun leerArchivoCompras(): ArrayList<Compra> {

            var arregloCompras: ArrayList<Compra> = ArrayList<Compra>()
            try {
                var lectorArchivo = ObjectInputStream(FileInputStream(rutaArchivo + nombreArchivoCompras))
                arregloCompras = lectorArchivo.readObject() as ArrayList<Compra>
            } catch (fnfex: FileNotFoundException) {
                //fnfex.printStackTrace()
            } catch (ioex: IOException) {
                //ioex.printStackTrace()
            } catch (cnfex: ClassNotFoundException) {
                // cnfex.printStackTrace()
            }
            return arregloCompras
        }

        fun escribirArchivoCompras(listaCompras: ArrayList<Compra>) {
            try {
                val escritorArchivo = ObjectOutputStream(FileOutputStream(rutaArchivo + nombreArchivoCompras))
                escritorArchivo.writeObject(listaCompras as Serializable)
            } catch (fnfex: FileNotFoundException) {
                fnfex.printStackTrace()
            } catch (ioex: IOException) {
                ioex.printStackTrace()
            }

        }

    }

}

