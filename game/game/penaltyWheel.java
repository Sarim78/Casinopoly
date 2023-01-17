package game;

// Importing Libraries 
import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;

/**
 * Chances Wheel
 * @athuor Sarim Siddiqui
 */

public class penaltyWheel {
    // Creating Objects  

    Random rnd = new Random();

    Scanner in = new Scanner(System.in);

    wheelMethods wheelMethods = new wheelMethods();

    // Creating Variables

    String playerInput;

    // Creating Methods
    
    public void instructions() {
        // this method is for the instructions
        System.out.println("\nYou will have one chance to spin the wheel.");
        System.out.println("There are 6 random slots in this Chances Wheel!");
        System.out.println("This wheel only got bad items...");
        System.out.println("I hope you don't get something too bad...");
        System.out.println("\nGOODLUCK!");
    }

    public void welcomeUser() {
        // this method is for welcoming the users
        System.out.println("\nWelcome to the Wheel Of Penalty!");
    }

    public void wheelOfPenalty() {
        // Calling other methods
        welcomeUser();
        instructions();

       // this will allow the player to input to spin the wheel
       System.out.println("\nClick (G) To Spin The Wheel!");
       playerInput = in.nextLine();

       while(true) {
            // this if statement will check the user input
            if(playerInput.equals("G") || playerInput.equals("g")) {
                System.out.println("Spinning the penalty wheel...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Creating a object for the random library 
                int randomSlot = rnd.nextInt(1, 5);

                // creating IF-Statment for the object (RandomSlot), when the player clicks G to spin, this If Statment will run
                if(randomSlot == 1) {
                    // goToJail method
                    wheelMethods.goToJail();
                    break;

                } else if (randomSlot == 2) {
                    // playerChoosesToMoveYou method

                    wheelMethods.playerChoosesToMoveYou();
                    break;

                } else if (randomSlot == 3) {
                    // playerLosesMoney method
                    wheelMethods.loseMoney();
                    break;

                } else if (randomSlot == 4) {
                    // payingOtherPlayer method
                    wheelMethods.moneyTaken();
                    break;
                    
                } else if (randomSlot == 5) {
                    // movingPrevelges method
                    wheelMethods.movingPrevelges();    
                    break;
                }               
                else {
                    // If player decides to click any button expect for (G), the loop will print the else statement 
                    System.out.println("\nERROR");
                    System.out.println("Please Spin Again");

                    // This method will be called when player bymistake click another letter!
                    wheelOfPenalty();
                    break;
                }
            }
        }
    }
}