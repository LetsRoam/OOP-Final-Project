package adventure;

import adventure.location.Location;
import adventure.location.Player;

/**
 * The NormalLoc class represents a normal location in the game, where the player can perform actions.
 * It extends the Location class and provides an implementation of the onLocation method.
 */
public abstract class NormalLoc extends Location {

    /**
     * Creates a new NormalLoc object with the specified player and name.
     *
     * @param player the player in the game
     * @param name   the name of the location
     */
    public NormalLoc(Player player, String name) {
        super(player, name);
    }

    /**
     * Executes the actions to be performed at the normal location.
     *
     * @return true to continue the game, false to end the game
     */
    @Override
    public boolean onLocation() {
        return true;
    }

}
