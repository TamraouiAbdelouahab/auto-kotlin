fun main()
{
    val trafficLightColor = "Amber";
    
    val message = when(trafficLightColor) {
        "Red" -> "Stop"
        "Yellow", "Amber" -> "Proceed with caution."
        "Green" -> "Go"
        else -> "Invalid traffic-light color"
    }
    println(message)
    var x = 500
    while (x > 0) {
        println(x)
        x--

    }



}