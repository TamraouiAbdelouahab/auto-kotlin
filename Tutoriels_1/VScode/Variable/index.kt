fun main() {
   
    val name: String = "Alice" 
    val age = 25                     
    val pi: Double = 3.14159         
    val isKotlinFun = true           
    val initial: Char = 'A' 

    println("Nom: $name")
    println("Âge: $age")
    println("Pi: $pi")
    println("Est-ce que Kotlin est fun? $isKotlinFun")
    println("Initiale: $initial")

    var mutableAge: Int = 30         
    var height = 1.75                
    var isRaining: Boolean = false   

    mutableAge = 31
    height = 1.80
    isRaining = true

    println("Nouvel âge: $mutableAge")
    println("Nouvelle taille: $height")
    println("Est-ce qu'il pleut? $isRaining")
    val a = 10
    val b = 5

    
    val sum = a + b
    println("Addition : $a + $b = $sum")

    val difference = a - b
    println("Soustraction : $a - $b = $difference")

    val product = a * b
    println("Multiplication : $a * $b = $product")

    val quotient = a / b
    println("Division : $a / $b = $quotient")

    val remainder = a % b
    println("Modulo : $a % $b = $remainder")

    val x = true
    val y = false

    val andResult = x && y
    println("ET logique : $x && $y = $andResult")

    val orResult = x || y
    println("OU logique : $x || $y = $orResult")

    val notResult = !x
    println("NON logique : !$x = $notResult")

    println("Comparaison : a > b = ${a > b}")
    println("Comparaison : a == b = ${a == b}")
}