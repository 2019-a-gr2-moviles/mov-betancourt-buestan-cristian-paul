package vista

import controlador.ListaCompras
import controlador.ListaZapatos
import modelo.Compra
import java.awt.CardLayout
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTable
import javax.swing.table.DefaultTableModel

class BuscarCompras(title: String, listaCompras: ListaCompras, listaZapatos: ListaZapatos) : JFrame() {
    val panel: JPanel = JPanel()
    val tabla: JTable = JTable()
    val listaZapatos: ListaZapatos
    val listaCompras: ListaCompras

    init {
        this.listaCompras = listaCompras
        this.listaZapatos = listaZapatos
        createUI(title)
    }

    private fun createUI(title: String) {
        setTitle(title)
        val layout = CardLayout()
        panel.layout = layout
        tabla.model = llenarTabla()
        panel.add(tabla)
        this.add(panel)
        //defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(600, 300)
        setLocationRelativeTo(null)
    }

    private fun llenarTabla(): DefaultTableModel {
        val modelo = DefaultTableModel()

        modelo.addColumn("NUMERO COMPRA")
        modelo.addColumn("FECHA")
        modelo.addColumn("CODIGO ZAPATO")
        modelo.addColumn("CEDULA")
        modelo.addColumn("NOMBRE")
        modelo.addColumn("APELLIDO")
        modelo.addColumn("CANTIDAD")
        modelo.addColumn("PRECIO")
        modelo.addColumn("VALIDEZ")


        modelo.addRow(
            arrayOf(
                "NUMERO COMPRA",
                "FECHA",
                "CODIGO ZAPATO",
                "CEDULA",
                "NOMBRE",
                "APELLIDO",
                "CANTIDAD",
                "PRECIO",
                "VALIDEZ"
            )
        )

        listaCompras.obtenerCompras().forEach { compra: Compra ->
            val fecha = compra.getFechaCompra()
            var validez = ""
            if (compra.getValidez()) {
                validez = "VAL"
            } else {
                validez = "NV"
            }
            compra.getListaCodigosZapatos().forEach { codigo, cantidad ->

                modelo.addRow(
                    arrayOf(
                        compra.getNumeroCompra(),
                        "${fecha.year}/${fecha.month}/${fecha.day} - ${fecha.hours}:${fecha.minutes}:${fecha.seconds}",
                        codigo,
                        compra.getCedula(),
                        compra.getNombre(),
                        compra.getApellido(),
                        cantidad,
                        compra.getValorTotal(),
                        validez
                    )
                )
            }

        }
        return modelo
    }

}
