val trick = {
    println("No treats!")
}

fun trickFunction1()
{
    println("TrickFunction")
}
// fonction avec element de return (paramétres "option" ) -> type de return  
val treat: () -> Unit = {
    println("Have a treat!")
}
// fonction avec paramétre boolean, return trick ou treat ça dépend paremetre 
fun trickOrTreat(isTrick: Boolean, extraTreat: (Int) -> String): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        println(extraTreat(5))
        return treat
    }
}
fun trickOrTreatV2(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
    }

val coins: (Int) -> String = { quantity ->
    "$quantity quarters"
}
val cupcake: (Int) -> String = {
    "Have a cupcake!"
}
fun main()
{
    println("########## TreatOrTrick Function ##########")
    val treatFunctionBoolean = trickOrTreat(false,coins)
    val trickFunctionBoolean = trickOrTreat(true,cupcake)
    treatFunctionBoolean()
    trickFunctionBoolean()
    println("########## TreatOrTrick Function With Null Function ##########")
    val treatFunction = trickOrTreatV2(false, coins)
    val trickFunction = trickOrTreatV2(true, null)
    treatFunction()
    trickFunction()
    

}