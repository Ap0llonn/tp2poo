package com.battleroyal.modals;

import com.battleroyal.utils.Console;
import com.battleroyal.modals.items.ConsumableEnum;
import com.battleroyal.modals.player.BotPlayer;
import com.battleroyal.modals.player.PlayerManager;
import com.battleroyal.modals.player.User;

public class Day {

    private int hour;
    private PlayerManager playerManager;
    private int deathPourcentage;
    private int dayNb;

    public Day(int deathPourcentage, int dayNb, User user) {
        playerManager = PlayerManager.getInstance();
        this.deathPourcentage = deathPourcentage;
        this.dayNb = dayNb;
        hour = 6;

        if (dayNb == 3) {
            lastDay(user);
            return;
        }
        dayAction(user);
    }

    private void lastDay(User user) {
        int randomCombat = Console.randomNumber((playerManager.getBotPlayers().size() - 1) / 2, playerManager.getBotPlayers().size() - 1);
        System.out.println("La dernere journée commence, il est temps de se battre pour survivre !");
        do {
            combat(user, playerManager.getRandomEnnemie());
            randomCombat--;
        } while (randomCombat > 0 && !user.isDead());
        if (user.isDead()) {
            Console.randomFailDeadMessage();
            return;
        }
        Console.winnerMessage();
    }

    private void dayAction(User user) {

        do {
            if (!user.isDead()) {
                user.displayDayMenu(hour);
                user.selectDayAction(this);

                if (!user.isDead()) randomCombat(user);
            }
        } while (hour < 22 && !user.isDead());

        if (user.isDead()) {
            Console.randomFailDeadMessage();
            return;
        }

        playerManager.eliminatePlayer(deathPourcentage);
        playerManager.displayeliminatePlayer();
        Console.nextDay();
    }

    public void randomCombat(User user) {
        if (this.deathPourcentage > Console.randomNumber(0, 99)) { 
            combat(user, playerManager.getRandomEnnemie());
            hour++;
        }
    }

    private void combat(User user, BotPlayer botPlayer) {
        Console.randomStartCombatMessage();
        botPlayer.randomHealth();
        boolean combatEnd = false;
        boolean userWin = false;
        do {
            user.displayAttackMenu(botPlayer);
            user.selectAction(botPlayer);

            if (botPlayer.isDead()) {
                userWin = true;
                combatEnd = true;
            }

            if (user.getAsRun()) {
                combatEnd = true;
            }

            if(!combatEnd) botPlayer.selectAction(user);
            
            if (user.isDead()) {
                combatEnd = true;
            }
        } while (!combatEnd);

        if (userWin) {
            Console.randomSuccessDeadMessage();
            System.out.println("Vous avez récuperer votre prochain diner, Miam !!");
            tradeWeapon(user, botPlayer);
            user.getInventory().giveConsumable(ConsumableEnum.LAPIN);
            playerManager.killBotPlayer(botPlayer);
        }
    }

    private void tradeWeapon(User user, BotPlayer botPlayer) {
        System.out.println("==============================================");
        System.out.println("                 ÉCHANGE D'ARMES             ");
        System.out.println("==============================================");

        String userWeapon = user.getInventory().getWeapon().toString();
        String botWeapon = botPlayer.getInventory().getWeapon().toString();

        displayWeapons(userWeapon, botWeapon);

        if (getUserChoice()) {
            executeTrade(user, botPlayer);
        } else {
            System.out.println("\n>>> Vous avez gardé votre arme. <<<\n");
        }

        System.out.println("==============================================");
    }

    private void displayWeapons(String userWeapon, String botWeapon) {
        String[] userLines = userWeapon.split("\n");
        String[] botLines = botWeapon.split("\n");
        int maxLines = Math.max(userLines.length, botLines.length);

        System.out.println("Votre arme:                         Arme du bot:");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < maxLines; i++) {
            String userLine = i < userLines.length ? userLines[i] : "";
            String botLine = i < botLines.length ? botLines[i] : "";
            System.out.printf("%-35s %s%n", userLine, botLine);
        }
        System.out.println("------------------------------------------------");
    }

    private boolean getUserChoice() {
        System.out.println("Voulez-vous échanger votre arme ?");
        System.out.println("0 - Oui    1 - Non");
        System.out.println("------------------------------------------------");
        int input = Console.getInputInt(1);
        return input == 0;
    }

    private void executeTrade(User user, BotPlayer botPlayer) {
        System.out.println("\n>>> Échange réussi ! Vous avez une nouvelle arme. <<<\n");
        user.getInventory().changeWeapon(botPlayer.getInventory().getWeapon(), user);
    }

    public void dayTimeAction() {

        System.out.println();
    }

    public void addHour(int hour) {
        this.hour += hour;
        System.out.println("Temps passé : " + hour);
        if (this.hour > 22) {
            this.hour = 22;
        }
    }

}
