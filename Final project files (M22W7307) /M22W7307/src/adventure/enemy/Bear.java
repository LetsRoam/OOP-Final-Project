package adventure.enemy;

import java.util.Random;

/**
 * The Bear class represents a specific type of enemy called "Bear".
 * It extends the Obstacle class, inheriting its properties and methods.
 */
public class Bear extends Obstacle {

    /**
     * Constructs a Bear object with predefined attributes.
     * The Bear has an ID of 3, a name of "Bear", and random values for its health, attack, and defense.
     */
    public Bear() {
        super(3, "Bear", generateRandomValue(1, 10),
                generateRandomValue(10, 50), generateRandomValue(1, 50));
    }

    /**
     * Generates a random value between the specified minimum and maximum values.
     *
     * @param min the minimum value
     * @param max the maximum value
     * @return a random value between the minimum and maximum values
     */
    private static int generateRandomValue(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
