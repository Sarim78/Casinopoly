package Src;
import java.util.Scanner;
import java.util.Random;

/**
 * Card Game (Hi-Lo)
 * @athuor Sarim Siddiqui
 */

public class cardGame {

    // Creating Objects 
    static Random rnd = new Random(); 
    static Scanner in = new Scanner(System.in);

    // Creating Variables
    static int numberLimit = 50; // this is for a limit that the numberGenerator() method can use

    static int num1; // this Variable is for the method called numberGenerator()

    static int ai; // this Variable is for the method called Ai()

    static int bet; // this Variable is for the method called bet()

    // Creating methods for the card game
    public static void numberGenerator() {
        // This methid will tell the player, if you need to guess Hi or Lo
        int num = rnd.nextInt(numberLimit);
        num1 = num;
    }

    public static void bet() {
        // this methid will let the player bet on them self. If they lose the game, they will lose all the money earned and even the bet.
        System.out.print("\nPlease Place Your Bet (Between 1000 - 20000): ");

        int playerBet = in.nextInt();

        bet = playerBet;

        betOverUnderLimit();
    }

    public static void betOverUnderLimit() {
        // this method if for when the player bet over $20k or under $1k.
        if(bet > 20000) {
            System.out.println("Sorry, you went over the betting limit. Max: $20k");
            bet();
            confrimBet();
        } else if(bet < 1000) {
            System.out.println("Sorry, you went under the betting limit. Min: $1k");
            bet();
            confrimBet();
        }
    }

    public static void confrimBet() {
        // this method will confrim the player bet

        Scanner newScanner = new Scanner(System.in);

        System.out.println("You have placed a bet of $" + bet);
        System.out.println("Please confrim if you want to place this bet (Y/N): ");

        String confrimBet = newScanner.nextLine();

        if(confrimBet.equals("Y") || confrimBet.equals("y")) {
            System.out.println("\nAlright, your bet of $" + bet + " has been confrimed!");
        } else if(confrimBet.equals("N") || confrimBet.equals("n")) {
            System.out.println("\nPlease Re-Enter Your Bet.");
            bet();
        }
    }

    public static void instructions() { 
        // This methid will tell the players the instructions of this mini game
        System.out.println("\nIf you would like to check out the instructions of this mini game, press (g). Otherwise, press anything.");

        String playerInput = in.nextLine();

        if(playerInput.equals("G") || playerInput.equals("g")) {
            // If the player presses G/g then this IF STATEMENT will run.
            System.out.println("\nInstructions: ");
            System.out.println("You will be assigned an number.");
            System.out.println("The A.i will decided if he should think of an number higher or lower of the assigned number.");
            System.out.println("Then you have to decide if the number is (Hi/Lo).");
            System.out.println("If you get the answer wrong, you will lose all the money you gained from this mini game and the game will end...");
            System.out.println("Otherwise, you will keep going on until you lose. You will earn $2k every round you WIN!");
        }
    }

    public static void Ai() {
        // this method will let the ai think of a number greater than or less then numberGenerator() method
        System.out.println("\nAi: Am i thinking of an number higher or Lower of: " + num1 + "?");

        int aiNum = rnd.nextInt(numberLimit);
        ai = aiNum;
    }

    public static void HiLo() {

        Scanner newUserInput = new Scanner(System.in);
        
        // Player guess if the number is Hi or Lo
        System.out.println("\nPlease Enter Your Guess (Hi/Lo): ");

        String userInput = newUserInput.nextLine();
        
        if(userInput.equals("Hi") || userInput.equals("hi")) {

            if(ai > num1) {
                System.out.println("\nCongrats, You Got It Right!");
            } else if(ai < num1) {
                System.out.println("\nSorry, you lost :(");
            }

        } else if (userInput.equals("Lo") || userInput.equals("lo")) {

            if(ai < num1) {
                System.out.println("\nCongrats, You Got It Right!");
            } else if(ai > num1) {
                System.out.println("\nSorry, you lost :(");
            }

        } else {
            System.out.println("You only can pick between (Hi/Lo)"); 
            HiLo();
        }
    }

    public static void allMethods() {
            // Calling all methods into one method
            instructions(); // have to remove this soon
            bet(); // have to remove this soon
            confrimBet(); // have to remove this soon
            numberGenerator(); // have to remove this soon
            Ai(); // have to remove this soon
            HiLo(); // have to remove this soon
    }
}   