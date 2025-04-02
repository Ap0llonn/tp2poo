package com.battleroyal.modals.items;

import com.battleroyal.utils.Console;

public class Weapon {

    private String name;
    private int damage;
    private int precision;
    private int defense;
    private int luck;

    public Weapon(String name, int damage, int precision, int defense, int luck) {
        this.name = name;
        this.damage = damage;
        this.precision = precision;
        this.defense = defense;
        this.luck = luck;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public int getLuck() {
        return luck;
    }

    public int getPrecision() {
        return precision;
    }

    public String getName() {
        return name;
    }

    public void addDamage(int damage) {
        this.damage += damage;
    }

    public void addDefense(int defense) {
        this.defense += defense;
    }

    public void addLuck(int luck) {
        this.luck += luck;
    }

    public void addPrecision(int precision) {
        this.precision += precision;
    }

    public void printName() {
        System.out.println(name);
    }

    public WeaponEnum getType() {
        return WeaponEnum.valueOf(name.toUpperCase());

    }

    public void displayGun() {
        System.out.println(Console.Color.BLUE
                .boldColorize("Nom : " + name + " | Dégat : " + damage + " | Precision : " + precision + " | Defence : "
                        + defense
                        + " | Luck : " + luck));
    }

    public String toString() {
        return "------ ARME ------\n" +
                "Nom        : " + name + "\n" +
                "Dégâts     : " + damage + "\n" +
                "Précision  : " + precision + "\n" +
                "Défense    : " + defense + "\n" +
                "Chance     : " + luck + "\n" +
                "----------------------";
    }

}
