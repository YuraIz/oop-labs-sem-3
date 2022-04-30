package weapons

import weapons.WeaponType.*

object WeaponFactory {
    fun createInstance(type: WeaponType) =
        when(type) {
            AUTOMAT -> Automat()
            AXE -> Axe()
            KNIFE -> Knife()
            MACHINEGUN -> Machinegun()
            PISTOL -> Pistol()
            SWORD -> Sword()
        }
}