package com.battleroyal.modals.items;

public enum ConsumableEnum {

    LAPIN(50, 0),
    CERF(0, 30),
    SANGLIER(35, 0),
    OURS(30, 50),
    LOUP(0, 10),
    DRAGON(100, 100);

    private int hp;
    private int combatPoint;

    ConsumableEnum(int hp, int combatPoint) {
        this.hp = hp;
        this.combatPoint = combatPoint;
    }

    public int getCombatPoint() {
        return combatPoint;
    }

    public int getHp() {
        return hp;
    }
}
