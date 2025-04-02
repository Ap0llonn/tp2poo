package com.battleroyal.modals.items;

import com.battleroyal.modals.player.Player;

public class UpgradeItems {

    private String name;
    private UpgradeItemEnum.ItemType type;
    private int hpBoost;
    private int combatPointBoost;
    private int damageBoost;
    private int precisionBoost;
    private int defenseBoost;
    private int luckBoost;
    private boolean isFuturistic;

    public UpgradeItems(String name, UpgradeItemEnum.ItemType type, int hpBoost, int combatPointBoost, int damageBoost,
            int precisionBoost, int defenseBoost, int luckBoost,
            boolean isFuturistic) {
        this.name = name;
        this.type = type;
        this.hpBoost = hpBoost;
        this.combatPointBoost = combatPointBoost;
        this.damageBoost = damageBoost;
        this.precisionBoost = precisionBoost;
        this.defenseBoost = defenseBoost;
        this.luckBoost = luckBoost;
        this.isFuturistic = isFuturistic;
    }

    public void use(Player player, Weapon weapon) {
        if (type == UpgradeItemEnum.ItemType.BOOK) {
            WeaponEnum weaponType = weapon.getType();
            Weapon newWeapon = ItemFactory.createWeapon(weaponType);
            if (isFuturistic) {
                player.getInventory().giveFuturisticGun(player);
                return;
            }
            newWeapon.addDamage(damageBoost);
            newWeapon.addPrecision(precisionBoost);
            newWeapon.addDefense(defenseBoost);
            newWeapon.addLuck(luckBoost);
            player.getInventory().changeWeapon(newWeapon, player);
            System.out.print(name + " as been used on ");
            newWeapon.printName();
            System.out.println();
            return;
        }

        if (type == UpgradeItemEnum.ItemType.POTION) {
            player.increaseDamage(damageBoost);
            player.increasePrecision(precisionBoost);
            player.increaseDefense(defenseBoost);
            player.increaseLuck(luckBoost);
            player.increaseMaxHp(hpBoost);
            player.increaseMaxCombatPoint(combatPointBoost);
        }

        System.out.println(name + " as been used");
    }

    public int getDamageBoost() {
        return damageBoost;
    }

    public int getDefenseBoost() {
        return defenseBoost;
    }

    public int getLuckBoost() {
        return luckBoost;
    }

    public String getName() {
        return name;
    }

    public int getPrecisionBoost() {
        return precisionBoost;
    }

    public UpgradeItemEnum.ItemType getType() {
        return type;
    }

    public boolean isFuturistic() {
        return isFuturistic;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("🛠️ Upgrade: %s | ⚡ Type: %s", name, type));

        if (hpBoost > 0)
            sb.append(String.format(" | ❤️ HP Boost: %d", hpBoost));
        if (combatPointBoost > 0)
            sb.append(String.format(" | ⚔️ Combat Point Boost: %d", combatPointBoost));
        if (damageBoost > 0)
            sb.append(String.format(" | 💥 Damage Boost: %d", damageBoost));
        if (precisionBoost > 0)
            sb.append(String.format(" | 🎯 Precision Boost: %d", precisionBoost));
        if (defenseBoost > 0)
            sb.append(String.format(" | 🛡️ Defense Boost: %d", defenseBoost));
        if (luckBoost > 0)
            sb.append(String.format(" | 🍀 Luck Boost: %d", luckBoost));

        return sb.toString();
    }

}
