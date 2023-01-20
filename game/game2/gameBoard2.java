package game2;

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

  jackpotWheel2 jackpotWheel = new jackpotWheel2();

  chanceWheel2 chanceWheel = new chanceWheel2();

  Roulette2 Roulette = new Roulette2();

  slots2 slots = new slots2();

  blackJack2 blackJack = new blackJack2();

  penaltyWheel2 penaltyWheel = new penaltyWheel2();

  giantWheel2 giantWheel = new giantWheel2();

  cardGame2 cardGame = new cardGame2();

  startAndGo2 startAndGo = new startAndGo2();

  jail2 Jail = new jail2();

  casinopolyShop2 casinopolyShop = new casinopolyShop2();

  // Creating Variables

  public String spaceName; //the name of the space

  // Creating Methods

  //@author Sarim
  public void dice2() {
    // This method is for rolling a dice

    player2.rollDice();

    System.out.println("\nYou have rolled a: " + player2.diceRoller);

    //System.out.println(player2.totalSpace);

    // Player 2
    if(src.player2.totalSpace > 19) {
      src.player2.totalSpace = src.player2.totalSpace - 19;
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
    if(src.player2.totalSpace == 1) {
      spaceName = "START";
      System.out.println("\nYou are on space #" + src.player2.totalSpace);
      System.out.println("This is the starting point of this game.");
      startAndGo.start();

    } else if(src.player2.totalSpace == 2) {
      //jackpotwheel
      spaceName = "Jackpot Wheel";
      System.out.println("\nYou have just landed at space #" + src.player2.totalSpace);
      jackpotWheel.jackpotwheel();

    } else if(src.player2.totalSpace == 3 || src.player2.totalSpace == 12) {
      // roulette
      spaceName = "Roulette";
      System.out.println("\nYou have just landed at space #" + src.player2.totalSpace);
      Roulette.roulette();

    } else if(src.player2.totalSpace == 4 || src.player2.totalSpace == 10) {
      //chance wheel
      spaceName = "Chance Wheel";
      System.out.println("\nYou have just landed at space #" + src.player2.totalSpace);
      chanceWheel.chancewheel();

    } else if(src.player2.totalSpace == 5 || src.player2.totalSpace == 9) {
      // slot machine
      spaceName = "Slot Machine";
      System.out.println("\nYou have just landed at space #" + src.player2.totalSpace);
      slots.slotmachine();

    } else if(src.player2.totalSpace == 6 || src.player2.totalSpace == 13) {
      // BlackJack
      spaceName = "Blackjack";
      System.out.println("\nYou have just landed at space #" + src.player2.totalSpace);
      blackJack.blackjack();

    } else if(src.player2.totalSpace == 7 || src.player2.totalSpace == 18) {
      // cardgame
      spaceName = "Card Game";
      System.out.println("\nYou have just landed at space #" + src.player2.totalSpace);
      cardGame.instructions();

    } else if(src.player2.totalSpace == 8) {
      // Jail
      spaceName = "Jail";
      System.out.println("\nYou have just landed at space #" + src.player2.totalSpace);
      System.out.println("You are visiting the jail! You have earned nothing...");

    } else if(src.player2.totalSpace == 11 || src.player2.totalSpace == 16) {
      //free space
      spaceName = "Free Space";
      System.out.println("\nYou have just landed at space #" + src.player2.totalSpace);
      System.out.println("This is a free space, you have earned nothing...");

    } else if(src.player2.totalSpace == 14) {
      // go to Jail
      spaceName = "Go To Jail";
      System.out.println("\nYou have just landed at space #" + src.player2.totalSpace);
      Jail.grettingUserToJail();

    } else if(src.player2.totalSpace == 15) {
      //giant casinopoly wheel
      spaceName = "Giant Casinopoly Wheel";
      System.out.println("\nYou have just landed at space #" + src.player2.totalSpace);
      giantWheel.giantwheel();

    } else if(src.player2.totalSpace == 17) {
      //casinopoly shop
      spaceName = "Casinopoly Shop";
      System.out.println("\nYou have just landed at space #" + src.player2.totalSpace);
      casinopolyShop.casinopolyshop();

    }  else if(src.player2.totalSpace == 19) {
      //penalty wheel
      spaceName = "Penalty Wheel";
      System.out.println("\nYou have just landed at space #" + src.player2.totalSpace);
      penaltyWheel.wheelOfPenalty();
    }
  }
}