package adventure;

import adventure.armor.Armor;
import adventure.weapons.Weapon;

import java.io.Serializable;

/**
 * The Inventory class represents the player's inventory in the game, which includes a weapon and armor.
 */
public class Inventory implements Serializable {

    private Weapon weapon;
    private Armor armor;

    /**
     * Creates a new Inventory object with default weapon and armor.
     */
    public Inventory() {
        this.weapon = new Weapon("Fist", -1, 0, 0);
        this.armor = new Armor("Rag", -1, 0, 0);
    }

    /**
     * Returns the weapon in the inventory.
     *
     * @return the weapon
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Sets the weapon in the inventory.
     *
     * @param weapon the weapon to set
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Returns the armor in the inventory.
     *
     * @return the armor
     */
    public Armor getArmor() {
        return armor;
    }

    /**
     * Sets the armor in the inventory.
     *
     * @param armor the armor to set
     */
    public void setArmor(Armor armor) {
        this.armor = armor;
    }

}
