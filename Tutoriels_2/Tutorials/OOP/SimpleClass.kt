class SmartDevice  {
    val name = "Android TV"
    val category = "Entertainment"
    var deviceStatus = "online"
    fun turnOn() {
        println("Smart device is turned on.")
    }
    fun turnOff() {
        println("Smart device is turned off.")
    }

    // Getters and Setters
    var speakerVolume = 2
    get() = field
    set(value) {
        field = value
    }
    
}
fun main() {
    val smartTvDevice = SmartDevice ();
    println("Device name is: ${smartTvDevice.name}")
    smartTvDevice.turnOn();
    smartTvDevice.turnOff();
    // Getters and setter (Encapsulation)
    smartTvDevice.speakerVolume = 19;
    println(smartTvDevice.speakerVolume);
}