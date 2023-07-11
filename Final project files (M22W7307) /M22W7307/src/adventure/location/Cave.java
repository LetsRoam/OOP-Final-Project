package adventure.location;

import adventure.BattleLoc;
import adventure.enemy.Zombie;


/**
 * The Cave class represents a specific type of location called "Cave".
 * It extends the BattleLoc class, inheriting its properties and methods.
 */
public class Cave extends BattleLoc {

    /**
     * Constructs a Cave object with the specified player and default attributes.
     *
     * @param player the player character
     */
    public Cave(Player player) {
        super(player, "Cave", new Zombie(), 5);
    }
}
