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
    static int numberLimit = 25000;

    static int num;

    static String Hi;
    static String Lo; 


    // Creating methods for the card game
    public static void numberGenerator() {
        // This methid will tell the player, if you need to guess Hi or Lo
        int num = rnd.nextInt(numberLimit);
        System.out.println("The Number, You Have To Guess Hi Or Lo Is: " + num);
    }

    public static void HiLo() {
        // Player guess if the number is Hi or Lo
        System.out.println("Please Enter Your Guess (Hi/Lo): ");
        int userInput = in.nextInt();

        if(userInput < num) {
            System.out.println("Test 1"); 
        } else if (userInput > num) {
            System.out.println("Test 2"); 
        } else {
            System.out.println("Test 3"); 
        }
    }
}