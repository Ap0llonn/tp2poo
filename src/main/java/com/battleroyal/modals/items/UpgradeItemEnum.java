package com.battleroyal.modals.items;

public enum UpgradeItemEnum {

    LIVRE_FORCE(ItemType.BOOK, 0, 0, 10, 0, 0, 2, false),
    LIVRE_PRECISION(ItemType.BOOK, 0, 0, 0, 15, 0, 0, false),
    LIVRE_DEFENCE(ItemType.BOOK, 0, 0, 0, 0, 10, 0, false),
    LIVRE_CHANCE(ItemType.BOOK, 0, 0, 0, 0, 0, 10, false),
    
    POTION_POINT_DE_VIE(ItemType.POTION, 50, 0, 0, 0, 0, 0, false),
    POTION_DE_COMBAT(ItemType.POTION, 0, 25, 0, 0, 0, 0, false),
    POTION_PRECISION(ItemType.POTION, 0, 0, 0, 15, 0, 0, false),
    POTION_DEFENCE(ItemType.POTION, 0, 0, 0, 0, 10, 0, false),
    POTION_CHANCE(ItemType.POTION, 0, 0, 0, 0, 0, 25, false),

    ANOMALIE_DE_PUISSANCE(ItemType.POTION, 50, 50, 10, 15, 10, 25, true),
    ANOMALIE_ARME(ItemType.BOOK, 0, 0, 0, 0, 0, 0, true);

    private final ItemType type;
    private final int hpBoost;
    private final int combatPointBoost;
    private final int damageBoost;
    private final int precisionBoost;
    private final int defenseBoost;
    private final int luckBoost;
    private final boolean isFuturistic;

    UpgradeItemEnum(ItemType type, int hpBoost, int combatPointBoost, int damageBoost, int precisionBoost,
            int defenseBoost, int luckBoost, boolean isFuturistic) {
        this.type = type;
        this.hpBoost = hpBoost;
        this.combatPointBoost = combatPointBoost;
        this.damageBoost = damageBoost;
        this.precisionBoost = precisionBoost;
        this.defenseBoost = defenseBoost;
        this.luckBoost = luckBoost;
        this.isFuturistic = isFuturistic;
    }

    public ItemType getType() {
        return type;
    }

    public int getHpBoost() {
        return hpBoost;
    }

    public int getCombatPointBoost() {
        return combatPointBoost;
    }

    public int getDamageBoost() {
        return damageBoost;
    }

    public int getPrecisionBoost() {
        return precisionBoost;
    }

    public int getDefenseBoost() {
        return defenseBoost;
    }

    public int getLuckBoost() {
        return luckBoost;
    }

    public boolean isFuturistic() {
        return isFuturistic;
    }

    public enum ItemType {
        BOOK, POTION;
    }
}