package adventure.location;

import adventure.NormalLoc;


/**
 * The SafeHouse class represents a specific type of location called "Safe House".
 * It extends the NormalLoc class, inheriting its properties and methods.
 */
public class SafeHouse extends NormalLoc {

    /**
     * Constructs a SafeHouse object with the specified player and default attributes.
     *
     * @param player the player character
     */
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    /**
     * Overrides the onLocation method from the parent class.
     * Restores the player's health and displays a message.
     *
     * @return true to stay on the location
     */
    @Override
    public boolean onLocation() {
        System.out.println("You are at the safe house, your health has been reset.");
        this.getPlayer().setHealth(this.getPlayer().getDefaultHealth());
        return true;
    }
}
