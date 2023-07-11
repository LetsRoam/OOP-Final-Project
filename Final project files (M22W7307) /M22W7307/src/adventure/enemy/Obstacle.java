package adventure.enemy;

import java.io.Serializable;

/**
 * The Obstacle class represents an obstacle or enemy in the game.
 * It provides attributes such as ID, name, damage, health, money, and default health.
 */
public class Obstacle implements Serializable {

    private int id;             // The unique identifier of the obstacle
    private String name;        // The name of the obstacle
    private int damage;         // The amount of damage the obstacle can inflict
    private int health;         // The current health of the obstacle
    private int money;          // The amount of money the obstacle yields when defeated
    private int defaultHealth;  // The default or maximum health of the obstacle

    /**
     * Constructs an Obstacle object with the specified ID, name, damage, health, and money.
     *
     * @param id      the unique identifier of the obstacle
     * @param name    the name of the obstacle
     * @param damage  the amount of damage the obstacle can inflict
     * @param health  the current health of the obstacle
     * @param money   the amount of money the obstacle yields when defeated
     */
    public Obstacle(int id, String name, int damage, int health, int money) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.setDefaultHealth(health);
        this.money = money;
    }

    /**
     * Retrieves the ID of the obstacle.
     *
     * @return the ID of the obstacle
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the obstacle.
     *
     * @param id the ID of the obstacle
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the damage of the obstacle.
     *
     * @return the damage of the obstacle
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Sets the damage of the obstacle.
     *
     * @param damage the damage of the obstacle
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Retrieves the current health of the obstacle.
     *
     * @return the current health of the obstacle
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the health of the obstacle.
     * If the health goes below 0 (after being hit), it is set to 0.
     *
     * @param health the health of the obstacle
     */
    public void setHealth(int health) {
        if (health < 0)
            health = 0;
        this.health = health;
    }

    /**
     * Retrieves the name of the obstacle.
     *
     * @return the name of the obstacle
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the obstacle.
     *
     * @param name the name of the obstacle
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the amount of money the obstacle yields when defeated.
     *
     * @return the amount of money the obstacle yields
     */
    public int getMoney() {
        return money;
    }

    /**
     * Sets the amount of money the obstacle yields when defeated.
     *
     * @param money the amount of money the obstacle yields
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Retrieves the default or maximum health of the obstacle.
     *
     * @return the default or maximum health of the obstacle
     */
    public int getDefaultHealth() {
        return defaultHealth;
    }

    /**
     * Sets the default or maximum health of the obstacle.
     *
     * @param defaultHealth the default or maximum health of the obstacle
     */
    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }
}
