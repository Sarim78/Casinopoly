package game;
// Importing Libraries 
import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;
import src.player;
import src.player2;

/**
 * Jail
 * @athuor Sarim Siddiqui
 */

public class jail {
    // Objects 
    Random rnd = new Random(); 

    player player = new player();

    player2 player2 = new player2();

    // Creating Variables
    int bail = 5000; // this is for bail payment

    // Methods
    public void grettingUserToJail() {
        // This method will greet the user to jail
        System.out.println("\nYou have been entered to jail.");
        System.out.println("You can't earn or receive money");
        System.out.println("In order to get out of jail, you need to pay a bail of $5K...");

        System.out.println("\nIf you don't have enough money to pay bail, then your only option is to roll your way out of jail for free.");
        System.out.println("You only can land on even number to get out of jail, if you land on odd number, you have to wait until next player role his dice.");
        
        System.out.println("\nYou can only do this if you can't pay bail, otherwise bail is required");

        System.out.println("\nGoodLuck!");

        player1Data();
    }

    // This 3 methods are for player 1
    public void player1MovingSpacesAndLosingMoney() {
        // If player 1, decides to pay his bail, this method will be printed

        // this statement will take out the money from his account balance
        player.gameEarnings = player.gameEarnings - bail;

        // this statement will let player 1 move spaces
        player.totalSpace = player.totalSpace + player.space + 1;
    }

    public void player1Data() {
        // This method will check if player 1 have more then 5k to pay for bail

        if(player.gameEarnings >= 5000) {
            // If player 1 have more then 5k, this statement will be executed
            askingUserToPayTheBail();
            player1MovingSpacesAndLosingMoney();
        } else {
            // If player 1 have less then 5k, this statement will be executed
            diceRoller();
        }
    }

    public void player1LandedOnJail() {
        // this If Statement will check if player 1 is at space 8
        if(player.totalSpace == 8) {
            player1Data();
        }
    }

    // This 2 methods are for player 2
    public void player2MovingSpaces() {
        // If player 2, decides to pay his bail, this method will be printed

    }

    public void player2Money() {
        // This method will check if player 2 have more then 5k to pay for bail

    }

    public void diceRoller() {
        // If player doesn't have enough money to pay his bail, this method will be executed

        int dice = rnd.nextInt(1,10);

        // this if statement will check, if the number is even or odd
        if(dice == 2 || dice == 4 || dice == 6 || dice == 8 || dice == 10) {
            // if dice lands on even number, this statement will be executed
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\nCONGRATS! your out of jail!");
            System.out.println("\nYou have landed on: " + dice);
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // if dice lands on odd number, this statement will be executed
            System.out.println("\nSorry, you have landed on an ODD number...");
            System.out.println("\nYou have landed on: " + dice);
        }
    }

    public void askingUserToPayTheBail() {
        // This method will ask user to pay for bail

        try {
            // this thread, will let this code to executed 1 sec after.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Scanner bail = new Scanner(System.in);

            // asking user to pay their bail
            System.out.println("\nWould you like to your bail for $5000?");
            System.out.println("Please enter your input (Y/N): ");
    
            String userInputBail = bail.nextLine();

            // this if statement will check player input
            if(userInputBail.equals("Y") || userInputBail.equals("y")) {
                // If players pay his bail, this statement will be executed
                System.out.println("\nCONGRATS! Your out of jail!");

                System.out.println("\nThanks for paying your bail!");
                System.out.println("You have been moved 1 space forward!");

                bail.close();
            } else if(userInputBail.equals("N") || userInputBail.equals("n")) {
                // If players doesn't pay his bail, this statement will be executed
                System.out.println("\nSIKE, you still have to pay your bail!"); 

                System.out.println("\nCONGRATS! Your out of jail!");

                System.out.println("\nThanks for paying your bail!");
                System.out.println("You have been moved 1 space forward!");

                bail.close();
            }
        } catch (Exception e) {
            System.out.println("\nInvaild Input, please try again");
            askingUserToPayTheBail();
        }
    }
}