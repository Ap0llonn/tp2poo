package com.battleroyal.modals.player;

import com.battleroyal.utils.Console;
import com.battleroyal.utils.Console.Color;

public class BotPlayer extends Player {

    private final int WEAK_ATTACK_COST = 5;
    private final int MEDIUM_ATTACK_COST = 15;
    private final int POWER_ATTACK_COST = 50;

    private int aggressivity;

    public BotPlayer(String name, int hp, int defense, int damage, int precision, int luck, int aggressivity,
            int combatPoint) {
        super(name, hp, defense, damage, precision, luck, combatPoint);
        this.aggressivity = aggressivity;
        updateStats();
    }

    @Override
    public void selectAction(Player target) {

        double healthRatio = (double) getHp() / getMaxhp();
        double enemyHealthRatio = (double) target.getHp() / target.getMaxhp();
        double combatPointRatio = (double) getCombatPoint() / getMaxCombatPoint();

        if (healthRatio < 0.25 && Console.randomNumber(0, 100) > aggressivity) {
            eat();
            return;
        }

        if (combatPointRatio < 0.2 && enemyHealthRatio > 0.5 && Console.randomNumber(0, 100) > aggressivity) {
            runFigth(target);
            return;
        }

        if (enemyHealthRatio < 0.3 && combatPointRatio > 0.3) {
            System.out.println(
                    Color.RED.colorize("[COMBAT] " + getName() + " concentre ses forces pour une attaque dévastatrice !"));
            powerAttack(target);
            return;
        }

        if (Console.randomNumber(0, 100) < aggressivity) {
            System.out.println(
                    Color.YELLOW.colorize("[COMBAT] " + getName() + " lance une attaque calculée avec détermination."));
            mediumAttack(target);
        } else {
            System.out.println(Color.BLUE.colorize("[COMBAT] " + getName() + " tente une attaque rapide et précise."));
            weakAttack(target);
        }
    }

    @Override
    public void weakAttack(Player ennemiePlayer) {
        if (getPrecision() >= Console.randomNumber(0, 100)) {
            int realDamage = (getDamage() - ennemiePlayer.getDefense()) / 2;
            if (realDamage < 0)
                realDamage = 0;
            ennemiePlayer.takeDamage(realDamage);
            increaseCombatPoint(-WEAK_ATTACK_COST);
            System.out.println(Color.PURPLE
                    .colorize("[DÉGÂTS] L'attaque de " + getName() + " inflige " + realDamage + " points de dégâts ! "
                            + ennemiePlayer.getName() + " : " + ennemiePlayer.getHp() + "/" + ennemiePlayer.getMaxhp()
                            + " PV"));
            return;
        }
        System.out.println(Color.RED.colorize("[ÉCHEC] " + getName() + " rate son attaque ! Sa lame fend l'air."));
        return;
    }

    @Override
    public void mediumAttack(Player ennemiePlayer) {
        if (getPrecision() >= Console.randomNumber(0, 100)) {
            int realDamage = getDamage() - ennemiePlayer.getDefense();
            if (realDamage < 0)
                realDamage = 0;
            ennemiePlayer.takeDamage(realDamage);
            increaseCombatPoint(-MEDIUM_ATTACK_COST);
            System.out.println(Color.PURPLE
                    .colorize("[DÉGÂTS] L'assaut de " + getName() + " fait mouche ! " + realDamage + " points de dégâts. "
                            + ennemiePlayer.getName() + " : " + ennemiePlayer.getHp() + "/" + ennemiePlayer.getMaxhp()
                            + " PV"));
            return;
        }
        System.out.println(Color.RED.colorize("[ÉCHEC] " + getName() + " manque sa cible ! Son attaque est esquivée."));
        return;
    }

    @Override
    public void powerAttack(Player ennemiePlayer) {
        if (getPrecision() >= Console.randomNumber(0, 100)) {
            int realDamage = (getDamage() - getDefense()) * 2;
            if (realDamage < 0)
                realDamage = 0;
            ennemiePlayer.takeDamage(realDamage);
            increaseCombatPoint(-POWER_ATTACK_COST);
            System.out.println(Color.PURPLE.colorize(
                    "[DÉGÂTS CRITIQUES] " + getName() + " porte un coup dévastateur ! " + realDamage + " points de dégâts. "
                            + ennemiePlayer.getName() + " : " + ennemiePlayer.getHp() + "/" + ennemiePlayer.getMaxhp()
                            + " PV"));
            return;
        }
        System.out.println(
                Color.RED.colorize("[ÉCHEC] La puissante attaque de " + getName() + " échoue ! Une opportunité gâchée."));
        return;
    }

    @Override
    public void eat() {
        if (!getInventory().getConsumables().isEmpty()) {
            int index = Console.randomNumber(0, getInventory().getConsumables().size() - 1);
            System.out.println(Color.GREEN.colorize("[CONSOMMATION] " + getName() + " utilise "
                    + getInventory().getConsumables().get(index).getName() + " pour reprendre des forces !"));
            getInventory().getConsumables().get(index).use(this);
            getInventory().getConsumables().remove(index);
        } else {
            System.out.println(Color.YELLOW.colorize("[ALERTE] " + getName()
                    + " cherche désespérément quelque chose à consommer, mais son inventaire est vide !"));
        }
    }

    @Override
    public void runFigth(Player ennemiePlayer) {
        int random = Console.randomNumber(0, 100);
        if (getLuck() >= random) {
            System.out.println(Color.GREEN
                    .colorize("[FUITE] " + getName() + " s'échappe rapidement du combat, disparaissant dans l'ombre !"));
            setAsRun(true);
            return;
        }
        System.out.println(Color.RED
                .colorize("[ÉCHEC DE FUITE] " + getName() + " tente de s'échapper mais reste piégé dans le combat !"));
        ennemiePlayer.selectAction(this);
        setAsRun(false);
    }

    public void updateStats() {
        increaseDamage(getInventory().getWeapon().getDamage());
        increaseDefense(getInventory().getWeapon().getDefense());
        increasePrecision(getInventory().getWeapon().getPrecision());
        increaseLuck(getInventory().getWeapon().getLuck());
    }

    @Override
    public String toString() {
        return getName();
    }

    public void randomHealth() {
        if (50 < Console.randomNumber(0, 100)) {
            if (5 > Console.randomNumber(0, 100)) {
                increaseMaxHp(Console.randomNumber(100, 200) - getMaxhp());
            }
            increaseHp(getMaxhp() - getHp());
        } else {
            // Reset HP to a random value between 30 and max
            takeDamage(getHp() - Console.randomNumber(30, getMaxhp()));
        }
    }
}