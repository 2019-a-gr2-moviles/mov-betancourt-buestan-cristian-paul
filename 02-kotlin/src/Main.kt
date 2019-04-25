class Usuario (val cedula: String){
    public var nombre: String = ""
    public var apellido: String = ""

    constructor(cedulaM: String, apellido: String): this(cedulaM){
        this.apellido = apellido
    }




}

class UsuarioKT(public var nombre: String,
                public val apellido:String,
                private var id: Int,
                protected var id1: Int
){
    init{

    }

    public fun hola(): String{
        return this.apellido
    }

    private fun hola2(){

    }

    protected fun hola3(){

    }

    companion object{
        val gravedad = 10.5
        fun correr(){
            println("Estoy corriendo en $gravedad")
        }
    }
}

fun a() {
    var cristian = UsuarioKT("a", "b", 21312,345)
    cristian.nombre = "Paul"
}

class Numero(id: Int) {
    constructor(numeroString: String): this (numeroString.toInt()){
        println("CONSTRUCTOR")
    }

    init{
        println("INIT")
    }
}

open class Numeros(var numeroUno: Int,
              var numeroDos: Int){

}

class Suma( var numeroUnos: Int,
            var numeroDoss:Int) : Numeros(numeroUnos,numeroDoss){

}

// ? a veces será nulo
fun presley(requerido: Int, opcional:Int= 1, nulo: UsuarioKT?){
    if(nulo!=null){
        nulo.nombre
    }
    val nombresito: String? = nulo?.nombre.toString()
    nulo!!.nombre
    nombresito.toString()
}

fun main(args: Array <String>){
    //val numerito = Numero(1.toString());
    val numerito = Numero(1);

    var numero = Suma(1,2)
    presley(requerido = 1, nulo= null) // Named parameters
    presley(requerido = 1,opcional = 1,nulo = null)


}