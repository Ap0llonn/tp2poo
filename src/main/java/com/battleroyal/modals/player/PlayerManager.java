package com.battleroyal.modals.player;

import java.util.ArrayList;
import java.util.List;

import com.battleroyal.utils.Console;

public class PlayerManager {

    private static PlayerManager instance; 
    private final int BOT_NUMBER = 41;

    private PlayerFactory playerFactory;
    private List<BotPlayer> botPlayers;
    private List<BotPlayer> deadBotPlayers;

    private PlayerManager() {
        playerFactory = new PlayerFactory();
        botPlayers = new ArrayList<>();
        deadBotPlayers = new ArrayList<>();
        initList();
    }

    public static PlayerManager getInstance() {
        if (instance == null) {
            instance = new PlayerManager();
        }
        return instance;
    }

    public List<BotPlayer> initList() {
        for (int i = 0; i < BOT_NUMBER; i++) {
            botPlayers.add(playerFactory.createBot());
        }
        return botPlayers;
    }

    public void eliminatePlayer(int deathPercentage) {
        for (int i = 0; i < botPlayers.size(); i++) {
            if (deathPercentage > Console.randomNumber(0, 99)) {
                deadBotPlayers.add(botPlayers.get(i));
                botPlayers.remove(i);
            }
        }
    }

    public List<BotPlayer> getBotPlayers() {
        return botPlayers;
    }

    public void killBotPlayer(BotPlayer player){
        deadBotPlayers.add(player);
        botPlayers.remove(player);
    }

    public void displayeliminatePlayer(){
        for (BotPlayer botPlayer : deadBotPlayers) {
            System.out.println(botPlayer.toString() + " a été éliminé");
        }
        deadBotPlayers.clear();

        System.out.println("Il reste " + botPlayers.size() + " joueurs");
    }

    public BotPlayer getRandomEnnemie(){
        return botPlayers.get(Console.randomNumber(0, botPlayers.size() - 1));
    }
}
