import kotlin.reflect.KProperty

class Person(val name: String, var age: Int)

fun printProperty(property: KProperty<*>, person: Person) {
    println("La propriete '${property.name}' a pour valeur : ${property.getter.call(person)}")
}

fun main() {
    val person = Person("Alice", 30)
    val property = Person::age  // On obtient la référence de la propriété `age`
    
    printProperty(property, person)

}