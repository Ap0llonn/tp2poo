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
        System.out.println(Color.BLUE.colorize("║           0  ") + Color.GREEN.colorize("NEW GAME")
                + Color.BLUE.colorize("                ║"));
        System.out.println(Color.BLUE.colorize("║                                      ║"));
        System.out.println(Color.BLUE.colorize("║           1  ") + Color.GREEN.colorize("QUIT")
                + Color.BLUE.colorize("                    ║"));
        System.out.println(Color.BLUE.colorize("║                                      ║"));
        System.out.println(Color.BLUE.colorize("╚══════════════════════════════════════╝"));
    }

    public static String getPlayerName() {
        //textPrint("Votre esprit émerge lentement du brouillard...", 50);
        //textPrint("Une voix perce le silence :", 50);
        //textPrint("Vous êtes enfin réveillé... Dites-moi, comment vous appelez-vous ?", 50);
        //textPrint("Quel est votre prénom ? ", 50);
        String firstName = Console.getInputString();
        //textPrint("Et votre nom de famille ? ", 50);
        String lastName = Console.getInputString();

        clearConsole();
        //textPrint("Bienvenue " + firstName + " " + lastName + ", votre aventure commence ici.", 50);
        //textPrint("Préparez-vous à plonger dans un monde où chaque choix compte.", 50);
        //textPrint("Votre destin est entre vos mains.", 50);
        //textPrint("Soyez le dernier en vie et sorter d'ici vivant", 50);
        //textPrint("Bonne chance !", 50);

        return firstName + " " + lastName;
    }

    public static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void winnerMessage() {
        clearConsole();
        startGameLoading();
        spinner();
        clearConsole();
        textPrint("Vous vous réveillez en sursaut, haletant.", 50);
        textPrint("Les lumières froides du laboratoire clignotent au-dessus de vous.", 50);
        textPrint("Un scientifique en blouse blanche s'approche, prenant des notes sur son carnet.", 50);
        textPrint("\"Fascinant... Vous avez survécu. La simulation est terminée.\"", 50);
        textPrint("Vous sentez encore l'adrénaline du combat, mais tout cela... n'était qu'un test.", 50);
        textPrint("Que ferez-vous maintenant, sachant que ce monde n'était qu'une illusion ?", 50);
    }

    public static void nextDay(){
        System.out.println(Color.YELLOW.colorize("Appuyez sur une touche pour continuer..."));
        Scanner scanner = new Scanner(System.in);
        scanner.next();
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

    public static void randomSuccessExplorationMessage() {

        String[] messages = {
                "Vous découvrez un trésor caché dans les profondeurs de cet endroit !",
                "Votre exploration porte ses fruits ! Vous trouvez des ressources précieuses.",
                "Une découverte fascinante vous attend au bout du chemin.",
                "Vous tombez sur un passage secret menant à une zone inexplorée.",
                "Vos efforts sont récompensés par une trouvaille rare et précieuse.",
                "Cette zone regorge de richesses que vous vous empressez de récupérer.",
                "Un ancien artefact se révèle à vous au cours de votre exploration.",
                "Vous découvrez un lieu mystérieux rempli d'objets de valeur.",
                "Une cache bien dissimulée contient des trésors inestimables.",
                "Votre persévérance paie ! Vous mettez la main sur quelque chose d'unique.",
                "Une surprenante découverte fait de cette exploration un franc succès !"
        };

        System.out.println(Color.GREEN.colorize("[EXPLORATION] " + messages[randomNumber(0, messages.length - 1)]));
    }

    public static void randomFailExplorationMessage() {

        String[] messages = {
                "Vous explorerez un endroit dangereux ! Vous ne trouvez rien.",
                "Votre exploration s'avère infructueuse. Rien d'intéressant à signaler.",
                "Des bruits étranges vous font reculer. Cette exploration est un échec.",
                "Le terrain est trop instable pour continuer. Vous revenez bredouille.",
                "Une tempête se lève soudainement, vous forçant à abandonner l'exploration.",
                "Un éboulement bloque votre chemin. Impossible de continuer l'exploration.",
                "Des créatures hostiles rôdent dans les environs. Mieux vaut battre en retraite.",
                "La visibilité est trop mauvaise. Vous décidez de revenir plus tard.",
                "Vous tombez sur un cul-de-sac. Cette zone ne mène nulle part.",
                "Vos ressources s'épuisent rapidement. Vous devez interrompre l'exploration.",
                "Un mauvais pressentiment vous envahit. Parfois, il vaut mieux écouter son instinct."
        };

        System.out.println(Color.RED.colorize("[EXPLORATION] " + messages[randomNumber(0, messages.length - 1)]));
    }

    public static void randomSuccessHuntMessage() {

        String[] messages = {
                "Votre patience est récompensée ! Vous abattez une proie de belle taille.",
                "Vos talents de chasseur vous permettent de capturer une proie succulente.",
                "Une chasse fructueuse ! Vous ramenez suffisamment de viande pour un festin.",
                "Votre flèche atteint sa cible avec précision. Belle prise !",
                "Vous tendez un piège parfait et capturez une créature rare.",
                "Votre technique de chasse impeccable vous assure une prise remarquable.",
                "Après une traque minutieuse, vous revenez avec un gibier de choix.",
                "Cette chasse est un véritable succès ! Le gibier est abondant.",
                "Vous surprenez votre proie au moment idéal. Une chasse exemplaire !",
                "Vos compétences de chasseur font merveille. Une prise impressionnante !",
                "Le gibier est particulièrement gras. Quelle chance pour votre garde-manger !"
        };

        System.out.println(Color.GREEN.colorize("[CHASSE] " + messages[randomNumber(0, messages.length - 1)]));
    }

    public static void randomFailHuntMessage() {

        String[] messages = {
                "Votre proie vous échappe au dernier moment. La chasse est un échec.",
                "Malgré vos efforts, vous rentrez bredouille de cette expédition.",
                "Le gibier est trop rapide aujourd'hui. Votre chasse ne donne rien.",
                "Un bruit soudain effraie toutes les créatures alentour. Chasse infructueuse.",
                "Vos pièges sont vides. La chance n'était pas de votre côté.",
                "Les traces s'arrêtent brusquement. Impossible de retrouver votre proie.",
                "Les animaux semblent avoir déserté la zone. Pas la moindre prise.",
                "Votre flèche manque sa cible qui s'enfuit à toute vitesse.",
                "Les conditions météorologiques rendent la chasse impossible aujourd'hui.",
                "Un prédateur plus grand a fait fuir tout le gibier. Chasse annulée.",
                "Vous passez des heures à traquer sans résultat. Une journée à oublier."
        };

        System.out.println(Color.RED.colorize("[CHASSE] " + messages[randomNumber(0, messages.length - 1)]));
    }

    public static void randomSuccessSleepMessage() {

        String[] messages = {
                "Vous vous réveillez parfaitement reposé et plein d'énergie pour la journée.",
                "Une nuit paisible vous a permis de récupérer toutes vos forces.",
                "Ce sommeil réparateur vous a totalement revitalisé.",
                "Vous ouvrez les yeux après un repos parfait. Vous vous sentez invincible !",
                "Cette sieste vous a fait le plus grand bien. Vous êtes prêt à repartir à l'aventure.",
                "Un sommeil sans rêve vous laisse frais et dispos.",
                "Votre esprit est clair et vos muscles détendus après ce repos salutaire.",
                "Ce sommeil profond vous a complètement régénéré.",
                "Vous vous réveillez en pleine forme, comme si vous étiez né une seconde fois.",
                "Ce repos bien mérité vous a rendu toute votre vigueur.",
                "Un sommeil de qualité, voilà ce dont vous aviez besoin ! Vous êtes au meilleur de votre forme."
        };

        System.out.println(Color.GREEN.colorize("[REPOS] " + messages[randomNumber(0, messages.length - 1)]));
    }

    public static void randomSuccessDeadMessage() {

        String[] messages = {
                "Votre adversaire s'effondre sous vos coups. Victoire !",
                "D'un coup final précis, vous terrassez votre ennemi.",
                "Votre stratégie a payé. Votre opposant gît à vos pieds.",
                "Une bataille difficile, mais vous en sortez victorieux.",
                "Votre adversaire n'était pas de taille face à votre puissance.",
                "Vos attaques répétées ont eu raison de la résistance ennemie.",
                "L'affrontement prend fin avec la chute de votre adversaire.",
                "Vous avez combattu avec bravoure et triomphé de votre ennemi.",
                "Le combat s'achève sur votre victoire éclatante.",
                "Votre détermination a été plus forte. L'ennemi est vaincu.",
                "Un dernier coup et c'est terminé. Vous contemplez votre adversaire défait."
        };

        System.out.println(Color.YELLOW.colorize("[COMBAT] " + messages[randomNumber(0, messages.length - 1)]));
    }

    public static void randomFailDeadMessage() {

        String[] messages = {
                "Votre vision s'obscurcit alors que vous rendez votre dernier souffle...",
                "Vos forces vous abandonnent. Vous vous effondrez, sans vie.",
                "Une douleur fulgurante, puis plus rien. Votre aventure s'achève ici.",
                "Le coup fatal a été porté. Vous ne vous relèverez pas cette fois.",
                "Vous luttez pour rester conscient, mais l'obscurité vous engloutit finalement.",
                "Votre cœur ralentit, puis s'arrête. Votre quête se termine prématurément.",
                "Trop affaibli pour continuer, vous succombez à vos blessures.",
                "Un dernier regard vers le ciel, puis vos yeux se ferment pour toujours.",
                "Le froid vous envahit alors que la vie quitte votre corps.",
                "Malgré votre volonté, la mort vous réclame. C'est la fin du voyage.",
                "Vous tombez à genoux, puis basculez face contre terre. Le rideau tombe."
        };

        System.out.println(Color.RED.colorize("[MORT] " + messages[randomNumber(0, messages.length - 1)]));
    }

    public static void randomStartCombatMessage() {
        String[] messages = {
                "Vous faites face à votre adversaire. Un seul en sortira vainqueur...",
                "Vos regards se croisent, la tension est à son comble. Le duel commence !",
                "L’ennemi se met en garde, prêt à frapper. Il est temps d’en découdre !",
                "Le vent s’arrête, les secondes s’étirent... Puis, le combat éclate !",
                "Votre adversaire esquisse un sourire confiant. Montrez-lui ce que vous valez !",
                "Un duel à mort s’engage. Votre survie dépend de chaque mouvement !",
                "Les poings se serrent, l’acier brille... Le face-à-face est inévitable.",
                "Plus de mots, plus d’échappatoire. Seule la victoire compte désormais.",
                "Votre rival vous jauge, cherchant une faille. Ne lui laissez aucune chance !",
                "Le duel commence, chaque seconde peut sceller votre destin !"
        };

        System.out.println(Color.YELLOW.colorize("[COMBAT] " + messages[randomNumber(0, messages.length - 1)]));
    }

    // methode de claud ai
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

            clearConsole();
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

    public static void textPrint(String text, long delay) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
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
