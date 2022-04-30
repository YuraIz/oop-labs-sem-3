package military_unit

import weapons.Weapon
import weapons.WeaponFactory
import weapons.WeaponType

object MilitaryUnitBuilder {
    fun build(vararg weaponsOrder: Pair<WeaponType, Long>): MilitaryUnit {
        val weapons = ArrayList<Weapon>()
        for((key, value) in weaponsOrder){
            for (i in 1..value){
                weapons.add(
                    WeaponFactory.createInstance(key)
                )
            }
        }
        return MilitaryUnit(weapons)
    }
}