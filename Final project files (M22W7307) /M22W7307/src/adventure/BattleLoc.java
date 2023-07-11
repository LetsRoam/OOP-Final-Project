package adventure;

import adventure.enemy.Obstacle;
import adventure.location.Location;
import adventure.location.Player;

/**
 * The BattleLoc class represents a specific type of location called a "Battle Location".
 * It extends the Location class and includes attributes and methods related to battles with obstacles.
 */
public abstract class BattleLoc extends Location {

    private Obstacle obstacle;  // The obstacle present in the battle location
    private String award;       // The award received upon winning the battle
    private int maxObstacle;    // The maximum number of obstacles in the battle

    /**
     * Constructs a BattleLoc object with the specified attributes.
     *
     * @param player       the player object
     * @param name         the name of the battle location
     * @param obstacle     the obstacle present in the battle location
     * @param maxObstacle  the maximum number of obstacles in the battle
     */
    public BattleLoc(Player player, String name, Obstacle obstacle, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obstNumber = this.obstacleNumber();
        System.out.println("You are at: " + this.getName());
        System.out.println("Be careful, there are " + obstNumber + " " + this.getObstacle().getName() + "(s) here!");

        while (true) {
            System.out.println("\n* * * GAME TIME * * *");
            System.out.println("Shall we begin? If you would like to combat, please enter 'C'. To escape, enter 'E'.");
            String select = promptPlayerInput("Enter your choice: ");

            if (select.equals("C")) {
                if (combat(obstNumber)) {
                    System.out.println("You defeated all the enemies at the " + this.getName() + ". YOU WIN!!!\n");
                    return true;
                }
            } else if (select.equals("E")) {
                return false; // Escape
            } else {
                System.out.println("Invalid input. Please enter 'C' to combat or 'E' to escape.");
            }
        }
    }


    /**
     * Generates a random number representing the number of obstacles in the battle.
     *
     * @return the number of obstacles in the battle
     */
    public int obstacleNumber() {
        int random = (int) (Math.random() * this.getMaxObstacle() + 1);
        return random;
    }

    /**
     * Handles the combat with obstacles.
     *
     * @param obstacleNumber the number of obstacles in the battle
     * @return true if the player wins the battle, false otherwise
     */
    public boolean combat(int obstacleNumber) {
        for (int i = 0; i < obstacleNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getDefaultHealth());
            playerStats();
            obstacleStats(i);

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("Enter 'F' for a great war or 'E' to escape like a coward!");
                String select = promptPlayerInput("Enter your choice: ");


                if (select.equals("F")) {
                    whoHit();
                    afterHit();
                } else if (select.equals("E")) {
                    return false; // Escape
                } else {
                    System.out.println("Invalid input. Please enter 'F' to fight or 'E' to escape.");
                }
            }

            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println();
                System.out.println("You have defeated the enemy!");
                System.out.println("You won " + this.getObstacle().getMoney() + " gold!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getMoney());
                System.out.println("Your current money: " + this.getPlayer().getMoney());
                System.out.println();
            } else {
                return false; // Player is defeated
            }
        }

        return true;
    }


    /**
     * Determines who hits in the battle based on a random chance.
     * Updates the health of the player and the obstacle accordingly.
     */
    public void whoHit() {
        double random = Math.random() * 100;
        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getArmor().getBlock();
        if (obstacleDamage < 0)
            obstacleDamage = 0;
        if (random >= 50) {
            System.out.println("You hit!");
            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
        } else {
            System.out.println("Obstacle hit you!");
            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
        }
    }

    /**
     * Displays the player's statistics.
     */
    public void playerStats() {
        System.out.println("********** Player Stats **********");
        System.out.println("Health: " + this.getPlayer().getHealth() + "\n"
                        +"Weapon: " + this.getPlayer().getInventory().getWeapon().getName() + "\n"
                        + "Damage: " + this.getPlayer().getTotalDamage() + "\n"
                        + "Armor: " + this.getPlayer().getInventory().getArmor().getName() + "\n"
                        + "Block: " + this.getPlayer().getInventory().getArmor().getBlock() + "\n"
                        + "Money: " + this.getPlayer().getMoney() + "\n");
    }

    /**
     * Displays the obstacle's statistics.
     *
     * @param i the index of the obstacle in the battle
     */
    public void obstacleStats(int i) {
        System.out.println("********** " + (i + 1) + "." + this.getObstacle().getName() + "'s Stats **********");
        System.out.println("Health: " + this.getObstacle().getHealth() + "\n"
                + "Damage: " + this.getObstacle().getDamage() + "\n"
                + "Money: " + this.getObstacle().getMoney() + "\n");
    }

    /**
     * Displays the health after each hit in the battle.
     */
    public void afterHit() {
        System.out.println("!!! Your health: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + "'s health: " + this.getObstacle().getHealth() + "\n");
    }

    /**
     * Retrieves the obstacle present in the battle location.
     *
     * @return the obstacle present in the battle location
     */
    public Obstacle getObstacle() {
        return obstacle;
    }

    /**
     * Sets the obstacle present in the battle location.
     *
     * @param obstacle the obstacle to be set
     */
    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    /**
     * Retrieves the award received upon winning the battle.
     *
     * @return the award received upon winning the battle
     */
    public String getAward() {
        return award;
    }

    /**
     * Sets the award received upon winning the battle.
     *
     * @param award the award to be set
     */
    public void setAward(String award) {
        this.award = award;
    }

    /**
     * Retrieves the maximum number of obstacles in the battle.
     *
     * @return the maximum number of obstacles in the battle
     */
    public int getMaxObstacle() {
        return maxObstacle;
    }

    /**
     * Sets the maximum number of obstacles in the battle.
     *
     * @param maxObstacle the maximum number of obstacles to be set
     */
    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
    private String promptPlayerInput(String message) {
        System.out.print(message);
        return sc.next().toUpperCase();
    }

}
