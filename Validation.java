import java.util.Scanner;

/**
 * This class judges the validation of input.
 * @author Yuebo Feng
 * @version ver 6.0.1
 */
public class Validation
{
    /**
     * Judges the validation of player's input destination name.
     *
     * @param playerDestinationName The player's input destination name as a String.
     * @return                      The judgement of validation of input as a boolean.
     */
    public boolean isValid(String playerDestinationName)
    {
        while (true)
        {
            for (int i = 0; i < playerDestinationName.length(); i++)
            {
                char c = playerDestinationName.charAt(i);
                if (!Character.isAlphabetic(c) && !Character.isWhitespace(c))
                {
                    System.out.print("\nError. Your destination name "
                    + "must only contain alphabets and spaces"
                    + "(cannot begin or end with).\n\n");
                    return false;
                }
            }
            if (playerDestinationName.length() < 4 || playerDestinationName.length() > 16)
            {
                System.out.print("\nError. Your destination name "
                    + "must be 4 to 16 characters in length.\n\n");
                return false;
            }
            else if (playerDestinationName.startsWith(" ") || playerDestinationName.endsWith(" "))
            {
                System.out.print("\nError. Your destination name "
                    + "must not begin or end with spaces.\n\n");
                return false;
            }
            else
                break;
        }
        return true;
    }
}
