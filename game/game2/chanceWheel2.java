package game2;

// Importing Libraries 
import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;

/**
 * Chances Wheel
 * @athuor Sarim Siddiqui
 */

public class chanceWheel2 {
    
    // Creating Objects  

    Random rnd = new Random();

    Scanner in = new Scanner(System.in);
    
    wheelMethods2 wheelMethods2 = new wheelMethods2();

    penaltyWheel2 penaltyWheel2 = new penaltyWheel2();

    giantWheel22 giantWheel2 = new giantWheel22();

    casinopolyShop22 casinopolyShop22 = new casinopolyShop22();

    // Creating Variables

    int randomSlot; // Creating a object for the random library 

    String playerInput; // this Variable is for player input for spinning the wheel

    // Creating Methods
    
    public void instructions() {
        System.out.println("\nYou will have one chance to spin the wheel.");
        System.out.println("There are 12 random slots in this Chances Wheel!");
        System.out.println("You might win something or lose something...");
        System.out.println("\nGOODLUCK!");
        chancesOfWheel();
    }

    public void welcomeUser() {
        // This method will welcome the user
        System.out.println("\nWelcome To Our Wheel Of Chances!");
        instructions();
    }

    public void chancesOfWheel() {

        // this will allow the player to input to spin the wheel
        System.out.println("\nClick (G) To Spin The Wheel or to exit, press anything: ");
        playerInput = in.nextLine();

        // this if statement will check the user input
        if(playerInput.equals("G") || playerInput.equals("g")) {
            System.out.println("Spinning the chance wheel.....");

            // this try and catch is for the timer for the spinner
            try {
                Thread.sleep(3000); // 3000 milisecounds = 3 secounds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            randomSlot = rnd.nextInt(1, 12);
            // creating IF-Statment for the object (RandomSlot), when the player clicks G to spin, this If Statment will run
            if(randomSlot == 1) {
                // This will call moveThreeSpaces() method
                wheelMethods2.moveThreeSpaces();

            } else if (randomSlot == 2) {
                // This will call moveBackThreeSpaces() method
                wheelMethods2.moveBackThreeSpaces();

            } else if (randomSlot == 3) {
                // This will call jailFreeCard() method
                wheelMethods2.jailFreeCard();

            } else if (randomSlot == 4) {
                // This will call raffelCard() method
                wheelMethods2.raffelCard();
                
            } else if (randomSlot == 5) {
                // This will call yourBirthday() method
                wheelMethods2.yourBirthday();
                
            } else if (randomSlot == 6) {
                // This will call advanceToFreeSpot() method
                wheelMethods2.advanceToFreeSpot();
                
            } else if (randomSlot == 7) {
                // This will call freeSpinForGainCasinoWheel() method
                System.out.println("Spin the giant Casinopoly wheel!");
                giantWheel2.giantwheel();
                
            } else if (randomSlot == 8) {
                // This will call buyingAnyObjects() method
                System.out.println("Head to the Casinopoly shop!");
                casinopolyShop22.casinopolyshop();
                
            } else if (randomSlot == 9) {
                // This will call goToJail() method
                wheelMethods2.goToJail();
                
            } else if (randomSlot == 10) {
                // This will call youLost() method
                wheelMethods2.youLost();
                
            } else if (randomSlot == 11) {
                // This will call youHaveBeenFined() method
                wheelMethods2.youHaveBeenFined();
                
            } else if (randomSlot == 12) {
                // This will call casinopolyPenaltySpace() method
                System.out.println("Spin the penalty wheel!");
                penaltyWheel2.wheelOfPenalty();
            }
        } else {
            // If player decides to click any button expect for (G), the loop will print the else statement 
            System.out.println("\nPlease click on G");
            chancesOfWheel();

            // this loop will break, if the player decides to leave the Chances Wheel
        }
    }

    public void chancewheel() {
        welcomeUser();
    }
}