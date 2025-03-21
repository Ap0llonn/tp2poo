package com.battleroyal.modals.player;

import com.battleroyal.utils.Console;
import com.battleroyal.utils.Console.Color;

public class User extends Player {

    private final int WEAK_ATTACK_COST = 10;
    private final int MEDIUM_ATTACK_COST = 25;
    private final int POWER_ATTACK_COST = 80;

    public User(String name, int hp, int maxhp, int defense, int damage, int precision, int luck, int combatPoint,
            int maxCombatPoint) {
        super(name, hp, maxhp, defense, damage, precision, luck, combatPoint, maxCombatPoint);
    }

    @Override
    public void weakAttack(Player ennemiePlayer) {
        if (precision < Console.randomNumber(0, 100)) {
            ennemiePlayer.takeDamage(damage / 2);
            combatPoint -= WEAK_ATTACK_COST;
            System.out.println("User a fait " + damage / 2 + " il reste " + ennemiePlayer.getHp());
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
            System.out.println("User a fait " + damage + " il reste " + ennemiePlayer.getHp());
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
            System.out.println("User a fait " + damage * 2 + " il reste " + ennemiePlayer.getHp());
            return;
        }
        System.out.println("Attaque ratée");
        return;
    }

    @Override
    public void selectAction(Player executeAttack) {
        boolean isValid = false;
        int attackType;
        do {
            isValid = true;
            attackType = Console.getInputInt(2);

            isValid = checkEnoughPP(attackType, 0, WEAK_ATTACK_COST);
            isValid = checkEnoughPP(attackType, 1, MEDIUM_ATTACK_COST);
            isValid = checkEnoughPP(attackType, 2, POWER_ATTACK_COST);

        } while (!isValid);

        attackType(executeAttack, attackType);
    }

    private void attackType(Player ennemiePlayer, int attackType) {
        switch (attackType) {
            case 0 -> weakAttack(ennemiePlayer);
            case 1 -> mediumAttack(ennemiePlayer);
            case 2 -> powerAttack(ennemiePlayer);
        }
    }

    private boolean checkEnoughPP(int attackType, int nb, int cost) {
        if (attackType == nb && combatPoint < POWER_ATTACK_COST) {
            System.out.println(Color.RED.colorize("⚠ ERREUR : PC INSUFISANT"));
            return false;
        }

        return true;
    }

    @Override
    public void eat() {

    }

    @Override
    public boolean runFigth() {

        return true;
    }

    @Override
    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0)
            hp = 0;
    }

    public void displayAttackMenu(BotPlayer botPlayer) {

        System.out.println("-----------------Adversaire---------------------");
        System.out.println("Nom : " + botPlayer.getName());
        System.out.println(Console.Color.BLUE.boldColorize("Points de vie adversaire : " + botPlayer.getHp()));
        System.out.println("------------------------------------------------");
        System.out.printf("%-25s %-10s %-10s%n", "Type d'Attaque", "Dégat", "Cout En PC");
        System.out.println("------------------------------------------------");
        System.out.printf("%-25s %-10d %-10d%n", "0 - Attaque faible", damage / 2, WEAK_ATTACK_COST);
        System.out.printf("%-25s %-10d %-10d%n", "1 - Attaque Moyenne", damage, MEDIUM_ATTACK_COST);
        System.out.printf("%-25s %-10d %-10d%n", "2 - Attaque Puissante", damage * 2, POWER_ATTACK_COST);
        System.out.println("3 - Fuire");
        System.out.println("4 - Manger");
        System.out.println("5 - Ne rien faire");
        System.out.println("--------------Vous----------------------");
        System.out.println(Console.Color.BLUE.boldColorize("Points de vie : " + hp + " PP : " + combatPoint));
        System.out.println("Nom : " + name);
        System.out.println("-------------------------------------------");
    }

    public void updateStats(){
        
    }
}
