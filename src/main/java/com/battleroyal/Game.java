package com.battleroyal;

import com.battleroyal.modals.Day;
import com.battleroyal.modals.player.PlayerFactory;
import com.battleroyal.modals.player.PlayerManager;
import com.battleroyal.modals.player.User;
import com.battleroyal.utils.Console;

public class Game {

    private PlayerManager playerManager;
    private PlayerFactory playerFactory;
    private User user;

    public Game() {
        playerFactory = new PlayerFactory();
        playerManager = PlayerManager.getInstance();
    }

    public void startGame() {

        //Console.loadingScreen();
        //Console.displayMenu();
        //if(Console.getInputInt(1) == 1) return; 
        //Console.spinner();
        //Console.startGameLoading();

        user = playerFactory.createUser();
        
        runDay(1, 75);
        if (user.isDead())
            return;
        runDay(2, 75);
        if (user.isDead())
            return;
        runDay(3, 30);
        if (user.isDead())
            return;
    }

    private void runDay(int dayNumber, int deathPercentage) {
        System.out.println("JOUR " + dayNumber);
        Day day = new Day(deathPercentage, dayNumber, user);
    }
}
