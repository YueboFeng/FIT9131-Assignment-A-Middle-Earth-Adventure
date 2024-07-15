import java.util.Random;

/**
 * This class generates necessary random numbers.
 * @author Yuebo Feng
 * @version ver 2.0.0
 */
public class RandomNumberGenerator
{
    /**
     * Generates a random double.
     *
     */
    public double generateDouble()
    {
       Random random1 = new Random();
       return random1.nextDouble();
    }

    /**
     * Generates a random integer.
     *
     */
    public int generateInt()
    {
        Random random2 = new Random();
        return random2.nextInt(8 - 5) + 5;
    }

}
