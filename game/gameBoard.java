package game;

// Importing Libraries 
import java.util.Scanner;
import java.util.Random;

// Importing Files 
import src.player;
import src.player2;

/**
 * Game Board
 * @athuor Sarim Siddiqui
 * @athuor Adil Baig
 */

public class gameBoard {
    // Creating Objects 
    static Random rnd = new Random();
    static Scanner in = new Scanner(System.in);

    // Creating Variables
    public static int totalSpace; // For Player 1
    
    public static int totalSpace2; // For Player 2

    // Methods: 
    public static void dice() {
        // This method is for rolling a dice

        int diceRoller = rnd.nextInt(1, 6);
        System.out.println("\nYou have rolled a: " + diceRoller);

        // Player 1
        totalSpace = player.space + diceRoller;

        // Player 2
        totalSpace2 = player2.space + diceRoller;

        // Player 1
        if(totalSpace > 18) {
            totalSpace = totalSpace - 18;
            System.out.println(totalSpace);
        } else {
            System.out.println(totalSpace);
        }

        // Player 2
        if(totalSpace2 > 18) {
            totalSpace2 = totalSpace2 - 18;
            System.out.println(totalSpace2);
        } else {
            System.out.println(totalSpace2);
        }
    }

    public static void goBackToJail1() {
        // This method will push Player 1 back to jail
        player.space = totalSpace - 6;
    }

    public static void goBackToJail2() {
        // This method will push Player 2 back to jail
        player2.space = totalSpace2 - 6;  
    }

    public static void gameBoardSpace() {
          // this if statement calls the game
          if(totalSpace == 1) {
            System.out.println("\nYou are on space #" + totalSpace);
            System.out.println("This is the starting point of this game.");

          } else if(totalSpace == 2) {
              System.out.println("\nYou have just landed at " + totalSpace);
  
          } else if(totalSpace == 3) {
              // roulette
              System.out.println("\nYou have just landed at " + totalSpace);
              System.out.println("\nOn this space, you have to play roulette!");
              Roulette.roulette();
  
          } else if(totalSpace == 4) {
              System.out.println("\nYou have just landed at " + totalSpace);
              System.out.println("\nOn this space, you got to spin Chances Of Wheel!");
              chanceWheel.chancesOfWheel();
  
          } else if(totalSpace == 5) {
              // slot machine
              System.out.println("\nYou have just landed at " + totalSpace);
              System.out.println("\nOn this space, you have to play casino slots!");
              slots.slotMachine();
  
          } else if(totalSpace == 6) {
              // BlackJack
              System.out.println("\nYou have just landed at " + totalSpace);
              System.out.println("\nOn this space, you have to play BlackJack!");
              blackJack.blackJack();
  
          } else if(totalSpace == 7) {
              // cardgame
              System.out.println("\nYou have just landed at " + totalSpace);
              System.out.println("\nOn this space, you have to play CardGame (Hi-Lo)!");
              cardGame.cardgame();
  
          } else if(totalSpace == 8) {
              // Jail
              System.out.println("\nYou have just landed at " + totalSpace);
              System.out.println("\nYou have landed in a jail cell :(");
  
          } else if(totalSpace == 9) {
              // slot machine
              System.out.println("\nYou have just landed at " + totalSpace);
              System.out.println("\nOn this space, you have to play casino slots!");
              slots.slotMachine();
  
          } else if(totalSpace == 10) {
              System.out.println("\nYou have just landed at " + totalSpace);
              System.out.println("\nOn this space, you got to spin Chances Of Wheel!");
              chanceWheel.chancesOfWheel();
  
          } else if(totalSpace == 11) {
              System.out.println("\nYou have just landed at " + totalSpace);
              System.out.println("This is a free space, you have earned nothing...");
  
          } else if(totalSpace == 12) {
              // roulette
              System.out.println("\nYou have just landed at " + totalSpace);
              System.out.println("\nOn this space, you have to play roulette!");
              Roulette.roulette();
  
          } else if(totalSpace == 13) {
              // BlackJack
              System.out.println("\nYou have just landed at " + totalSpace);
              System.out.println("\nOn this space, you have to play BlackJack!");
              blackJack.blackJack();
  
          } else if(totalSpace == 14) {
              // Jail
              System.out.println("\nYou have just landed at " + totalSpace);
              System.out.println("GO BACK TO JAIL");

              // this will push the player back to jail 
              System.out.println("\nYou have been placed back to jail!");
  
          } else if(totalSpace == 15) {
              System.out.println("\nYou have just landed at " + totalSpace);
  
          } else if(totalSpace == 16) {
              System.out.println("\nYou have just landed at " + totalSpace);
              System.out.println("This is a free space, you have earned nothing...");

          } else if(totalSpace == 17) {
  
          } else if(totalSpace == 18) {
              // cardgame
              System.out.println("\nYou have just landed at " + totalSpace);
              System.out.println("\nOn this space, you have to play CardGame (Hi-Lo)!");
              cardGame.cardgame();
  
          }  else if(totalSpace == 19) {
              System.out.println("\nYou have just landed at " + totalSpace);
          }
    }
}