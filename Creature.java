/**
 * This class controls game characters.
 * @author Yuebo Feng
 * @version ver 2.0.0
 */
public class Creature
{
    private String identity; // Stores identity of each creature.
    public int healthStatus; // Stores number of health points for each creature.
    public int treasure; // Stores number of pots of gold for each creature. 

    /**
     * Default constructor which creates the object of the class Creature.
     *
     */
    public Creature()
    {
        identity = "";
        healthStatus = 0;
        treasure = 0;
    }

    /**
     * Non-Default constructor which creates the object of the class Creature.
     *
     * @param identity      Accepts the identity of creatures as a String.
     * @param healthStatus  Accepts the health points of creatures as an integer.
     * @param treasure      Accepts the treature of creatures as an integer.
     */
    public Creature(String identity, int healthStatus, int treasure)
    {
        if (identity.equals("hobbit") || identity.equals("dwarf")
            || identity.equals("elf") || identity.equals("orc"))
        {
            this.identity = identity;
        }
        else
        {
            this.identity = "";
        }
        if (healthStatus >= 0)
        {
            this.healthStatus = healthStatus;
        }
        else
        {
            this.healthStatus = 0;
        }
        if (treasure >= 0)
        {
            this.treasure = treasure;
        }
        else
        {
            this.treasure = 0;
        }
    }

    /**
     * Accessor method to get the health point.
     *
     * @return              The health point as an integer.
     */
    public int getHealthStatus()
    {
        return healthStatus;
    }

    /**
     * Accessor method to get the identity.
     *
     * @return              The identity as a String.
     */
    public String getIdentity()
    {
        return identity;
    }

    /**
     * Accessor method to get the treature.
     *
     * @return              The treature as an integer.
     */
    public int getTreasure()
    {
        return treasure;
    }

    /**
     * Mutator method to set the health point.
     *
     * @param newHealthStatus  The health point as an integer.
     */
    public void setHealthStatus(int newHealthStatus)
    {
        if (newHealthStatus >= 0)
        {
            healthStatus = newHealthStatus;
        }
    }

    /**
     * Mutator method to set the health point.
     *
     * @param newIdentity   The new identity as a String.
     */
    public void setIdentity(String newIdentity)
    {
        if (identity.equals("hobbit") || identity.equals("dwarf")
            || identity.equals("elf") || identity.equals("orc"))
        {
            this.identity = identity;
        }
    }

    /**
     * Mutator method to set the treature.
     *
     * @param newTreature   The new treature as an integer.
     */
    public void setTreasure(int newTreasure)
    {
        if (newTreasure >= 0)
        {
            treasure = newTreasure;
        }
    }

    /**
     * Returns a String about creatures' information.
     *
     * @return              The creatures' information as a String.
     */
    public String toString()
    {
        String result = "";
        result += identity + "; ";
        if (healthStatus > 1)
            result += "Health points: " + healthStatus + "; ";
        else
            result += "Health point: " + healthStatus + "; ";
        if (treasure > 1)
            result += "Pots of gold: " + treasure + ".";
        else
            result += "Pot of gold: " + treasure + ".";
        return result;
    }
}
