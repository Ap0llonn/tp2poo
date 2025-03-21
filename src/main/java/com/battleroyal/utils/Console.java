package com.battleroyal.utils;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Console {

    public static void loadingScreen() {

        System.out.println(Color.BLUE.colorize("■ QUANTUM OS 4.7 SÉQUENCE D'INITIALISATION"));
        System.out.println();

        try {
            printStep();
            spinner();
            clearConsole();
        } catch (InterruptedException e) {
            System.out.println(Color.RED.colorize("⚠ ERREUR : PROCESSUS INTERRUPTÉ"));
            e.printStackTrace();
        }

        System.out.println(Color.GREEN.colorize("Transfert complet"));

    }

    public static int randomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static void displayMenu() {
        System.out.println();
        System.out.println(Color.BLUE.colorize("╔══════════════════════════════════════╗"));
        System.out.println(Color.BLUE.colorize("║                                      ║"));
        System.out.println(Color.BLUE.colorize("║         ") + Color.GREEN.colorize("CONSCIENCE EN LIGNE")
                + Color.BLUE.colorize("          ║"));
        System.out.println(Color.BLUE.colorize("║                                      ║"));
        System.out.println(Color.BLUE.colorize("╠══════════════════════════════════════╣"));
        System.out.println(Color.BLUE.colorize("║                                      ║"));
        System.out.println(Color.BLUE.colorize("║           ❶  ") + Color.GREEN.colorize("NEW GAME")
                + Color.BLUE.colorize("                ║"));
        System.out.println(Color.BLUE.colorize("║                                      ║"));
        System.out.println(Color.BLUE.colorize("║           ❷  ") + Color.GREEN.colorize("QUIT")
                + Color.BLUE.colorize("                    ║"));
        System.out.println(Color.BLUE.colorize("║                                      ║"));
        System.out.println(Color.BLUE.colorize("╚══════════════════════════════════════╝"));
    }

    public static int getInputInt(int choiceMax) {
        int number = 0;
        boolean valideInput = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(Color.GREEN.colorize("⟫ INPUT: "));
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                valideInput = true;
                valideInput = isHigherThan0(number);
                valideInput = isInRange(choiceMax, number);
            } else {
                System.out.println(Color.RED.colorize("⚠ ERREUR : DOIT ÊTRE UN CHIFFRE"));
                sc.next();
            }
        } while (!valideInput);
        return number;
    }


    //methode de claud ai
    public static void startGameLoading() {
        try {
            String[] prefixes = { "[VISION]", "[SYSTÈME]", "[RÉALITÉ]", "[DANGER]", "[MONDE]", "[SOUVENIR]" };
            String[] actions = {
                "Matérialisation du corps", "Calibration des sens", "Connexion aux souvenirs",
                "Téléportation en cours", "Chargement du terrain", "Analyse des adversaires",
                "Réveil de l’instinct"
            };
    
            for (int i = 0; i < 250; i++) {
                String prefix = Color.BLUE.colorize(prefixes[i % prefixes.length]);
                String action = Color.BLUE.colorize(actions[i % actions.length]);
                String id = Color.YELLOW.colorize("ID: 0x" + Integer.toHexString(i * 1234));
                String progress = (i % 3 == 0) 
                    ? Color.GREEN.colorize("[" + i + "% de synchronisation]") 
                    : Color.GREEN.colorize("(" + (i * 512) + " fragments mémoriels)");
    
                System.out.println(prefix + " " + action + " " + id + " " + progress);
    
                Thread.sleep(10 + (int) (Math.random() * 20));
            }
    
            System.out.println(Color.GREEN.colorize("[FINALISATION] Simulation active. Le combat commence..."));
    
        } catch (InterruptedException e) {
            System.out.println(Color.RED.colorize("[ERREUR] Rupture de la connexion : " + e.getMessage()));
        }
    }
    

    private static boolean isInRange(int choiceMax, int number) {
        if (number > choiceMax) {
            System.out.println(Color.RED.colorize("⚠ ERREUR : DOIT ÊTRE PLUS PETIT QUE " + choiceMax));
            return false;
        }
        return true;
    }

    private static boolean isHigherThan0(int number) {
        if (number < 0) {
            System.out.println(Color.RED.colorize("⚠ ERREUR : DOIT ÊTRE PLUS GRAND QUE 0"));
            return false;
        }
        return true;
    }

    private static void printStep() throws InterruptedException {
        String[] bootSteps = {
                "Initialisation du scan neural",
                "Extraction des schémas cognitifs",
                "Décryptage des empreintes mnémoniques",
                "Téléversement de la conscience vers le noyau numérique",
                "Cartographie des voies synaptiques vers le cadre artificiel",
                "Établissement du lien cognitif avec les processus machine",
                "Synchronisation des flux de données sensorielles",
                "Calibration de l'émulation des fonctions motrices",
                "Activation du système de réponse endocrine artificielle",
                "Intégration de la matrice de simulation émotionnelle",
                "Optimisation des algorithmes de neuroplasticité",
                "Établissement des protocoles de rétention de la personnalité",
                "Chiffrement des paramètres d'identité du noyau",
                "Finalisation de l'intégration de la conscience",
                "Lancement du diagnostic de l'auto-conscience",
                "Activation de l'existence numérique"
        };

        for (String step : bootSteps) {

            System.out.print(Color.BLUE.colorize("► " + step));
            for (int i = 0; i < randomNumber(3, 10); i++) {
                TimeUnit.MILLISECONDS.sleep(randomNumber(100, 300));
                System.out.print(".");
            }
            TimeUnit.MILLISECONDS.sleep(randomNumber(100, 300));

            System.out.println(Color.GREEN.colorize(" [EN LIGNE]"));
        }
    }

    public static void spinner() {
        String[] spinner = { "⠋", "⠙", "⠹", "⠸", "⠼", "⠴", "⠦", "⠧", "⠇", "⠏" };
        try {
            for (int i = 0; i < randomNumber(50, 250); i++) {
                System.out.print(Color.BLUE.colorize("\r" + "► " + spinner[i % spinner.length] + " "));
                TimeUnit.MILLISECONDS.sleep(80);
            }
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static enum Color {
        BLACK((char) 27 + "[30m"),
        RED((char) 27 + "[31m"),
        GREEN((char) 27 + "[32m"),
        YELLOW((char) 27 + "[33m"),
        BLUE((char) 27 + "[34m"),
        PURPLE((char) 27 + "[35m"),
        CYAN((char) 27 + "[36m"),
        WHITE((char) 27 + "[37m");

        private String charCode;

        Color(String charCode) {
            this.charCode = charCode;
        }

        public String colorize(String message) {
            return charCode + message + (char) 27 + "[0m";
        }

        public String boldColorize(String message) {
            return (char) 27 + "[1m" + charCode + message + (char) 27 + "[0m";
        }
    }

}
