package com.battleroyal.modals.player;

import java.util.List;

import com.battleroyal.utils.BotLoader;
import com.battleroyal.utils.Console;

public class PlayerFactory {

    private static final String FIRST_NAME_FILE = "src/main/resources/DB/firstName.txt";
    private static final String LAST_NAME_FILE = "src/main/resources/DB/lastName.txt";

    private final List<String> firstNames;
    private final List<String> lastNames;

    public PlayerFactory() {
        this.firstNames = BotLoader.getStringFromFile(FIRST_NAME_FILE);
        this.lastNames = BotLoader.getStringFromFile(LAST_NAME_FILE);
    }

    public BotPlayer createBot() {
        return new BotPlayer(
            generateRandomName(), 
            100,
            Console.randomNumber(1, 12),  // defense
            Console.randomNumber(1, 5), // damage
            Console.randomNumber(20, 80), // precision
            Console.randomNumber(1, 40), // luck
            Console.randomNumber(20, 100), // aggressivity
            100
        );
    }

    public User createUser() {
        return new User(
            Console.getPlayerName(),
            100, 
            Console.randomNumber(1, 12),// defense 
            Console.randomNumber(1, 5), // damage
            Console.randomNumber(20, 80), // precision
            Console.randomNumber(1, 40), // luck
            100
        );
    }

    private String generateRandomName() {
        return getRandomElement(firstNames) + " " + getRandomElement(lastNames);
    }
    
    private String getRandomElement(List<String> list) {
        int randomIndex = Console.randomNumber(0, list.size() - 1);
        return list.remove(randomIndex);
    }
}