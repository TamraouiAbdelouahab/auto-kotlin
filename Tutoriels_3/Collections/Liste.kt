fun main()
{
    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    


    println(solarSystem.size) // afficher la taille de la liste
    println(solarSystem[2]) // afficher element 3 parcequ'il Commence 0
    println(solarSystem.get(3)) // afficher element 2
    println(solarSystem.indexOf("Earth")) // afficher index de "Earth"
    println(solarSystem.indexOf("Pluto"))  // afficher -1 parcequ'il n'exite pas dans liste
    println(solarSystem.contains("Pluto")) // afficher false car Pluto n'existe pas dans liste 
    println("Future Moon" in solarSystem) // meme chose (verifier element se trouve dans liste )

    for (planet in solarSystem) {
        println(planet)
    }
    println("################")
    // listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    solarSystem.add("Pluto") // ajouter élément a fin de la liste
    solarSystem.add(3, "Theia") // ajouter élément avec indice spécifique
    solarSystem[3] = "Future Moon" // modifier element de indice 3
    solarSystem.removeAt(9)  // Supprimer element 9
    solarSystem.remove("Future Moon") // Supprimer "Future Moon"
    for (planet in solarSystem) { 
        println(planet)
    }
    println(solarSystem)

 
}