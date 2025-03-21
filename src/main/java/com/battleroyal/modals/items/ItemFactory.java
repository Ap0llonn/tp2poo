package com.battleroyal.modals.items;

public class ItemFactory {
    

    public Weapon createWeapon(WeaponEnum type){
        return new Weapon(type.getDamage(), type.getPrecision(), type.getDefense(), type.getLuck());
    }
}
