package adventure.enemy;

import java.util.Random;

/**
 * The Vampire class represents a specific type of enemy called "Vampire".
 * It extends the Obstacle class, inheriting its properties and methods.
 */
public class Vampire extends Obstacle {

    /**
     * Constructs a Vampire object with predefined attributes.
     * The Vampire has an ID of 1, a name of "Vampire", and random values for its health, attack, and defense.
     */
    public Vampire() {
        super(1, "Vampire", generateRandomValue(1, 10),
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
