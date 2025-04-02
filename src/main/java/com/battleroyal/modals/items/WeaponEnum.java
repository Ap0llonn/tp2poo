package com.battleroyal.modals.items;

public enum WeaponEnum {

    ÉPÉE_COURTE(28, 42, 5, 4),
    ÉPÉE_LONGUE(38, 37, 7, 2),
    DAGUE(22, 46, 3, 9),
    HACHE_DE_BATAILLE(40, 30, 10, 2),
    MARTEAU_DE_GUERRE(38, 28, 15, -3),
    LANCE(36, 37, 8, 5),
    ARC(30, 45, 3, 7),
    ARBALETE(40, 39, 5, 6),
    FLÉAU(33, 35, 12, -4),
    KATANA(41, 44, 6, 4),
    CIMITARRE(37, 40, 5, 6),
    GRIFFES(32, 44, 4, 10),
    ÉPÉE_LONGUE_DEUX_MAINS(45, 30, 12, -5),
    BÂTON_MAGIQUE(28, 48, 4, 12),
    HALLEBARDE(40, 35, 9, 6),
    GUILLOTINE(42, 29, 11, -6),
    SCEPTRE(35, 41, 6, 8),
    HACHE_DE_GUERRE(39, 33, 13, -2),
    LASER_CUTTER(60, 50, 10, 3),
    RAYON_PLASMA(65, 48, 8, 4), 
    DISSIPATEUR_QUANTIQUE(70, 45, 12, 5);

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
