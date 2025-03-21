package com.battleroyal.modals.player;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    

    private final int BOT_NUMBER = 41;

    private PlayerFactory playerFactory;
    private List<BotPlayer> botPlayers;

    public PlayerManager(){
        playerFactory = new PlayerFactory();
        botPlayers = new ArrayList<>();
    }

    public List<BotPlayer> initList(){
        for (int i = 0; i < BOT_NUMBER; i++) {
            botPlayers.add(playerFactory.createBot());
        }

        return botPlayers;
    }
    
}
