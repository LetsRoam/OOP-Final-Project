package adventure;

import adventure.location.*;
import java.util.Scanner;

/**
 * The Game class represents the main game logic and flow.
 */
public class Game {

    private Scanner sc = new Scanner(System.in);

    /**
     * Starts the game by displaying the main menu and handling user choices.
     */
    public void start() {
        System.out.println("Welcome to the game.");

        int choice = displayMainMenu();

        if (choice == 1) {
            startNewGame();
        } else if (choice == 2) {
            loadSavedGame();
        } else {
            System.out.println("Invalid choice. Exiting the game.");
        }
    }

    /**
     * Displays the main menu and prompts the user to select an option.
     *
     * @return the user's choice
     */
    private int displayMainMenu() {
        System.out.println("Please select an option:");
        System.out.println("1 - Start New Game");
        System.out.println("2 - Load Saved Game");

        int select;
        do {
            select = promptPlayerInput("Enter your choice: ");
            if (select < 1 || select > 2) {
                System.out.println("Invalid input. Please enter a valid option (1 or 2).");
            }
        } while (select < 1 || select > 2);

        return select;
    }

    /**
     * Starts a new game by creating a player, selecting a character, and initiating the game flow.
     */
    private void startNewGame() {
        System.out.println("Please enter your name: ");
        String playerName = sc.next();

        Player player = new Player(playerName, sc);
        System.out.println(player.getName() + ", be ready for a great adventure!");
        System.out.println("It is time for you to choose your character to begin!\n");
        player.selectCharacter();

        playGame(player);
    }

    /**
     * Loads a saved game from a file and resumes the game.
     */
    private void loadSavedGame() {
        Player player = GameSaveManager.loadGame();

        if (player != null) {
            System.out.println("Welcome back, " + player.getName() + "!");
            playGame(player);
        } else {
            System.out.println("Failed to load the saved game.");
        }
    }

    /**
     * Starts the game flow by repeatedly prompting the player to select a location and performing the corresponding actions.
     *
     * @param player the player object
     */
    private void playGame(Player player) {
        Location location = null;

        while (true) {
            player.playerInfo();
            System.out.println("\n**************************************************");
            System.out.println("Please select the location you want to go:\n");
            System.out.println("1 - Safe House"
                    + "\n2 - Store => Buy items."
                    + "\n3 - Cave => Fight with zombies."
                    + "\n4 - Forest => Fight with vampires."
                    + "\n5 - River => Fight with bears."
                    + "\n6 - Save the Game"
                    + "\n7 - Load the Game"
                    + "\n0 - End the Game");

            int select = promptPlayerInput("Enter your choice: ");

            switch (select) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Store(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    GameSaveManager.saveGame(player);
                    continue;
                case 7:
                    GameSaveManager.loadGame();
                    continue;
                default:
                    System.out.println("Please enter a valid value!\n");
                    continue;
            }

            if (location == null) {
                System.out.println("You left the game!");
                break;
            }

            if (!location.onLocation()) {
                System.out.println("GAME OVER!");
                break;
            }
        }
    }

    /**
     * Prompts the player to enter a number.
     *
     * @param message the message to display
     * @return the number entered by the player
     */
    private int promptPlayerInput(String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            sc.next(); // Clear the invalid input
            System.out.println("Invalid input. Please enter a number.");
            System.out.print(message);
        }
        return sc.nextInt();
    }
}
