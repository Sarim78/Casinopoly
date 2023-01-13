package game;

// Importing Libraries 
import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;

/**
 * Chances Wheel
 * @athuor Sarim Siddiqui
 */

public class chanceWheel {
    
    // Creating Objects  

    Random rnd = new Random();

    Scanner in = new Scanner(System.in);
    
    wheelMethods wheelMethods = new wheelMethods();

    // Creating Variables

    double birthdayMoney;

    double payOpponent;

    double userGettingFined;

    int randomSlot; // Creating a object for the random library 

    String playerInput;

    // Creating Methods
    
    public void instructions() {
        System.out.println("\nYou will have one chance to spin the wheel.");
        System.out.println("There are 12 random slots in this Chances Wheel!");
        System.out.println("You might win something or lose something...");
        System.out.println("\nGOODLUCK!");
    }

    public void welcomeUser() {
        // This method will welcome the user
        System.out.println("\nWelcome To Our Wheel Of Chances!");
        instructions();
    }

    public void chancesOfWheel() {
        // This methid will be called to greet the user
        welcomeUser();

        // this will allow the player to input to spin the wheel
        System.out.println("\nClick (G) To Spin The Wheel or to exit, press anything: ");
        playerInput = in.nextLine();

        while(true) {
            // this if statement will check the user input
            if(playerInput.equals("G") || playerInput.equals("g")) {
                System.out.println("Spinning the chance wheel.....");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                randomSlot = rnd.nextInt(1, 12);
                // creating IF-Statment for the object (RandomSlot), when the player clicks G to spin, this If Statment will run
                if(randomSlot == 1) {
                    // This will call moveThreeSpaces() method
                    wheelMethods.moveThreeSpaces();
                    break;

                } else if (randomSlot == 2) {
                    // This will call moveBackThreeSpaces() method
                    wheelMethods.moveBackThreeSpaces();
                    break;

                } else if (randomSlot == 3) {
                    // This will call jailFreeCard() method
                    wheelMethods.jailFreeCard();
                    break;

                } else if (randomSlot == 4) {
                    // This will call raffelCard() method
                    wheelMethods.raffelCard();
                    break;
                    
                } else if (randomSlot == 5) {
                    // This will call yourBirthday() method
                    birthdayMoney = rnd.nextDouble(1000,10000);
                    wheelMethods.yourBirthday();
                    break;
                    
                } else if (randomSlot == 6) {
                    // This will call advanceToFreeSpot() method
                    wheelMethods.advanceToFreeSpot();
                    break;
                    
                } else if (randomSlot == 7) {
                    // This will call freeSpinForGainCasinoWheel() method
                    wheelMethods.freeSpinForGaintCasinoWheel();
                    break;
                    
                } else if (randomSlot == 8) {
                    // This will call buyingAnyObjects() method
                    wheelMethods.buyingAnyObjects();
                    break;
                    
                } else if (randomSlot == 9) {
                    // This will call goToJail() method
                    wheelMethods.goToJail();
                    break;
                    
                } else if (randomSlot == 10) {
                    // This will call youLost() method
                    payOpponent = rnd.nextDouble(1000,10000);
                    wheelMethods.youLost();
                    break;
                    
                } else if (randomSlot == 11) {
                    // This will call youHaveBeenFined() method
                    userGettingFined = rnd.nextDouble(500, 5000);
                    wheelMethods.youHaveBeenFined();
                    break;
                    
                } else if (randomSlot == 12) {
                    // This will call casinopolyPenaltySpace() method
                    wheelMethods.casinopolyPenaltySpace();
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