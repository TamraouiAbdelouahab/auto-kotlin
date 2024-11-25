fun main()
{


    val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars") 
    val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
    val solarSystem = rockPlanets + gasPlanets
    
    solarSystem[3] = "Little Earth"
    println(solarSystem[3])
    // solarSystem[8] = "Pluto" //Index 8 out of bounds for length 8

    for(planet in solarSystem)
    {
        println(planet)
    }
    // hors de cours


}

















    // for (element in solarSystem) {
    //     println(element)
    // }