package com.battleroyal.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BotLoader {

    public static List<String> getStringFromFile(String filePath) {

        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) { 
                list.add(line);
            }
        } catch (IOException e) {
            System.err.println(Console.Color.RED.colorize("⚠ ERREUR : PROBLÈME DE FICHIER " + e.getMessage()));
        }

        return list;
    }

}
