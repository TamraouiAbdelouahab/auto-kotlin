import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class Note(initialValue: Int,private val minValue: Int,private val maxValue: Int) : ReadWriteProperty<Any?, Int> {

    var  fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int{
        return fieldData;
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

// Valeur positif 
class PositiveIntDelegate : ReadWriteProperty<Any?, Int> {
    private var value: Int = 0

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return value
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value >= 0) {
            this.value = value
        } else {
            throw IllegalArgumentException("${property.name} doit etre positif.")
        }
    }
}

class LazyExample {
    val lazyValue: String by lazy {
        
        "Hello, Kotlin!"  
    }
}


fun main()
{
    var note by Note(initialValue = 17,minValue = 0,maxValue = 20)

    note = 200

    println(note);

    var age by PositiveIntDelegate();

    age = 30;
    println(age)
    try {
        age = -5  // Cela va déclencher une exception
    } catch (e: IllegalArgumentException) {
        println(e.message)  // Affiche l'erreur
    }

    println(age)

    println("######## laztDelegate #########")
    val example = LazyExample()

    println(example.lazyValue)
    println(example.lazyValue)
    // println("Accès à lazyValue une deuxième fois : ${example.lazyValue}")  

}