package adventure;

import adventure.location.Player;
import java.io.*;

/**
 * The GameSaveManager class is responsible for saving and loading game data.
 */
public class GameSaveManager {

    private static final String SAVE_FILE = "saved_game.txt";

    /**
     * Saves the game by serializing the player object to a file.
     *
     * @param player the player object to save
     */
    public static void saveGame(Player player) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            outputStream.writeObject(player);
            System.out.println("Game saved successfully!");
        } catch (IOException e) {
            System.out.println("Failed to save the game: " + e.getMessage());
        }
    }

    /**
     * Loads the game by deserializing the player object from a file.
     *
     * @return the loaded player object, or null if loading failed
     */
    public static Player loadGame() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(SAVE_FILE))) {
            Player player = (Player) inputStream.readObject();
            System.out.println("Game loaded successfully!");
            return player;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to load the game: " + e.getMessage());
        }
        return null;
    }
}
