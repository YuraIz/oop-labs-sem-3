package weapons

enum class WeaponType {
    AXE,
    KNIFE,
    SWORD,
    PISTOL,
    AUTOMAT,
    MACHINEGUN
}

abstract class Weapon {
    abstract val cost: Long
}

abstract class Steelarm: Weapon()

class Axe : Steelarm() {
    override val cost: Long
        get() = 10

    lateinit var string: String
    fun func(a: Int, b: Int, str: String): Int {
        string = str
        println(string)
        return a + b
    }

}
class Knife : Steelarm() {
    override val cost: Long
        get() = 15
}
class Sword : Steelarm() {
    override val cost: Long
        get() = 100
}

abstract class Firearm: Weapon()

class Pistol : Firearm() {
    override val cost: Long
        get() = 500
}
class Automat : Firearm() {
    override val cost: Long
        get() = 2000
}
class Machinegun : Firearm() {
    override val cost: Long
        get() = 10000
}