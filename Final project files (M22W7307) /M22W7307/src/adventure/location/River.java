package adventure.location;

import adventure.BattleLoc;
import adventure.enemy.Bear;


/**
 * The River class represents a specific type of location called "River".
 * It extends the BattleLoc class, inheriting its properties and methods.
 */
public class River extends BattleLoc {

    /**
     * Constructs a River object with the specified player and default attributes.
     *
     * @param player the player character
     */
    public River(Player player) {
        super(player, "River", new Bear(), 5);
    }
}
