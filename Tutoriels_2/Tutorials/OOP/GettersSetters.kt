class SmartDevice {

    var speakerLight = 4
    get() = field
    set(value) {
        if(value <= 100)
        field = value
        else 
        field = 0
        
    }
    var speakerVolume = 2
    get() = field
    set(value) {
        field = value
    }
    fun turnOn() {
        println("Smart device is turned on.")
    }

    fun turnOff() {
        println("Smart device is turned off.")
    }
}
fun main()
{
    val smartdevice = SmartDevice();
    smartdevice.speakerLight = 12;
    println(smartdevice.speakerLight)
}