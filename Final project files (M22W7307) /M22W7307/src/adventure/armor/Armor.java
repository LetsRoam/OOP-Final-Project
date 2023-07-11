package adventure.armor;

import java.io.Serializable;

/**
 * The Armor class represents a piece of armor that can be worn by characters in the game.
 * It provides attributes such as name, ID, block value, and price.
 */
public class Armor implements Serializable {

    private String name;   // The name of the armor
    private int id;        // The unique identifier of the armor
    private int block;     // The amount of block the armor provides
    private int price;     // The price of the armor in the game

    /**
     * Constructs an Armor object with the specified name, ID, block value, and price.
     *
     * @param name   the name of the armor
     * @param id     the unique identifier of the armor
     * @param block  the amount of block the armor provides
     * @param price  the price of the armor in the game
     */
    public Armor(String name, int id, int block, int price) {
        super();
        this.name = name;
        this.id = id;
        this.block = block;
        this.price = price;
    }

    /**
     * Retrieves the name of the armor.
     *
     * @return the name of the armor
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the armor.
     *
     * @param name the name of the armor
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the ID of the armor.
     *
     * @return the ID of the armor
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the armor.
     *
     * @param id the ID of the armor
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the block value of the armor.
     *
     * @return the block value of the armor
     */
    public int getBlock() {
        return block;
    }

    /**
     * Sets the block value of the armor.
     *
     * @param block the block value of the armor
     */
    public void setBlock(int block) {
        this.block = block;
    }

    /**
     * Retrieves the price of the armor.
     *
     * @return the price of the armor
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the armor.
     *
     * @param price the price of the armor
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Returns an array of pre-defined Armor objects.
     *
     * @return an array of Armor objects
     */
    public static Armor[] armors() {
        Armor[] armors = {new Armor("Light Armor", 1, 1, 15),
                new Armor("Medium Weight Armor", 2, 3, 25),
                new Armor("Heavy Armor", 3, 5, 40)};
        return armors;
    }

    /**
     * Retrieves the Armor object with the specified ID.
     *
     * @param id the ID of the armor to retrieve
     * @return the Armor object with the specified ID, or null if not found
     */
    public static Armor getArmor(int id) {
        for (Armor armor : Armor.armors()) {
            if (armor.getId() == id) {
                return armor;
            }
        }
        return null;
    }
}
