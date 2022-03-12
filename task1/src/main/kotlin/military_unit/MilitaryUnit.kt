package military_unit

import weapons.*

class MilitaryUnit(private val weapons: List<Weapon>) {
    val cost get() = weapons.sumOf { weapon -> weapon.cost }
}