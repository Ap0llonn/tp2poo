package com.battleroyal.modals.player;

import com.battleroyal.utils.Console;

public class BotPlayer extends Player {

    private final int WEAK_ATTACK_COST = 10;
    private final int MEDIUM_ATTACK_COST = 25;
    private final int POWER_ATTACK_COST = 80;

    private int aggressivity;

    public BotPlayer(String name, int hp, int maxhp, int defense, int damage, int precision, int luck, int aggressivity,
            int combatPoint, int maxCombatPoint) {
        super(name, hp, defense, maxhp, damage, precision, luck, combatPoint, maxCombatPoint);
        this.aggressivity = aggressivity;
    }

    @Override
    public void selectAction(Player target) {

        double healthRatio = (double) hp / maxhp;
        double enemyHealthRatio = (double) target.getHp() / target.getMaxhp();
        double combatPointRatio = (double) combatPoint / maxCombatPoint;

        if (healthRatio < 0.25 && Console.randomNumber(0, 100) > aggressivity) {
            eat();
            return;
        }

        if (combatPointRatio < 0.2 && enemyHealthRatio > 0.5 && Console.randomNumber(0, 100) > aggressivity) {
            runFigth();
            return;
        }

        if (enemyHealthRatio < 0.3 && combatPointRatio > 0.3) {
            powerAttack(target);
            return;
        }

        if (Console.randomNumber(0, 100) < aggressivity) {
            mediumAttack(target);
        } else {
            weakAttack(target);
        }

    }

    @Override
    public void weakAttack(Player ennemiePlayer) {
        if (precision < Console.randomNumber(0, 100)) {
            ennemiePlayer.takeDamage(damage / 2);
            combatPoint -= WEAK_ATTACK_COST;
            System.out.println("Bot a fait " + damage / 2 + " il reste " + ennemiePlayer.getHp());
            return;
        }
        System.out.println("Attaque ratée");
        return;
    }

    @Override
    public void mediumAttack(Player ennemiePlayer) {
        if (precision < Console.randomNumber(0, 100)) {
            ennemiePlayer.takeDamage(damage);
            combatPoint -= MEDIUM_ATTACK_COST;
            System.out.println("Bot a fait " + damage + " il reste " + ennemiePlayer.getHp());
            return;
        }
        System.out.println("Attaque ratée");
        return;
    }

    @Override
    public void powerAttack(Player ennemiePlayer) {
        if (precision < Console.randomNumber(0, 100)) {
            ennemiePlayer.takeDamage(damage * 2);
            combatPoint -= POWER_ATTACK_COST;
            System.out.println("Bot a fait " + damage * 2 + " il reste " + ennemiePlayer.getHp());
            return;
        }
        System.out.println("Attaque ratée");
        return;
    }

    

    @Override
    public void eat() {
        System.out.println("bot as eaten");
    }

    @Override
    public boolean runFigth() {
        int random = Console.randomNumber(0, 100);
        if (luck >= random) {
            System.out.println(name);
            return true;
        }
        return false;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0)
            hp = 0;
    }
}
