package com.battleroyal;

import java.util.ArrayList;
import java.util.List;

import com.battleroyal.modals.Day;
import com.battleroyal.modals.player.BotPlayer;
import com.battleroyal.modals.player.PlayerFactory;
import com.battleroyal.modals.player.PlayerManager;
import com.battleroyal.modals.player.User;

public class Game {

    private PlayerManager playerManager;

    private List<BotPlayer> botPlayers;

    public Game() {
        playerManager = new PlayerManager();
        botPlayers = new ArrayList<>();
        botPlayers = playerManager.initList();

    }

    public void startGame() {

        // Console.loadingScreen();
        // Console.displayMenu();
        // System.out.println(Console.getInputInt(2));
        // Console.clearConsole();
        // Console.spinner();
        // Console.startGameLoading();

        Day day = new Day();
        PlayerFactory playerFactory = new PlayerFactory();
        User user = playerFactory.createUser();
        day.combat(user, botPlayers.get(0));

    }
}
