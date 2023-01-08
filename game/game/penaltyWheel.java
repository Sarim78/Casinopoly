package game;

// Importing Libraries 
import java.util.Random;
import java.util.Scanner;

/**
 * Chances Wheel
 * @athuor Sarim Siddiqui
 */

public class penaltyWheel {
    // Creating Objects  
    static Random rnd = new Random();
    static Scanner in = new Scanner(System.in);

    // Methods
    public static void instructions() {
        // this method is for the instructions
        System.out.println("\nYou will have one chance to spin the wheel.");
        System.out.println("There are 6 random slots in this Chances Wheel!");
        System.out.println("This wheel only got bad items...");
        System.out.println("I hope you don't get something too bad...");
        System.out.println("\nGOODLUCK!");
    }

    public static void welcomeUser() {
        // this method is for welcoming the users
        System.out.println("\nWelcome to the Wheel Of Penalty!");
    }

    public static void wheelOfPenalty() {
        // Calling other methods
        welcomeUser();
        instructions();

       // this will allow the player to input to spin the wheel
       System.out.println("\nClick (G) To Spin The Wheel or to exit, press anything: ");
       String playerInput = in.nextLine();

       while(true) {
            // this if statement will check the user input
            if(playerInput.equals("G") || playerInput.equals("g")) {
                // Creating a object for the random library 
                int randomSlot = rnd.nextInt(1, 5);

                // creating IF-Statment for the object (RandomSlot), when the player clicks G to spin, this If Statment will run
                if(randomSlot == 1) {
                    // goToJail method
                    penaltyWheelSlots.goToJail();
                    break;

                } else if (randomSlot == 2) {
                    // playerChoosesToMoveYou method
                    penaltyWheelSlots.playerChoosesToMoveYou();
                    break;

                } else if (randomSlot == 3) {
                    // playerLosesMoney method
                    penaltyWheelSlots.playerLosesMoney();
                    break;

                } else if (randomSlot == 4) {
                    // gettingFined method
                    penaltyWheelSlots.gettingFined();
                    break;
                    
                } else if (randomSlot == 5) {
                    // movingPrevelges method
                    penaltyWheelSlots.movingPrevelges();    
                    break;
                }               
                else {
                    // If player decides to click any button expect for (G), the loop will print the else statement 
                    System.out.println("\nYou have exited out of Chances Of Wheel...");
                    System.out.println("\nSad To See You GO :(");

                    // this loop will break, if the player decides to leave the Chances Wheel
                    break;
                }
            }
        }
    }
}