val hello:(name:String) -> String = {name -> "Hello $name"}
fun main() {
    repeat(5) { it ->
        println("Bonjour, c'est l'iteration numero $it")
    }
    println("   #####HelloFunction#####     ")
    val names = arrayOf("Abdelouahab","Ayoub","Mohamed","Fouad","Aymane","Yahya","Oussama","Yassine")
    repeat(7)
    { it ->
        println(hello(names[it]))
    }
}
