
package com.battleroyal.modals.items;

import com.battleroyal.modals.player.Player;

public class Consumable {

    private String name;
    private int hp;
    private int combatPoint;

    public Consumable(String name, int hp, int combatPoint) {
        this.name = name;
        this.hp = hp;
        this.combatPoint = combatPoint;
    }

    public int getCombatPoint() {
        return combatPoint;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public void use(Player player){
        player.increaseCombatPoint(combatPoint);
        player.increaseHp(hp);
        System.out.println(name + " as been used");
    }

    @Override
    public String toString() {
        return String.format("🍽️ Consumable: %s | ❤️ HP: %d | ⚔️ Combat Points: %d", name, hp, combatPoint);
    }

}