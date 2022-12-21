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
    static int numberLimit = 15000;

    static int num;

    static int ai;

    static String Hi;
    static String Lo; 


    // Creating methods for the card game
    public static void numberGenerator() {
        // This methid will tell the player, if you need to guess Hi or Lo
        int num = rnd.nextInt(numberLimit);
        System.out.println("\nThe Number Is: " + num);
    }

    public static void Ai() {
        // this method will let the ai think of a number greater than or less then numberGenerator() method
        System.out.println("\nAi: Am i thinking of an number higher or Lower?");

        int aiNum = rnd.nextInt(numberLimit);
        ai = aiNum;

        if(aiNum > num) {
            System.out.println("ai test 1");
        } else if(aiNum < num) {
            System.out.println("ai test 2");
        } else { 
            System.out.println("ai test 3");
        }
    }

    public static void HiLo() {

        numberGenerator();
        Ai();

        // Player guess if the number is Hi or Lo
        System.out.println("Please Enter Your Guess (Hi/Lo): ");
        String userInput = in.nextLine();

        if(userInput.equals("Hi") || userInput.equals("hi")) {
            System.out.println("Test 1");
        } else if (userInput.equals("Lo") || userInput.equals("lo")) {
            System.out.println("Test 2"); 
        } else {
            System.out.println("Test 3"); 
        }
    }
}