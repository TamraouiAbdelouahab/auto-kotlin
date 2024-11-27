fun main() {
    sayHello()                         
    greetUser("Alice")                 
    val sumResult = add(5, 3)          
    println("Résultat de l'addition : $sumResult")

    val areaResult = calculateRectangleArea(5.0, 3.0)  
    println("Aire du rectangle : $areaResult")

    val maxNumber = findMax(4, 9)
    println("Le nombre le plus grand est : $maxNumber")
    var a = 12;
    var b = 15;
}

fun sayHello() {
    println("Bonjour tout le monde !")
}


fun greetUser(name: String) {
    println("Bonjour, $name!")
}


fun add(a: Int, b: Int): Int {
    return a + b
}


fun calculateRectangleArea(length: Double, width: Double): Double {
    return length * width
}

fun findMax(a: Int, b: Int): Int {
    return if (a > b) a else b;

}
