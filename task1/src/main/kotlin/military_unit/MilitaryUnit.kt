package military_unit

import weapons.*

class MilitaryUnit(weapons: Iterable<Weapon>) {
    private val weapons = weapons.toList()
    val cost get() = weapons.sumOf { weapon -> weapon.cost }
}