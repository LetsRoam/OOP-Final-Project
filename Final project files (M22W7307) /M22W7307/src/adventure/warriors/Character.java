package adventure.warriors;

/**
 * The Character class represents a character in the game.
 * It is an abstract class that provides common attributes and methods for different character types.
 */
public abstract class Character {

    private int id;         // The ID of the character
    private int damage;     // The damage inflicted by the character
    private int health;     // The current health of the character
    private int money;      // The amount of money the character has
    private String name;    // The name of the character

    /**
     * Constructs a Character object with the specified attributes.
     *
     * @param id     the ID of the character
     * @param name   the name of the character
     * @param damage the damage inflicted by the character
     * @param health the current health of the character
     * @param money  the amount of money the character has
     */
    public Character(int id, String name, int damage, int health, int money) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    /**
     * Retrieves the ID of the character.
     *
     * @return the ID of the character
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the character.
     *
     * @param id the ID of the character
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the damage inflicted by the character.
     *
     * @return the damage inflicted by the character
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Sets the damage inflicted by the character.
     *
     * @param damage the damage inflicted by the character
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Retrieves the current health of the character.
     *
     * @return the current health of the character
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the current health of the character.
     *
     * @param health the current health of the character
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Retrieves the amount of money the character has.
     *
     * @return the amount of money the character has
     */
    public int getMoney() {
        return money;
    }

    /**
     * Sets the amount of money the character has.
     *
     * @param money the amount of money the character has
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Retrieves the name of the character.
     *
     * @return the name of the character
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the character.
     *
     * @param name the name of the character
     */
    public void setName(String name) {
        this.name = name;
    }
}
