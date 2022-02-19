package military_unit

import weapons.Weapon
import weapons.WeaponFactory
import weapons.WeaponType

object MilitaryUnitBuilder {
    fun build(weaponsOrder: Map<WeaponType, Long>): MilitaryUnit {
        val weapons = ArrayList<Weapon>()
        for(entry in weaponsOrder.entries){
            for (i in 1..entry.value){
                weapons.add(
                    WeaponFactory.createInstance(entry.key)
                )
            }
        }
        return MilitaryUnit(weapons)
    }
}