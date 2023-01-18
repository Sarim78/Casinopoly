package game;

// Importing Libraries 
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

  startAndGo startAndGo = new startAndGo();

  public String spaceName;

  // Creating Variables

  public String showSpace = ("\nYou have just landed at space #" + player.totalSpace);

  // Creating Methods

  public void dice1() {
    // This method is for rolling a dice

    
    System.out.println("\nYou have rolled a: " + player.diceRoller);

    System.out.println(player.totalSpace);

    // Player 1
    if(player.totalSpace > 19) {
      player.totalSpace = player.totalSpace - 19;
    }

    gameBoardSpace();
  }

  public void dice2() {
    // This method is for rolling a dice

    
    System.out.println("\nYou have rolled a: " + player2.diceRoller);

    System.out.println(player2.totalSpace);

    // Player 2
    if(player2.totalSpace > 19) {
      player2.totalSpace = player2.totalSpace - 19;
      System.out.println(player2.totalSpace);
    }

    gameBoardSpace();
  }

  public void start() {
    spaceName = "START";
    System.out.println("\nBoth players are on space #1");
    System.out.println("This is the starting point of this game.");
  }

  public void gameBoardSpace() {
    // this if statement calls the game
    if(player.totalSpace == 1) {
      spaceName = "START";
      System.out.println("\nYou are on space #" + player.totalSpace);
      System.out.println("This is the starting point of this game.");
      startAndGo.start();

    } else if(player.totalSpace == 2) {
      //jackpotwheel
      spaceName = "Jackpot Wheel";
      System.out.println(showSpace);
      jackpotWheel.jackpotwheel();

    } else if(player.totalSpace == 3 || player.totalSpace == 12) {
      // roulette
      spaceName = "Roulette";
      System.out.println(showSpace);
      Roulette.roulette();

    } else if(player.totalSpace == 4 || player.totalSpace == 10) {
      //chance wheel
      spaceName = "Chance Wheel";
      System.out.println(showSpace);
      chanceWheel.chancewheel();

    } else if(player.totalSpace == 5 || player.totalSpace == 9) {
      // slot machine
      spaceName = "Slot Machine";
      System.out.println(showSpace);
      slots.slotMachine();

    } else if(player.totalSpace == 6 || player.totalSpace == 13) {
      // BlackJack
      spaceName = "Blackjack";
      System.out.println(showSpace);
      blackJack.blackjack();

    } else if(player.totalSpace == 7 || player.totalSpace == 18) {
      // cardgame
      spaceName = "Card Game";
      System.out.println(showSpace);
      cardGame.instructions();

    } else if(player.totalSpace == 8) {
      // Jail
      spaceName = "Jail";
      System.out.println(showSpace);
      System.out.println("You are visiting the jail! You have earned nothing...");

    } else if(player.totalSpace == 11 || player.totalSpace == 16) {
      //free space
      spaceName = "Free Space";
      System.out.println(showSpace);
      System.out.println("This is a free space, you have earned nothing...");

    } else if(player.totalSpace == 14) {
      // go to Jail
      spaceName = "Go To Jail";
      System.out.println(showSpace);

    } else if(player.totalSpace == 15) {
      //giant casinopoly wheel
      spaceName = "Giant Casinopoly Wheel";
      System.out.println(showSpace);
      giantWheel.giantwheel();

    } else if(player.totalSpace == 17) {
      //casinopoly shop
      spaceName = "Casinopoly Shop";
      System.out.println(showSpace);

    }  else if(player.totalSpace == 19) {
      //penalty wheel
      spaceName = "Penalty Wheel";
      System.out.println(showSpace);
      penaltyWheel.wheelOfPenalty();
    }
  }
}