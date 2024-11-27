
// fonction avec paramètre color
fun ColorCheck(color: String)
{
    if (color == "Red") {
        println("Stop")
    } else if (color == "Yellow") {
        println("Slow")
    } else if (color == "Green") {
        println("Go")
    } else {
        println("Invalid traffic-light color")
    }
}

fun ColorCheck2(color: String)
{
    val message =
      if (color == "Red") "Stop"
      else if (color == "Yellow") "Slow"
      else if (color == "Green") "Go"
      else "Invalid traffic-light color"
     println(message);
    
}

fun main() {
    var trafficLightColor = "Red";
    print("Red : ");
    ColorCheck(trafficLightColor); 
    
    trafficLightColor = "Yellow";
    print("Yellow : ");
    ColorCheck(trafficLightColor)
    

    trafficLightColor = "Green";
    print("Green : ");
    ColorCheck(trafficLightColor)
    ColorCheck2(trafficLightColor)


    trafficLightColor = "Black";
    print("Another color : ");
    ColorCheck(trafficLightColor)



    

}