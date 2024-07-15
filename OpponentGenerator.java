import java.util.Random;

/**
 * This class generates random opponents.
 * @author Yuebo Feng
 * @version ver 2.0.0
 */
public class OpponentGenerator
{
    /**
     * Generates a random opponent.
     *
     */
    public Creature generateOpponent()
    {
        String[] opponents = {"dwarf", "elf", "orc"};
        int[] healthStatusOfOpponents = {9, 7, 5};
        Random number = new Random();
        int opponentNo = number.nextInt(3);
        if (opponentNo == 0)
        {
            return new Creature("dwarf", 9, 0);
        }
        else if (opponentNo == 1)
        {
            return new Creature("elf", 7, 0);
        }
        else
        {
            return new Creature("orc", 5, 0);
        }
    }
}
