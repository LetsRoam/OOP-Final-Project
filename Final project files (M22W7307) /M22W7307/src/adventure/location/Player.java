package adventure.location;

import adventure.armor.Armor;
import adventure.Inventory;
import adventure.weapons.Weapon;
import adventure.warriors.Character;
import adventure.warriors.Archer;
import adventure.warriors.Knight;
import adventure.warriors.Samurai;

import java.io.Serializable;
import java.util.Scanner;

/**
 * The Player class represents the player character in the game.
 * It contains attributes and methods related to the player's character.
 */
public class Player implements Serializable {

    private int damage;                    // The damage of the player
    private int health;                    // The current health of the player
    private int defaultHealth;             // The default or maximum health of the player
    private int money;                     // The amount of money the player has
    private String name;                   // The name of the player
    private String selectedCharacter;      // The name of the selected character

    private Inventory inventory;           // The inventory of the player
    private transient Scanner sc;          // Scanner object for user input

    /**
     * Initializes the Scanner object for user input.
     */
    public void initializeScanner() {
        this.sc = new Scanner(System.in);
    }

    /**
     * Constructs a Player object with the specified name and Scanner object.
     *
     * @param name the name of the player
     * @param sc   the Scanner object for user input
     */
    public Player(String name, Scanner sc) {
        this.name = name;
        this.sc = sc;
        this.inventory = new Inventory();
    }

    /**
     * Retrieves the total damage of the player, including the weapon damage.
     *
     * @return the total damage of the player
     */
    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    /**
     * Retrieves the damage of the player.
     *
     * @return the damage of the player
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Sets the damage of the player.
     *
     * @param damage the damage of the player
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Retrieves the current health of the player.
     *
     * @return the current health of the player
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the current health of the player.
     * If the health goes below 0, it is set to 0.
     *
     * @param health the current health of the player
     */
    public void setHealth(int health) {
        if (health < 0)
            health = 0;
        this.health = health;
    }

    /**
     * Retrieves the default or maximum health of the player.
     *
     * @return the default or maximum health of the player
     */
    public int getDefaultHealth() {
        return defaultHealth;
    }

    /**
     * Sets the default or maximum health of the player.
     *
     * @param defaultHealth the default or maximum health of the player
     */
    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    /**
     * Retrieves the amount of money the player has.
     *
     * @return the amount of money the player has
     */
    public int getMoney() {
        return money;
    }

    /**
     * Sets the amount of money the player has.
     *
     * @param money the amount of money the player has
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Retrieves the name of the player.
     *
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the player.
     *
     * @param name the name of the player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of the selected character.
     *
     * @return the name of the selected character
     */
    public String getSelectedCharacter() {
        return selectedCharacter;
    }

    /**
     * Sets the name of the selected character.
     *
     * @param selectedCharacter the name of the selected character
     */
    public void setSelectedCharacter(String selectedCharacter) {
        this.selectedCharacter = selectedCharacter;
    }

    /**
     * Retrieves the inventory of the player.
     *
     * @return the inventory of the player
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Sets the inventory of the player.
     *
     * @param inventory the inventory of the player
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Retrieves the weapon equipped by the player.
     *
     * @return the weapon equipped by the player
     */
    public Weapon getWeapon() {
        return this.getInventory().getWeapon();
    }

    /**
     * Retrieves the armor equipped by the player.
     *
     * @return the armor equipped by the player
     */
    public Armor getArmor() {
        return this.getInventory().getArmor();
    }

    /**
     * Sets the attributes of the player based on the specified character.
     *
     * @param character the character selected by the player
     */
    public void selectCharacter(Character character) {
        this.setSelectedCharacter(character.getName());
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setDefaultHealth(character.getHealth());
        this.setMoney(character.getMoney());
    }

    /**
     * Prints the information of the player, including character, weapon, armor, damage, health, and money.
     */
    public void playerInfo() {
        System.out.println(this.getSelectedCharacter() + " => "
                + " Weapon: " + this.getInventory().getWeapon().getName()
                + " Armor: " + this.getInventory().getArmor().getName()
                + " Block: " + this.getInventory().getArmor().getBlock()
                + " Damage: " + this.getTotalDamage()
                + " Health: " + this.getHealth()
                + " Money: " + this.getMoney());
    }

    /**
     * Allows the player to select a character from the available options.
     */
    public void selectCharacter() {
        System.out.println("Meet awesome warriors: ");

        Character[] characters = {new Samurai(), new Archer(), new Knight()};
        for (Character ch : characters) {
            System.out.println("Id: " + ch.getId() + ", " + ch.getName() + " => Damage: " + ch.getDamage() + " Health: " + ch.getHealth() + " Money: " + ch.getMoney());
        }

        int select;
        do {
            select = promptPlayerInput("Enter the ID of the character: ");
            if (select < 1 || select > 3) {
                System.out.println("Invalid input. Please enter a valid character ID (1, 2, or 3).");
            }
        } while (select < 1 || select > 3);

        switch (select) {
            case 1:
                selectCharacter(new Samurai());
                break;
            case 2:
                selectCharacter(new Archer());
                break;
            case 3:
                selectCharacter(new Knight());
                break;
            default:
                selectCharacter(new Samurai());
                break;
        }
    }

    /**
     * Prompts the player for input and returns the entered integer value.
     *
     * @param message the message to display for input
     * @return the entered integer value
     */
    private int promptPlayerInput(String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            sc.next(); // Clear the invalid input
            System.out.println("Invalid input. Please enter a number.");
            System.out.print(message);
        }
        return sc.nextInt();
    }
}
