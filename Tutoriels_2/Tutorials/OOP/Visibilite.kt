// open class SmartDevice(val name: String, val category: String) {

//     var deviceStatus = "online"
//         get() = field
//         set(value)
//         {
//             field = value
//         }
// }
class Person
{
    private var Name: String? = null
        get() = field
        set(value) {
            field = value
        }
    var Age: Int? = null
    
    constructor(Name:String,Age:Int)
    {
        this.Name = Name
        this.Age = Age
    }
    
    public fun GetInfo()
    {
        println("Nom: $Name, Âge: $Age ans");
    }


}
fun main()
{
    // val smartDevice = SmartDevice("Android TV", "Entertainment");
    // smartDevice.deviceStatus = "offline"
    // println(smartDevice.getdeviceStatus());

    val person = Person("Abdel",20)
    println(person.Age)
    person.GetInfo();

}