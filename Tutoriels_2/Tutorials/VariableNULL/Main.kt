fun main() {
    var favoriteActor: String? = "Abdel"
    println(favoriteActor!!.length) 

    println("--------------------------------")

    favoriteActor = null
    println(favoriteActor?.length)

    println("--------------------------------")

    var number: Int? = 19
    println(number)

    println("--------------------------------")

    number = null
    println(number)
    
    println("--------------------------------")

    var name: String? = "abdelouahab";

    if (name != null) {
        println("The number of characters in name is ${name.length}.")
    }
    else {
        println("You didn't input a name.")
    }


    println("--------------------------------")
    var length: Int = 
    if(name != null) name.length
    else 0 ;
    println("length of name is : " + length)


    println("--------------------------------")
    
    val lengthOfName = name?.length ?: 0
    
    println("Length is :  $lengthOfName.")

    println("--------------------------------")
    val lengthName = name?.length ?: 0

    println(lengthName)
}