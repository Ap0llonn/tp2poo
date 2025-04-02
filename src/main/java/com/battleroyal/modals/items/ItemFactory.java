package com.battleroyal.modals.items;

public class ItemFactory {

    public static Consumable createConsumable(ConsumableEnum type) {
        return new Consumable(type.name(), type.getHp(), type.getCombatPoint());
    }

    public static Weapon createWeapon(WeaponEnum type) {
        return new Weapon(type.name(), type.getDamage(), type.getPrecision(), type.getDefense(), type.getLuck());
    }

    public static UpgradeItems createUpgradeItem(UpgradeItemEnum type) {
        return new UpgradeItems(type.name(), type.getType() ,type.getHpBoost(), type.getCombatPointBoost(), type.getDamageBoost(),
                type.getPrecisionBoost(), type.getDefenseBoost(), type.getLuckBoost(), type.isFuturistic());
    }
}
