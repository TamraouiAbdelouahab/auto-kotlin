open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    open fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}
class FoldablePhone(isScreenLightOn:Boolean,var foldable:Boolean = false) : Phone(isScreenLightOn)
{
    override fun switchOn()
    {
        if(!foldable)
        super.switchOn()

    }
    fun fold()
    {
        foldable = true;
    }
    fun unfold()
    {
        foldable = false;
    }
    fun checkPhoneFoldable() {
        val phoneFoldable = if (foldable) "fold" else "unfold"
        println("The phone is $phoneFoldable.")
    }
    /*
            override fun switchOn() {
        if (!isFolded) {
            isScreenLightOn = true
        }
        }

        fun fold() {
            isFolded = true
        }

        fun unfold() {
            isFolded = false
        }    
    */
}
fun main()
{
    val folderphone = FoldablePhone(false,false);
    folderphone.switchOn();
    folderphone.checkPhoneFoldable()
}