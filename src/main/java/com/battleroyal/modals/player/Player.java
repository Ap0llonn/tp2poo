package com.battleroyal.modals.player;

public abstract class Player {

    protected String name;
    protected int hp;
    protected int maxhp;
    protected int defense;
    protected int damage;
    protected int precision;
    protected int luck;
    protected int combatPoint;
    protected int maxCombatPoint;
    protected Inventory inventory;

    public Player(String name,int hp, int maxhp, int defense, int damage, int precision, int luck, int combatPoint, int maxCombatPoint) {
        this.name = name;
        this.hp = hp;
        this.maxhp = hp;
        this.defense = defense;
        this.damage = damage;
        this.precision = precision;
        this.luck = luck;
        this.combatPoint = combatPoint;
        this.maxCombatPoint = combatPoint;
        inventory = new Inventory();
    }

    public abstract void weakAttack(Player player);

    public abstract void mediumAttack(Player player);

    public abstract void powerAttack(Player player);

    public abstract void takeDamage(int damageAmount);

    public abstract boolean runFigth();

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

}
