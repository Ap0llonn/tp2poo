package com.battleroyal.modals;

import com.battleroyal.modals.player.BotPlayer;
import com.battleroyal.modals.player.User;

public class Day {

    public Day() {

    }

    public void combat(User user, BotPlayer botPlayer) {
        boolean combatEnd = false;
        do {

            user.displayAttackMenu(botPlayer);
            user.selectAction(botPlayer);
            botPlayer.selectAction(user);

            if (user.getHp() <= 0 || botPlayer.getHp() <= 0) {
                combatEnd = true;
            }

        } while (!combatEnd);

        System.out.println("fin du combat");

    }


}
