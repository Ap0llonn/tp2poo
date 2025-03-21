package com.battleroyal.modals.items;

public enum WeaponEnum {
    
    ÉPÉE_COURTE(10, 80, 5, 2),
    ÉPÉE_LONGUE(15, 70, 7, 1),
    DAGUE(8, 90, 3, 5),
    HACHE_DE_BATAILLE(20, 60, 10, 0),
    MARTEAU_DE_GUERRE(25, 50, 15, -2),
    LANCE(12, 75, 8, 3),
    ARC(9, 85, 2, 4),
    ARBALETE(14, 78, 4, 2),
    FLÉAU(18, 55, 12, -1),
    KATANA(17, 88, 6, 3),
    CIMITARRE(13, 80, 5, 4),
    GRIFFES(11, 85, 3, 6),
    ÉPÉE_LONGUE_DEUX_MAINS(22, 65, 12, -3),
    BÂTON_MAGIQUE(10, 90, 4, 7),
    HALLEBARDE(16, 70, 9, 2);

    private final int damage;
    private final int precision;
    private final int defense;
    private final int luck;

    WeaponEnum(int damage, int precision, int defense, int luck) {
        this.damage = damage;
        this.precision = precision;
        this.defense = defense;
        this.luck = luck;
    }

    public int getDamage() {
        return damage;
    }

    public int getPrecision() {
        return precision;
    }

    public int getDefense() {
        return defense;
    }

    public int getLuck() {
        return luck;
    }
}

