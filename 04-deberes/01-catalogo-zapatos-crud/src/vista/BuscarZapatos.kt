package vista

import controlador.ListaZapatos
import modelo.Zapato
import java.awt.CardLayout
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTable
import javax.swing.table.DefaultTableModel

class BuscarZapatos(title: String, listaZapatos: ListaZapatos) : JFrame() {
    val panel: JPanel = JPanel()
    val tabla: JTable = JTable()
    val listaZapatos: ListaZapatos

    init {
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

        modelo.addColumn("CODIGO")
        modelo.addColumn("COLOR")
        modelo.addColumn("TALLA")
        modelo.addColumn("TIPO")
        modelo.addColumn("MARCA")
        modelo.addColumn("CANTIDAD")
        modelo.addColumn("PRECIO")

        modelo.addRow(arrayOf("CODIGO", "COLOR", "TALLA", "TIPO", "MARCA", "CANTIDAD", "PRECIO"))

        listaZapatos.obtenerZapatos().forEach { zapatoActual: Zapato ->
            modelo.addRow(
                arrayOf(
                    zapatoActual.getCodigo(),
                    zapatoActual.getColor(),
                    zapatoActual.getTalla(),
                    zapatoActual.getTipo(),
                    zapatoActual.getMarca(),
                    zapatoActual.getCantidad(),
                    zapatoActual.getPrecio()
                )
            )
            println(zapatoActual.toString())
        }
        return modelo
    }

}
