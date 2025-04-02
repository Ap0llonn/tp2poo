package com.battleroyal.modals.player;

import com.battleroyal.modals.Day;
import com.battleroyal.modals.items.Weapon;
import com.battleroyal.utils.Console;
import com.battleroyal.utils.Console.Color;

public class User extends Player {

    private final int WEAK_ATTACK_COST = 5;
    private final int MEDIUM_ATTACK_COST = 15;
    private final int POWER_ATTACK_COST = 50;

    public User(String name, int hp, int defense, int damage, int precision, int luck, int combatPoint) {
        super(name, hp, defense, damage, precision, luck, combatPoint);
        initWeaponStats();
        checkSuperUser();
    }

    @Override
    public void weakAttack(Player ennemiePlayer) {
        if (getPrecision() >= Console.randomNumber(0, 100)) {
            int realDamage = (getDamage() - ennemiePlayer.getDefense()) / 2;
            if (realDamage < 0)
                realDamage = 0;
            ennemiePlayer.takeDamage(realDamage);
            increaseCombatPoint(-WEAK_ATTACK_COST);
            System.out.println(Console.Color.GREEN.colorize("[ATTAQUE FAIBLE] ✓ Coup réussi !"
                    + Console.Color.YELLOW.boldColorize(" Vous infligez " + realDamage + " dégâts à l'ennemi.")));
            System.out.printf(Console.Color.GREEN.colorize("[SANTÉ] L'ennemi a maintenant %d PV restants.%n"),
                    ennemiePlayer.getHp());
            return;
        }
        System.out.println(Console.Color.RED.colorize("[ATTAQUE FAIBLE] ✗ Attaque manquée !"));
    }

    @Override
    public void mediumAttack(Player ennemiePlayer) {
        if (getPrecision() >= Console.randomNumber(0, 100)) {
            int realDamage = getDamage() - ennemiePlayer.getDefense();
            if (realDamage < 0)
                realDamage = 0;
            ennemiePlayer.takeDamage(realDamage);
            increaseCombatPoint(-MEDIUM_ATTACK_COST);
            System.out.println(Console.Color.GREEN.colorize("[ATTAQUE MOYENNE] ✓ Coup réussi ! ") +
                    Console.Color.YELLOW.boldColorize(" Vous infligez " + realDamage + " dégâts à l'ennemi."));
            System.out.printf(Console.Color.GREEN.colorize("[SANTÉ] L'ennemi a maintenant %d PV restants.%n"),
                    ennemiePlayer.getHp());
            return;
        }
        System.out.println(Console.Color.RED.colorize("[ATTAQUE MOYENNE] ✗ Attaque manquée !"));
    }

    @Override
    public void powerAttack(Player ennemiePlayer) {
        if (getPrecision() >= Console.randomNumber(0, 100)) {
            int realDamage = (getDamage() - ennemiePlayer.getDefense()) * 2;
            if (realDamage < 0)
                realDamage = 0;
            ennemiePlayer.takeDamage(realDamage);
            increaseCombatPoint(-POWER_ATTACK_COST);
            System.out.println(Console.Color.GREEN.colorize("[ATTAQUE PUISSANTE] ✓ Coup réussi ! " +
                    Console.Color.YELLOW.boldColorize(" Vous infligez " + realDamage + " dégâts à l'ennemi.")));
            System.out.printf(Console.Color.GREEN.colorize("[SANTÉ] L'ennemi a maintenant %d PV restants.%n"),
                    ennemiePlayer.getHp());
            return;
        }
        System.out.println(Console.Color.RED.colorize("[ATTAQUE PUISSANTE] ✗ Attaque manquée !"));
    }

    @Override
    public void selectAction(Player executeAttack) {
        boolean isValid = false;
        int attackType;
        do {
            isValid = true;
            setAsRun(false);
            attackType = Console.getInputInt(6);

            isValid = checkIsValid(attackType);

        } while (!isValid);

        attackType(executeAttack, attackType);
    }

    private boolean checkIsValid(int attackType) {
        if (attackType == 0) {
            return checkEnoughPP(attackType, 0, WEAK_ATTACK_COST);
        } else if (attackType == 1) {
            return checkEnoughPP(attackType, 1, MEDIUM_ATTACK_COST);
        } else if (attackType == 2) {
            return checkEnoughPP(attackType, 2, POWER_ATTACK_COST);
        }

        if (attackType == 6) {
            getInventory().displayInventory();
            return false;
        }

        if (attackType == 4) {
           return getInventory().consumableIsEmpty();
        }
        return true;
    }

    private void attackType(Player ennemiePlayer, int attackType) {
        switch (attackType) {
            case 0 -> weakAttack(ennemiePlayer);
            case 1 -> mediumAttack(ennemiePlayer);
            case 2 -> powerAttack(ennemiePlayer);
            case 3 -> runFigth(ennemiePlayer);
            case 4 -> eat();
            case 5 -> System.out.println("vous ne faite rien");
        }
    }

    private boolean checkEnoughPP(int attackType, int nb, int cost) {
        if (attackType == nb && getCombatPoint() < cost) {
            System.out.println(Color.RED.colorize("⚠ ERREUR : PC INSUFFISANT"));
            return false;
        }
        return true;
    }

    @Override
    public void runFigth(Player ennemiePlayer) {
        if (getLuck() >= Console.randomNumber(0, 100)) {
            System.out.println("vous vous êtes échappé");
            setAsRun(true);
            return;
        }
        ennemiePlayer.selectAction(this);
        System.out.println("Tentative échouer");
        setAsRun(false);
    }

    public void displayDayMenu(int heure) {
        System.out.println("--------------------- MENU DE LA JOURNÉE ----------------------");
        System.out.println(heure + "h");
        System.out.println("--------------------- ACTION ----------------------");
        System.out.println("0 - Chasser (durée 1h à 4h)");
        System.out.println("1 - Explorer (durée 3h à 5h)");
        System.out.println("2 - Repos (durée 6h à 10h, chance de mourir 75%)");
        System.out.println("--------------------------------------------------------------");
        System.out.println("3 - Trouver une cible (durée 1h à 2h)");
        System.out.println("--------------------------------------------------------------");
        System.out.println("4 - Manger");
        System.out.println("5 - Améliorer (durée 1h à 2h)");
        System.out.println("6 - Inventaire");
        System.out.println("------------------------VOUS---------------------------------");
        System.out.println(Console.Color.BLUE
                .boldColorize("Nom : " + getName() + " | Points de vie : " + getHp() + " | PC : " + getCombatPoint()));
        System.out.println(Console.Color.BLUE
                .boldColorize("Dégat : " + getDamage() + " | Precision : " + getPrecision() + " | Defence : " + getDefense()
                        + " | Luck : " + getLuck()));
        System.out.println("------------------------ARME---------------------------------");
        getInventory().getWeapon().displayGun();
        System.out.println("--------------------------------------------------------------");
    }

    public void selectDayAction(Day day) {
        boolean isValid = false;
        int actionType;
        do {
            isValid = true;
            actionType = Console.getInputInt(7);
            isValid = checkIsEmpty(actionType);

        } while (!isValid);

        actionType(actionType, day);
    }

    private boolean checkIsEmpty(int actionType) {
        if (actionType == 4) {
            return getInventory().consumableIsEmpty();
        }

        if (actionType == 5) {
            return getInventory().upgradeIsEmpty();
        }

        return true;
    }

    private void actionType(int actionType, Day day) {
        switch (actionType) {
            case 0 -> hunt(day);
            case 1 -> explore(day);
            case 2 -> sleep(day);
            case 3 -> findTarget(day);
            case 4 -> eat();
            case 5 -> upgrade();
            case 6 -> getInventory().displayInventory();
        }
    }

    private void explore(Day day) {
        if (getLuck() > Console.randomNumber(0, 100)) {
            Console.randomSuccessExplorationMessage();
            getInventory().addRandomUpgradeItems();
            day.addHour(Console.randomNumber(3, 5));
            return;
        }

        Console.randomFailExplorationMessage();
        day.addHour(Console.randomNumber(3, 5));
    }

    private void hunt(Day day) {
        if (getLuck() > Console.randomNumber(0, 100)) {
            Console.randomSuccessHuntMessage();
            getInventory().addRandomItem();
            day.addHour(Console.randomNumber(1, 4));
            return;
        }

        Console.randomFailHuntMessage();
        day.addHour(Console.randomNumber(1, 4));
    }

    private boolean findTarget(Day day) {
        System.out.println("Recherche de cible");
        day.addHour(Console.randomNumber(1, 2));
        day.randomCombat(this);
        return true;
    }

    private void sleep(Day day) {
        int chanceToDeath = 75;
        if (chanceToDeath > Console.randomNumber(0, 100)) {
            takeDamage(getHp()); // Set HP to 0
            return;
        }
        Console.randomSuccessSleepMessage();
        increaseHp(getMaxhp() - getHp()); // Restore to full HP
        increaseCombatPoint(getMaxCombatPoint() - getCombatPoint()); // Restore to full combat points
        day.addHour(Console.randomNumber(6, 10));
    }

    public void displayAttackMenu(BotPlayer botPlayer) {
        System.out.println("-----------------Adversaire---------------------");
        System.out.println("Nom : " + botPlayer.getName());
        System.out.println(Console.Color.BLUE.boldColorize("Points de vie adversaire : " + botPlayer.getHp()));
        System.out.println("------------------------------------------------");
        System.out.printf("%-25s %-10s %-10s%n", "Type d'Attaque", "Dégat", "Cout En PC");
        System.out.println("------------------------------------------------");
        System.out.printf("%-25s %-10d %-10d%n", "0 - Attaque faible", getDamage() / 2, WEAK_ATTACK_COST);
        System.out.printf("%-25s %-10d %-10d%n", "1 - Attaque Moyenne", getDamage(), MEDIUM_ATTACK_COST);
        System.out.printf("%-25s %-10d %-10d%n", "2 - Attaque Puissante", getDamage() * 2, POWER_ATTACK_COST);
        System.out.println("3 - Fuire");
        System.out.println("4 - Manger");
        System.out.println("5 - Ne rien faire");
        System.out.println("6 - Voire inventaire");
        System.out.println("--------------Vous----------------------");
        System.out.println(Console.Color.BLUE.boldColorize("Points de vie : " + getHp() + " PP : " + getCombatPoint()));
        System.out.println("Nom : " + getName());
        System.out.println("-------------------------------------------");
    }

    private void initWeaponStats() {
        increaseDamage(getInventory().getWeapon().getDamage());
        increaseDefense(getInventory().getWeapon().getDefense());
        increasePrecision(getInventory().getWeapon().getPrecision());
        increaseLuck(getInventory().getWeapon().getLuck());
    }

    public void upgrade() {
        getInventory().displayUpgrades();
        int index = Console.getInputInt(getInventory().getUpgradeItems().size() - 1);
        getInventory().getUpgradeItems().get(index).use(this, getInventory().getWeapon());
        getInventory().getUpgradeItems().remove(index);
    }

    @Override
    public void eat() {
        getInventory().displayConsumables();
        int index = Console.getInputInt(getInventory().getConsumables().size() - 1);
        getInventory().getConsumables().get(index).use(this);
        getInventory().getConsumables().remove(index);
    }

    private void checkSuperUser() {
        if (getName().equals("Bruce Wayne")) {
            System.out.println("Mode Super user activé");
            
    
            takeDamage(getHp());
            increaseMaxHp(1000 - getMaxhp());
            increaseHp(1000);
            increaseDamage(50 - getDamage());
            increasePrecision(100 - getPrecision());
            increaseDefense(50 - getDefense());
            increaseLuck(100 - getLuck()); 
            increaseMaxCombatPoint(1000 - getMaxCombatPoint()); 
            
            getInventory().giveFuturisticGun(this);
        }
    }
}