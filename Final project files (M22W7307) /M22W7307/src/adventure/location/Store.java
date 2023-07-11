package adventure.location;

import adventure.armor.Armor;
import adventure.NormalLoc;
import adventure.weapons.Weapon;

/**
 * The Store class represents a specific type of location called "Store".
 * It extends the NormalLoc class, inheriting its properties and methods.
 */
public class Store extends NormalLoc {

    /**
     * Constructs a Store object with the specified player and default attributes.
     *
     * @param player the player character
     */
    public Store(Player player) {
        super(player, "Tool Store");
    }

    /**
     * Overrides the onLocation method from the parent class.
     * Handles the behavior of the player when they are at the store location.
     *
     * @return true to stay on the location
     */
    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the Store.");

        boolean menu = true;
        while (menu) {
            System.out.println("\nPlease select:"
                    + "\n1 for weapons"
                    + "\n2 for armors"
                    + "\nand 3 to exit.");
            int select = promptPlayerInput("Enter your choice: ");

            while (select < 1 || select > 3) {
                System.out.println("You entered an invalid value, please try again: ");
                select = promptPlayerInput("Enter your choice: ");
            }

            switch (select) {
                case 1:
                    printWeapons();
                    buyWeapon();
                    break;

                case 2:
                    printArmors();
                    buyArmor();
                    break;

                case 3:
                    System.out.println("You left the tool store.");
                    menu = false;
                    break;
            }
        }

        return true;
    }

    /**
     * Displays the available weapons in the store.
     */
    public void printWeapons() {
        System.out.println("Great weapons that will help you win your fights!");
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println(weapon.getId() + ", " + weapon.getName() + " => Damage: " + weapon.getDamage() + " Price: " + weapon.getPrice());
        }
        System.out.println("0 => Exit");
    }

    /**
     * Allows the player to buy a weapon from the store.
     */
    public void buyWeapon() {
        System.out.println("It's time to choose your weapon. Choose wisely: ");
        int select = promptPlayerInput("Enter your choice: ");

        while (select < 0 || select > Weapon.weapons().length) {
            System.out.println("You entered an invalid value, please try again: ");
            select = promptPlayerInput("Enter your choice: ");
        }

        if (select != 0) {
            Weapon selectedWeapon = Weapon.getWeapon(select);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money!");
                } else {
                    System.out.println("You bought " + selectedWeapon.getName());
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedWeapon.getPrice());
                    System.out.println("Remaining money: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }
    }

    /**
     * Displays the available armors in the store.
     */
    public void printArmors() {
        System.out.println("Protect yourself!");
        for (Armor armor : Armor.armors()) {
            System.out.println(armor.getId() + ", " + armor.getName() + " => Block: " + armor.getBlock() + " Price: " + armor.getPrice());
        }
        System.out.println("0 => Exit");
    }

    /**
     * Allows the player to buy an armor from the store.
     */
    public void buyArmor() {
        System.out.println("It's time to choose your armor. Choose wisely: ");
        int select = promptPlayerInput("Enter your choice: ");

        while (select < 0 || select > Armor.armors().length) {
            System.out.println("You entered an invalid value, please try again: ");
            select = promptPlayerInput("Enter your choice: ");
        }

        if (select != 0) {
            Armor selectedArmor = Armor.getArmor(select);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money!");
                } else {
                    System.out.println("You bought " + selectedArmor.getName());
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    System.out.println("Remaining money: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
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
