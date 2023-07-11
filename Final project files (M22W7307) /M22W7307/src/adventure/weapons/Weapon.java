package adventure.weapons;

import java.io.Serializable;

/**
 * The Weapon class represents a weapon in the game.
 * It is Serializable to allow for saving and loading weapon objects.
 */
public class Weapon implements Serializable {

    private String name;    // The name of the weapon
    private int id;         // The ID of the weapon
    private int damage;     // The damage inflicted by the weapon
    private int price;      // The price of the weapon

    /**
     * Constructs a Weapon object with the specified attributes.
     *
     * @param name   the name of the weapon
     * @param id     the ID of the weapon
     * @param damage the damage inflicted by the weapon
     * @param price  the price of the weapon
     */
    public Weapon(String name, int id, int damage, int price) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    /**
     * Retrieves the name of the weapon.
     *
     * @return the name of the weapon
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the weapon.
     *
     * @param name the name of the weapon
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the ID of the weapon.
     *
     * @return the ID of the weapon
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the weapon.
     *
     * @param id the ID of the weapon
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the damage inflicted by the weapon.
     *
     * @return the damage inflicted by the weapon
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Sets the damage inflicted by the weapon.
     *
     * @param damage the damage inflicted by the weapon
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Retrieves the price of the weapon.
     *
     * @return the price of the weapon
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the weapon.
     *
     * @param price the price of the weapon
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Retrieves an array of available weapons in the game.
     *
     * @return an array of available weapons
     */
    public static Weapon[] weapons() {
        Weapon[] weapons = {
                new Weapon("Gun", 1, 2, 10),
                new Weapon("Sword", 2, 3, 12),
                new Weapon("Katana", 3, 10, 40),
                new Weapon("Rifle", 4, 7, 35)
        };
        return weapons;
    }

    /**
     * Retrieves the weapon with the specified ID.
     *
     * @param id the ID of the weapon to retrieve
     * @return the weapon with the specified ID, or null if not found
     */
    public static Weapon getWeapon(int id) {
        for (Weapon weapon : Weapon.weapons()) {
            if (weapon.getId() == id) {
                return weapon;
            }
        }
        return null;
    }
}
