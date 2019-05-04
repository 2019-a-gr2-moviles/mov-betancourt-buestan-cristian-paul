package vista

import controlador.ListaCompras
import controlador.ListaZapatos
import java.awt.*
import javax.swing.*

class Menu(title: String) : JFrame() {

    private val boton1: JButton = JButton("Ver zapatos")
    private val boton2: JButton = JButton("Actualizar zapatos")
    private val boton3: JButton = JButton("Borrar zapatos")
    private val boton4: JButton = JButton("Insertar zapatos")
    private val boton5: JButton = JButton("Ver compras")
    private val boton6: JButton = JButton("Modificar compras")
    private val boton7: JButton = JButton("Eliminar compras")
    private val boton8: JButton = JButton("Ingresar compras")
    private val panel: JPanel = JPanel()
    private val listaZapatos: ListaZapatos = ListaZapatos()
    private val listaCompras: ListaCompras = ListaCompras()

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        setTitle(title)
        boton1.setSize(100, 10)
        boton2.setSize(100, 10)
        boton3.setSize(100, 10)
        boton4.setSize(100, 10)
        boton5.setSize(100, 10)
        boton6.setSize(100, 10)
        boton7.setSize(100, 10)
        boton8.setSize(100, 10)

        panel.layout = FlowLayout()
        panel.add(boton1)
        panel.add(boton2)
        panel.add(boton3)
        panel.add(boton4)
        panel.add(JSeparator())
        panel.add(boton5)
        panel.add(boton6)
        panel.add(boton7)
        panel.add(boton8)

        this.add(panel)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(600, 115)
        setLocationRelativeTo(null)
    }

    internal fun showEventDemo() {

        boton1.apply {
            addActionListener {
                BuscarZapatos("ZAPATOS", listaZapatos).show()
            }
        }
        boton2.apply {
            addActionListener {
                val frameActualizar = ModificarZapatos("ACTUALIZAR ZAPATOS", listaZapatos)
                frameActualizar.showEventDemo()
                frameActualizar.show()
            }
        }
        boton3.apply {
            addActionListener {
                val frameEliminar = EliminarZapatos("ELIMINAR ZAPATOS", listaZapatos)
                frameEliminar.showEventDemo()
                frameEliminar.show()
            }
        }

        boton4.apply {
            addActionListener {
                val frameInsertar = InsertarZapatos("INSERTAR ZAPATOS", listaZapatos)
                frameInsertar.showEventDemo()
                frameInsertar.show()
            }
        }

        boton5.apply {
            addActionListener {
                val frameBuscarCompra = BuscarCompras("LISTA DE COMPRAS", listaCompras, listaZapatos)
                frameBuscarCompra.show()
            }
        }

        boton6.apply {
            addActionListener {
                val frameModificarCompra = ModificarCompra("MODIFICAR COMPRA", listaCompras, listaZapatos)
                frameModificarCompra.showEventDemo()
                frameModificarCompra.show()
            }
        }
        boton7.apply {
            addActionListener {
                val frameEliminarCompra = EliminarCompra("ELIMINAR COMPRA", listaCompras, listaZapatos)
                frameEliminarCompra.showEventDemo()
                frameEliminarCompra.show()
            }
        }

        boton8.apply {
            addActionListener {
                val frameInsertarCompra = InsertarCompra("INSERTAR COMPRA", listaCompras, listaZapatos)
                frameInsertarCompra.showEventDemo()
                frameInsertarCompra.show()
            }
        }

    }
}