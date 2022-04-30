import military_unit.MilitaryUnitBuilder
import weapons.Axe
import weapons.WeaponType

fun main() {

    val testUnit = MilitaryUnitBuilder.build(
        WeaponType.SWORD to 10,
        WeaponType.AXE to 20,
        WeaponType.MACHINEGUN to 8,
        WeaponType.AUTOMAT to 15
    )

    val axe = Axe()

    val num = axe.func(4, 5, "Hello")
    println(num)

    println("Hello, the cost of test military unit is $${testUnit.cost}")
}