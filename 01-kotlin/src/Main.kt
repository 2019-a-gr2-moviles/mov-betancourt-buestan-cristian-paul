fun main (args: Array<String>){

    /*Comentario*/
    // Variables

    // Mutables
    var numero = 5
    numero=6

    // Inmutables
    val nombre: String = "Cristian"
    val apellido: String = "Betancourt"
    val edad: Int = 29
    val sueldo: Double = 45.23
    val casado: Boolean = false
    val profesor: Boolean = true
    val hijos = null

    // Condicionales
    if(nombre == "Cristian" ) {
        println("Verdadero")
    }else{
        println("Falso")
    }

    val tieneNombreYApellido = if (apellido!=null && nombre!=null) "ok" else "no"
    println(tieneNombreYApellido)

    estaJalado(1.0)
    estaJalado(10.0)
    estaJalado(7.0)
    estaJalado(4.0)
    estaJalado(0.0)

}


fun estaJalado(nota: Double){
    when (nota) {
         7.0 -> {
    println("Pasaste con las justas")
         }
        10.0-> {
            println("Felicitaciones")

        }
        0.0-> {
            println("Vago")

        }
        else -> {
            println("Tu nota es: $nota")
            println("Tu nota es: ${nota}")

        }
        }
    }

