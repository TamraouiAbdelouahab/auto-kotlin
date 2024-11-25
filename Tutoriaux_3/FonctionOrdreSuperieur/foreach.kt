
fun afficherCookies() {
    cookies.forEach {it ->
        println("Menu item: ${it.name}, Soft Baked: ${it.softBaked}, Has Filling: ${it.hasFilling}, Price: $${it.price}")
    }
}

fun main() {
    afficherCookies()  // Appelle la fonction pour afficher les cookies
}
