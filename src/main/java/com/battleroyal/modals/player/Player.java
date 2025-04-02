package com.battleroyal.modals.player;

import com.battleroyal.modals.items.Weapon;

public abstract class Player {

    private String name;
    private int hp;
    private int maxhp;
    private int defense;
    private int damage;
    private int precision;
    private int luck;
    private int combatPoint;
    private int maxCombatPoint;
    private boolean asRun;
    private Inventory inventory;

    public Player(String name, int hp, int defense, int damage, int precision, int luck, int combatPoint) {
        this.name = name;
        this.hp = hp;
        this.maxhp = hp;
        this.defense = defense;
        this.damage = damage;
        this.precision = precision;
        this.luck = luck;
        this.combatPoint = combatPoint;
        this.maxCombatPoint = combatPoint;
        asRun = false;
        inventory = new Inventory();
    }

    public abstract void weakAttack(Player player);

    public abstract void mediumAttack(Player player);

    public abstract void powerAttack(Player player);

    public abstract void runFigth(Player player);

    public abstract void selectAction(Player player);

    public abstract void eat();

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxhp() {
        return maxhp;
    }
    
    public int getDefense() {
        return defense;
    }
    
    public int getDamage() {
        return damage;
    }
    
    public int getPrecision() {
        return precision;
    }
    
    public int getLuck() {
        return luck;
    }
    
    public int getCombatPoint() {
        return combatPoint;
    }
    
    public int getMaxCombatPoint() {
        return maxCombatPoint;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAsRun(boolean asRun) {
        this.asRun = asRun;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public void updateStats(Weapon newWeapon, Weapon oldWeapon) {
        damage -= oldWeapon.getDamage();
        defense -= oldWeapon.getDefense();
        precision -= oldWeapon.getPrecision();
        luck -= oldWeapon.getLuck();

        damage += newWeapon.getDamage();
        defense += newWeapon.getDefense();
        precision += newWeapon.getPrecision();
        luck += newWeapon.getLuck();

        if (precision > 100) {
            precision = 100;
        }

        System.out.println("Stats mis à jour : " + name);
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0)
            hp = 0;
    }

    public void increaseHp(int hp) {
        this.hp += hp;
        if (this.hp > 100) {
            this.hp = 100;
        }
    }

    public void increaseMaxHp(int hp) {
        this.maxhp += hp;
        this.hp = maxhp;
    }

    public void increaseDefense(int defense) {
        this.defense += defense;
    }

    public void increaseDamage(int damage) {
        this.damage += damage;
    }

    public void increasePrecision(int precision) {
        this.precision += precision;
        if (this.precision > 100) {
            this.precision = 100;
        }
    }

    public void increaseMaxCombatPoint(int maxCombatPoint) {
        this.maxCombatPoint += maxCombatPoint; 
        this.combatPoint = maxCombatPoint; 
    }
    
    public void increaseLuck(int luck) {
        this.luck += luck;
        if (this.luck > 100) {
            this.luck = 100;
        }
    }

    public void increaseCombatPoint(int combatPoint) {
        this.combatPoint += combatPoint;
        if (this.combatPoint > maxCombatPoint) {
            this.combatPoint = maxCombatPoint;
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Boolean getAsRun() {
        return asRun;
    }
}