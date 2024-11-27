val coins :(Int)->String = {
    "$it quarters"
}

fun main()
{
    println(coins(19))
    var square :(Int) -> Int = {a -> a*a}
    println(square(5))
}