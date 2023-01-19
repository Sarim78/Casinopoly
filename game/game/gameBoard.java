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

  jail Jail = new jail();

  public String spaceName;

  // Creating Variables

  

  // Creating Methods

  public void dice1() {
    // This method is for rolling a dice

    player.rollDice();

    System.out.println("\nYou have rolled a: " + player.diceRoller);

    //System.out.println(player.totalSpace);

    // Player 1
    if(player.totalSpace > 19) {
      player.totalSpace = player.totalSpace - 19;
      startAndGo.passGo();
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
      System.out.println("\nYou have just landed at space #" + player.totalSpace);
      jackpotWheel.jackpotwheel();

    } else if(player.totalSpace == 3 || player.totalSpace == 12) {
      // roulette
      spaceName = "Roulette";
      System.out.println("\nYou have just landed at space #" + player.totalSpace);
      Roulette.roulette();

    } else if(player.totalSpace == 4 || player.totalSpace == 10) {
      //chance wheel
      spaceName = "Chance Wheel";
      System.out.println("\nYou have just landed at space #" + player.totalSpace);
      chanceWheel.chancewheel();

    } else if(player.totalSpace == 5 || player.totalSpace == 9) {
      // slot machine
      spaceName = "Slot Machine";
      System.out.println("\nYou have just landed at space #" + player.totalSpace);
      slots.slotmachine();

    } else if(player.totalSpace == 6 || player.totalSpace == 13) {
      // BlackJack
      spaceName = "Blackjack";
      System.out.println("\nYou have just landed at space #" + player.totalSpace);
      blackJack.blackjack();

    } else if(player.totalSpace == 7 || player.totalSpace == 18) {
      // cardgame
      spaceName = "Card Game";
      System.out.println("\nYou have just landed at space #" + player.totalSpace);
      cardGame.instructions();

    } else if(player.totalSpace == 8) {
      // Jail
      spaceName = "Jail";
      System.out.println("\nYou have just landed at space #" + player.totalSpace);
      System.out.println("You are visiting the jail! You have earned nothing...");
      Jail.player1LandedOnJail();

    } else if(player.totalSpace == 11 || player.totalSpace == 16) {
      //free space
      spaceName = "Free Space";
      System.out.println("\nYou have just landed at space #" + player.totalSpace);
      System.out.println("This is a free space, you have earned nothing...");

    } else if(player.totalSpace == 14) {
      // go to Jail
      spaceName = "Go To Jail";
      System.out.println("\nYou have just landed at space #" + player.totalSpace);

    } else if(player.totalSpace == 15) {
      //giant casinopoly wheel
      spaceName = "Giant Casinopoly Wheel";
      System.out.println("\nYou have just landed at space #" + player.totalSpace);
      giantWheel.giantwheel();

    } else if(player.totalSpace == 17) {
      //casinopoly shop
      spaceName = "Casinopoly Shop";
      System.out.println("\nYou have just landed at space #" + player.totalSpace);

    }  else if(player.totalSpace == 19) {
      //penalty wheel
      spaceName = "Penalty Wheel";
      System.out.println("\nYou have just landed at space #" + player.totalSpace);
      penaltyWheel.wheelOfPenalty();
    }
  }
}