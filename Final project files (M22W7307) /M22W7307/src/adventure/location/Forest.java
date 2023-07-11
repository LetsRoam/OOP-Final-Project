package adventure.location;

import adventure.BattleLoc;
import adventure.enemy.Vampire;


/**
 * The Forest class represents a specific type of location called "Forest".
 * It extends the BattleLoc class, inheriting its properties and methods.
 */
public class Forest extends BattleLoc {

    /**
     * Constructs a Forest object with the specified player and default attributes.
     *
     * @param player the player character
     */
    public Forest(Player player) {
        super(player, "Forest", new Vampire(), 5);
    }
}
