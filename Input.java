import java.util.Scanner;

/**
 * This class accepts input from user.
 * @author Yuebo Feng
 * @version ver 3.0.0
 */
public class Input
{
    /**
     * Accepts input destination from players.
     *
     * @return playerDestinationName  The input destination name as a String.
     */
    public String acceptDestinationName()
    {
        System.out.print("====================================="
            + "===============================\n\nPlease enter your destination: ");
        Scanner letingUserInputDestinationName = new Scanner(System.in);
        String playerDestinationName = letingUserInputDestinationName.nextLine();
        return playerDestinationName;
    }

    /**
     * Accepts Enter pressing from players.
     *
     */
    public void letUserPressEnter()
    {
        Scanner letingUserPressEnter = new Scanner(System.in);
        letingUserPressEnter.nextLine();
    }
}
