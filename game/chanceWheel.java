package game;

// Importing Libraries 
import java.util.Random;
import java.util.Scanner;

/**
 * Chances Wheel
 * @athuor Sarim Siddiqui
 */

public class chanceWheel {
    // Creating Objects  
    static Random rnd = new Random();
    static Scanner in = new Scanner(System.in);

    // Main Chances Wheel Methods 
    public static void instructions() {
        System.out.println("\nYou will have one chance to spin the wheel.");
        System.out.println("There are 12 random slots in this Chances Wheel!");
        System.out.println("You might win something or lose something...");
        System.out.println("\nGOODLUCK!");
    }

    public static void welcomeUser() {
        // This method will welcome the user
        System.out.println("\nWelcome To Our Wheel Of Chances!");
        instructions();
    }

    public static void chancesOfWheel() {
        // This methid will be called to greet the user
        welcomeUser();

        // this will allow the player to input to spin the wheel
        System.out.println("\nClick (G) To Spin The Wheel or to exit, press anything: ");
        String playerInput = in.nextLine();

        while(true) {
            // this if statement will check the user input
            if(playerInput.equals("G") || playerInput.equals("g")) {
                // Creating a object for the random library 
                int randomSlot = rnd.nextInt(1, 12);

                // creating IF-Statment for the object (RandomSlot), when the player clicks G to spin, this If Statment will run
                if(randomSlot == 1) {
                    // This will call moveThreeSpaces() method
                    chanceWheelSlots.moveThreeSpaces();
                    break;

                } else if (randomSlot == 2) {
                    // This will call moveBackThreeSpaces() method
                    chanceWheelSlots.moveBackThreeSpaces();
                    break;

                } else if (randomSlot == 3) {
                    // This will call jailFreeCard() method
                    chanceWheelSlots.jailFreeCard();
                    break;

                } else if (randomSlot == 4) {
                    // This will call raffelCard() method
                    chanceWheelSlots.raffelCard();
                    break;
                    
                } else if (randomSlot == 5) {
                    // This will call yourBirthday() method
                    chanceWheelSlots.yourBirthday();
                    break;
                    
                } else if (randomSlot == 6) {
                    // This will call advanceToFreeSpot() method
                    chanceWheelSlots.advanceToFreeSpot();
                    break;
                    
                } else if (randomSlot == 7) {
                    // This will call freeSpinForGainCasinoWheel() method
                    chanceWheelSlots.freeSpinForGaintCasinoWheel();
                    break;
                    
                } else if (randomSlot == 8) {
                    // This will call buyingAnyObjects() method
                    chanceWheelSlots.buyingAnyObjects();
                    break;
                    
                } else if (randomSlot == 9) {
                    // This will call goToJail() method
                    chanceWheelSlots.goToJail();
                    break;
                    
                } else if (randomSlot == 10) {
                    // This will call youLost() method
                    chanceWheelSlots.youLost();
                    break;
                    
                } else if (randomSlot == 11) {
                    // This will call youHaveBeenFined() method
                    chanceWheelSlots.youHaveBeenFined();
                    break;
                    
                } else if (randomSlot == 12) {
                    // This will call casinopolyPenaltySpace() method
                    chanceWheelSlots.casinopolyPenaltySpace();
                    break;
                }
            } else {
                // If player decides to click any button expect for (G), the loop will print the else statement 
                System.out.println("\nYou have exited out of Chances Of Wheel...");
                System.out.println("\nSad To See You GO :(");

                // this loop will break, if the player decides to leave the Chances Wheel
                break;
            }
        }
    }
}