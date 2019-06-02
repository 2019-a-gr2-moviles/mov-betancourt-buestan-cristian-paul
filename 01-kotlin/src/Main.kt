import java.text.SimpleDateFormat

fun main(args: Array<String>) {
    println(SimpleDateFormat("dd/mm/yyyy").parse("09/03/2019").toString())
    /*Comentario*/
    // Variables

    // Mutables
    var numero = 5
    numero = 6

    // Inmutables
    val nombre: String = "Cristian"
    val apellido: String = "Betancourt"
    val edad: Int = 29
    val sueldo: Double = 45.23
    val casado: Boolean = false
    val profesor: Boolean = true
    val hijos = null

    // Condicionales
    if (nombre == "Cristian") {
        println("Verdadero")
    } else {
        println("Falso")
    }

    val tieneNombreYApellido = if (apellido != null && nombre != null) "ok" else "no"
    println(tieneNombreYApellido)

    estaJalado(1.0)
    estaJalado(10.0)
    estaJalado(7.0)
    estaJalado(4.0)
    estaJalado(0.0)
    println("----------------")

    holaMundoAvanzado(0)
    val total = sumarDosNumeros(1, 2)
    println(total)

    val arregloCumpleanos = Array<Int>(4, { 1;2;3;4 })
    var arregloTodo: Array<Any?> = arrayOf("ds", 321, null, false)
    arregloCumpleanos.set(0, 3)

    val notas = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 11)


    // FOR EACH -> Itera el arreglo

    notas.forEachIndexed { indice, nota: Int ->
        println("Indice: $indice")
        println("Nota: $nota")

    }

    //FIND
    println("--------------------------------------")

    println(notas.filterIndexed { index, i -> i == 11 })

    // MAP -> Itera y modifica el arreglo
    // Impares +1
    // Pares +2
    /*val notasDos = notas.map{ nota ->
        if(nota%2==1)
            nota+1
        else
            nota+2
    }*/

    /*val notasDos = notas.map { nota ->
        when (nota % 2) {
            1 -> {
                nota + 1
            }

            else -> {
                nota + 2
            }
        }
    }

    notasDos.forEach {
        println("Notas 2: $it")
    }

    val respuestaFilter = notas.filter { nota ->
        nota in 3..5
    }.map {
        it * 2
    }
    println("000000000000000000000000000000000000000000000000000000000000000000")
   notasDos.forEach { println("$it") }

    val novias = arrayListOf<Int>(1, 2, 2, 3, 4, 5)

    val respuestaNovia = novias.any {
        it == 3
    }

    println(respuestaNovia)

    val tazos = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 7)
    val respuestaTazos = tazos.all {
        it == 1
    }
    println(respuestaTazos)

    val totalTazos = tazos.reduce { valorAcumulado, tazo ->
        valorAcumulado + tazo
    }
*/
}

fun estaJalado(nota: Double) {
    when (nota) {
        7.0 -> {
            println("Pasaste con las justas")
        }
        10.0 -> {
            println("Felicitaciones")

        }
        0.0 -> {
            println("Vago")

        }
        else -> {
            println("Tu nota es: $nota")
            println("Tu nota es: ${nota}")

        }
    }
}

fun holaMundo(mensaje: String) {
    println("Mensaje: $mensaje")
}

fun holaMundoAvanzado(mensaje: Any) {
    println("Mensaje: $mensaje")
}

fun sumarDosNumeros(numUno: Int, numDos: Int): Int {
    return numUno + numDos
}

