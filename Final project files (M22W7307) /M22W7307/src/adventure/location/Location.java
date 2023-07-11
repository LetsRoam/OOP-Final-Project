package adventure.location;

import java.io.Serializable;
import java.util.Scanner;

/**
 * The Location class represents a generic location in the game.
 * It is an abstract class that provides common attributes and methods for different locations.
 */
public abstract class Location implements Serializable {

    private Player player;       // The player character
    private String name;         // The name of the location
    public static Scanner sc = new Scanner(System.in);  // Scanner object for user input

    /**
     * Constructs a Location object with the specified player and name.
     *
     * @param player the player character
     * @param name   the name of the location
     */
    public Location(Player player, String name) {
        this.player = player;
        this.name = name;
    }

    /**
     * Retrieves the player character.
     *
     * @return the player character
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Sets the player character.
     *
     * @param player the player character
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Retrieves the name of the location.
     *
     * @return the name of the location
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the location.
     *
     * @param name the name of the location
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Abstract method to be implemented by subclasses.
     * Specifies the behavior of the location.
     *
     * @return true if the player remains on the location, false otherwise
     */
    public abstract boolean onLocation();
}
