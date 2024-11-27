class Song(
    val title: String,
    val artist: String,
    val yearPublished: Int,
    val playCount: Int
)
{
    val popular: Boolean 
        get() = playCount >= 1000
    fun printDescription() {
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}
fun main()
{
    val brunoSong = Song("We Don't Talk About Bruno", "Encanto Cast", 2022, 200)
    brunoSong.printDescription()
    println(brunoSong.popular)
}