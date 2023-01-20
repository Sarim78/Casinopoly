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

public class gameBoard2 {
  
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

  casinopolyShop casinopolyShop = new casinopolyShop();

  // Creating Variables

  public String spaceName; //the name of the space

  // Creating Methods

  //@author Sarim
  public void dice1() {
    // This method is for rolling a dice

    player.rollDice();

    System.out.println("\nYou have rolled a: " + player.diceRoller);

    //System.out.println(player.totalSpace);

    // Player 1
    if(src.player.totalSpace > 19) {
      src.player.totalSpace = src.player.totalSpace - 19;
      startAndGo.passGo();
    }

    gameBoardSpace();
  }

  //@author adil
  //this gets called before the game starts, lets the players know they they are starting at the start
  public void start() {
    spaceName = "START";
    System.out.println("\nBoth players are on space #1");
    System.out.println("This is the starting point of this game.");
  }

  //@author Sarim
  public void gameBoardSpace() {
    // this if statement calls the game
    if(src.player.totalSpace == 1) {
      spaceName = "START";
      System.out.println("\nYou are on space #" + src.player.totalSpace);
      System.out.println("This is the starting point of this game.");
      startAndGo.start();

    } else if(src.player.totalSpace == 2) {
      //jackpotwheel
      spaceName = "Jackpot Wheel";
      System.out.println("\nYou have just landed at space #" + src.player.totalSpace);
      jackpotWheel.jackpotwheel();

    } else if(src.player.totalSpace == 3 || src.player.totalSpace == 12) {
      // roulette
      spaceName = "Roulette";
      System.out.println("\nYou have just landed at space #" + src.player.totalSpace);
      Roulette.roulette();

    } else if(src.player.totalSpace == 4 || src.player.totalSpace == 10) {
      //chance wheel
      spaceName = "Chance Wheel";
      System.out.println("\nYou have just landed at space #" + src.player.totalSpace);
      chanceWheel.chancewheel();

    } else if(src.player.totalSpace == 5 || src.player.totalSpace == 9) {
      // slot machine
      spaceName = "Slot Machine";
      System.out.println("\nYou have just landed at space #" + src.player.totalSpace);
      slots.slotmachine();

    } else if(src.player.totalSpace == 6 || src.player.totalSpace == 13) {
      // BlackJack
      spaceName = "Blackjack";
      System.out.println("\nYou have just landed at space #" + src.player.totalSpace);
      blackJack.blackjack();

    } else if(src.player.totalSpace == 7 || src.player.totalSpace == 18) {
      // cardgame
      spaceName = "Card Game";
      System.out.println("\nYou have just landed at space #" + src.player.totalSpace);
      cardGame.instructions();

    } else if(src.player.totalSpace == 8) {
      // Jail
      spaceName = "Jail";
      System.out.println("\nYou have just landed at space #" + src.player.totalSpace);
      System.out.println("You are visiting the jail! You have earned nothing...");

    } else if(src.player.totalSpace == 11 || src.player.totalSpace == 16) {
      //free space
      spaceName = "Free Space";
      System.out.println("\nYou have just landed at space #" + src.player.totalSpace);
      System.out.println("This is a free space, you have earned nothing...");

    } else if(src.player.totalSpace == 14) {
      // go to Jail
      spaceName = "Go To Jail";
      System.out.println("\nYou have just landed at space #" + src.player.totalSpace);
      Jail.grettingUserToJail();

    } else if(src.player.totalSpace == 15) {
      //giant casinopoly wheel
      spaceName = "Giant Casinopoly Wheel";
      System.out.println("\nYou have just landed at space #" + src.player.totalSpace);
      giantWheel.giantwheel();

    } else if(src.player.totalSpace == 17) {
      //casinopoly shop
      spaceName = "Casinopoly Shop";
      System.out.println("\nYou have just landed at space #" + src.player.totalSpace);
      casinopolyShop.casinopolyshop();

    }  else if(src.player.totalSpace == 19) {
      //penalty wheel
      spaceName = "Penalty Wheel";
      System.out.println("\nYou have just landed at space #" + src.player.totalSpace);
      penaltyWheel.wheelOfPenalty();
    }
  }
}