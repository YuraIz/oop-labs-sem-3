import military_unit.MilitaryUnitBuilder
import weapons.WeaponType

fun main() {

    val testUnit = MilitaryUnitBuilder.build(mapOf(
        WeaponType.SWORD to 10,
        WeaponType.AXE to 20,
        WeaponType.MACHINEGUN to 8,
        WeaponType.AUTOMAT to 15
    ))

    println("Hello, the cost of test military unit is $${testUnit.cost}")
}