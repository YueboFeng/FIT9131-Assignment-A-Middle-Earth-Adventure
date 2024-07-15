/**
 * This class mainly controls the game.
 *
 * @author Yuebo Feng
 * @version ver 5.1.1
 */
public class Adventure
{
    private Creature adventurer; // Character played by player.
    private Creature opponent; // Non-Player Characters (NPCs).
    private String destination; // Stores input destination name from player.
    private int stage; // Counts stages in the game.
    private RandomNumberGenerator random; // To generate numbers with RandomNumberGenerator.
    private OpponentGenerator opponentGenerated; // To generate an opponent with OpponentGenerator.

    /**
     * Default constructor which creates the object of the class Adventure.
     *
     */
    public Adventure()
    {
        random = new RandomNumberGenerator();
        adventurer = new Creature("hobbit", random.generateInt(), 0);
        opponentGenerated = new OpponentGenerator();
        opponent = opponentGenerated.generateOpponent();
        destination = requestDestination();
        stage = 1;
    }

    /**
     * Non-Default constructor which creates the object of the class Adventure.
     *
     * @param adventurer         Accepts the adventurer as a Creature.
     * @param opponent           Accepts the opponent as a Creature.
     * @param destination        Accepts the destination as a String.
     * @param stage              Accepts the stage as an integer.
     * @param random             Accepts the random number as an integer.
     * @param opponentGenerated  Accepts the random opponent as an OpponentGenerator.
     */
    public Adventure(Creature adventurer, Creature opponent,
        String destination, int stage, RandomNumberGenerator random,
        OpponentGenerator opponentGenerated)
    {
        this.adventurer = adventurer;
        this.opponent = opponent;
        this.destination = destination;
        this.stage = stage;
        this.random = random;
        this.opponentGenerated = opponentGenerated;
    }

    /**
     * Displays the initialization of player's information.
     *
     * @param adventure       The adventure object for this class as an Adventure.
     */
    public void displayGameInitializing(Adventure adventure)
    {
        System.out.println("\nYour destination is " + destination
            + "! Wonderful place to go!\n" + adventure.toString()
            + "\nNow we shall begin!\n");
    }

    /**
     * Displays the outcome of each stage.
     *
     * @param adventure       The adventure object for this class as an Adventure.
     */
    public void displayOutcome(Adventure adventure)
    {
        System.out.println("Stage Summary\nUntil the end of stage "
            + stage + ":\n" + adventure.toString()
            + "\nPress Enter to continue.");
        Input input = new Input();
        input.letUserPressEnter();
    }

    /**
     * Displays the result of quest.
     *
     * @param successRate     The success rate og players as a double.
     */
    public void displayResult(double successRate)
    {
        System.out.println("==================================="
            + "===========================\n\nQuest Summary"
            + "\nDuring the quest to "
            + destination + ":\nThe " + adventurer.getIdentity()
            + " has got "
            + adventurer.treasure + " pots of gold, and remains "
            + adventurer.healthStatus + " health points.\nThe "
            + opponent.getIdentity() + " has got " + opponent.treasure
            + " pots of gold, and remains " + opponent.healthStatus
            + " health points." + "\nYour Success Rate(%): "
            + successRate + "\nThis is the end of the game.\n");
    }

    /**
     * Displays welcome messages to players.
     *
     */
    public static void displayWelcomeMessage()
    {
        System.out.println("Welcome to Middle-Earth Adventure!\n");
    }

    /**
     * Controls player's fight of each stage.
     *
     * @param adventure       The adventure object for this class as an Adventure.
     * @return                The success rate of players as a double.
     */
    public double fightForTreasure(Adventure adventure)
    {
        int timeOfWin = 0;
        for (stage = 1; stage <= 12; stage++)
        {
            System.out.println("===================================="
                + "==========================\n\nStage " + stage);
            if (opponent.healthStatus > 0)
            {
                if (stage > 1)
                {
                    updateHealthStatus(adventurer, 1);
                    updateHealthStatus(opponent, 1);
                    System.out.println("\nBoth sides get 1 health point"
                        + "at the beginning of the stage.\n");
                }
                if (adventurer.healthStatus > 2)
                {
                    double chanceToWin = random.generateDouble();
                    double posibilityToWin;
                    if (adventurer.getHealthStatus() > opponent.getHealthStatus())
                    {
                        posibilityToWin = 0.7;
                    }
                    else if (adventurer.getHealthStatus() == opponent.getHealthStatus())
                    {
                        posibilityToWin = 0.5;
                    }
                    else
                    {
                        posibilityToWin = 0.3;
                    }
                    if (chanceToWin > posibilityToWin)
                    {
                        updateTreasure(adventurer, 1);
                        updateHealthStatus(opponent, -2);
                        System.out.println("The fight is on.\nThe "
                            + adventurer.getIdentity() + " wins and get 1 pot of gold.\nThe "
                            + opponent.getIdentity() + " loses 2 health points.\n");
                        timeOfWin++;
                    }
                    else
                    {
                        updateTreasure(opponent, 1);
                        updateHealthStatus(adventurer, -2);
                        System.out.println("The fight is on.\nThe " + opponent.getIdentity() 
                            + " wins and get 1 pot of gold.\nThe " + adventurer.getIdentity() 
                            + " loses 2 health points.\n");
                    }
                }
                else
                {
                    updateTreasure(opponent, 1);
                    System.out.println("The fight is on.\nThe " + opponent.getIdentity() 
                        + " wins and get on pot of gold.\n");
                }
                if (adventurer.healthStatus <= 0)
                {
                    System.out.println("The adventurer has lost all health points. Game over.");
                    break;
                }
            }
            else
            {
                updateHealthStatus(adventurer, 1);
                updateTreasure(adventurer, 1 + 1);
                System.out.println("The fight is on.\nThe "
                    + adventurer.getIdentity() + " wins and get 1 pot of gold.\n");
                timeOfWin++;
            }
            displayOutcome(adventure);
        }
        double successRate = timeOfWin / 12.0 * 100;
        return successRate;
    }

    /**
     * Method to being the program
     *
     * @param args            An array of Strings representing command line arguments.
     */
    public static void main(String[] args)
    {
        displayWelcomeMessage();
        Adventure adventure = new Adventure();
        adventure.displayGameInitializing(adventure);
        adventure.displayResult(adventure.fightForTreasure(adventure));
    }

    /**
     * Gets the input of destination from players
     *
     * @return                The valid destination as a String.
     */
    public String requestDestination()
    {
        Input input = new Input();
        Validation validation = new Validation();
        String inputDestination = input.acceptDestinationName();
        while (true)
        {
            boolean bool = validation.isValid(inputDestination);
            if (bool)
                break;
            inputDestination = input.acceptDestinationName();
        }
        return inputDestination;
    }

    /**
     * Returns a String about creatures' information.
     *
     * @return                 The creatures' information as a String.
     */
    public String toString()
    {
        String result = "";
        result += "Adventurer: " + adventurer.toString() + "\n";
        result += "Opponent: " + opponent.toString();
        return result;
    }

    /**
     * Updates the creatures' health points.
     *
     * @param creature         The creature as a Creature.
     * @param healthStatusUpdated The updated health point as an integer.
     */
    public void updateHealthStatus(Creature creature, int healthStatusUpdated)
    {
        creature.setHealthStatus(creature.getHealthStatus() + healthStatusUpdated);
    }

    /**
     * Updates the creatures' treature.
     *
     * @param creature          The creature as a Creature.
     * @param treatureUpdated   The updated treature as an integer.
     */
    public void updateTreasure(Creature creature, int treatureUpdated)
    {
        creature.setTreasure(creature.getTreasure() + treatureUpdated);
    }
}
