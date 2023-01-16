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

  Random rnd = new Random();

  Scanner in = new Scanner(System.in);

  player player = new player();

  player2 player2 = new player2();

  jackpotWheel jackpotWheel = new jackpotWheel();

  chanceWheel chanceWheel = new chanceWheel();

  Roulette Roulette = new Roulette();

  slots slots = new slots();

  blackJack blackJack = new blackJack();

  penaltyWheel penaltyWheel = new penaltyWheel();

  giantWheel giantWheel = new giantWheel();

  cardGame cardGame = new cardGame();

  // Creating Variables

  public int totalSpace; // For Player 1
  
  public int totalSpace2; // For Player 2

  public String showSpace = ("\nYou have just landed at space #" + totalSpace);

  public int diceRoller;

  // Creating Methods

  public void dice() {
    // This method is for rolling a dice

    diceRoller = rnd.nextInt(1, 6);
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



  public void gameBoardSpace() {
    // this if statement calls the game
    if(totalSpace == 1) {
      System.out.println("\nYou are on space #" + totalSpace);
      System.out.println("This is the starting point of this game.");

    } else if(totalSpace == 2) {
      //jackpotwheel
      System.out.println(showSpace);
      jackpotWheel.jackpotwheel();

    } else if(totalSpace == 3 || totalSpace == 12) {
      // roulette
      System.out.println(showSpace);
      Roulette.roulette();

    } else if(totalSpace == 4 || totalSpace == 10) {
      //chance wheel
      System.out.println(showSpace);
      chanceWheel.chancesOfWheel();

    } else if(totalSpace == 5 || totalSpace == 9) {
      // slot machine
      System.out.println(showSpace);
      slots.slotMachine();

    } else if(totalSpace == 6 || totalSpace == 13) {
      // BlackJack
      System.out.println(showSpace);
      blackJack.blackjack();

    } else if(totalSpace == 7 || totalSpace == 18) {
      // cardgame
      System.out.println(showSpace);
      cardGame.instructions();

    } else if(totalSpace == 8) {
      // Jail
      System.out.println(showSpace);
      System.out.println("You are visiting the jail! You have earned nothing...");

    } else if(totalSpace == 11 || totalSpace == 16) {
      //free space
      System.out.println(showSpace);
      System.out.println("This is a free space, you have earned nothing...");

    } else if(totalSpace == 14) {
      // go to Jail
      System.out.println(showSpace);

    } else if(totalSpace == 15) {
      //giant casinopoly wheel
      System.out.println(showSpace);
      giantWheel.giantwheel();

    } else if(totalSpace == 17) {
      //casinopoly shop
      System.out.println(showSpace);

    }  else if(totalSpace == 19) {
      //penalty wheel
      System.out.println(showSpace);
      penaltyWheel.wheelOfPenalty();
    }
  }
}