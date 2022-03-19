package weapons

object WeaponFactory {
    fun createInstance(type: WeaponType): Weapon {
        return when(type) {
            WeaponType.AUTOMAT -> Automat()
            WeaponType.AXE -> Axe()
            WeaponType.KNIFE -> Knife()
            WeaponType.MACHINEGUN -> Machinegun()
            WeaponType.PISTOL -> Pistol()
            WeaponType.SWORD -> Sword()
        }
    }
}