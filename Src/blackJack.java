package Src;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;


/**
@author adil
 */
public class blackJack {
    //Creating objects
    static Random rnd = new Random();

    //cards the human and dealer will take
    int card;

    //the amount of cards the dealer will take
    //IT APPEARS THIS IS NOT USED
    static int dealerCards;

    //the total value of the cards the dealer took
    static int dealerCardValue;

    //the amount of cards the player will take
    int playerCards;

    //the total value of the cards the player took
    static int playerCardValue;

    //the max value the player can have
    int maxValue = 21;

    //the minimum value the dealer can have
    int minValue = 17;

    //the amount of money the player bet
    static int wager;

    //the maximum a player can wager
    static int maxBet = 20000;

    //the minimum a player can wager
    int minBet = 1000;

    static boolean didWin;

    //the value of cards player/dealer chooses from
    static int dealerRandomNumber = rnd.nextInt(1,11);
    static int playerRandomNumber = rnd.nextInt(1,11);

    //whether the player hits or stand
    static String playerDecision;

    public static int dealerPickingCards() {
        dealerCardValue = dealerRandomNumber;
        while (dealerCardValue < 17) {
            dealerCardValue = dealerCardValue + rnd.nextInt(1,11);
        }
    return dealerCardValue;
    }

    public static void playerWager() {
        System.out.println("How much money would you like to wager?");
        Scanner in = new Scanner(System.in);
        wager = in.nextInt();
        if (wager > maxBet) {
            System.out.println("You cannot go over the max bet of $20K! Please enter a value between 1000 and 20000.");
        }
        else {
            System.out.println("You have wagered $" + wager + "!");
        }
        playerCardValue = rnd.nextInt(1,11) + playerRandomNumber;
    }

    public static void playerPickingCards() {
        System.out.println("Your starting value is " + playerCardValue);
        System.out.println("Would you like to hit or stand? Press h for hit, s for stand");
        Scanner in = new Scanner(System.in);
        playerDecision = in.nextLine();
        if (playerDecision.equals("H")|| playerDecision.equals("h")) {
            playerCardValue = rnd.nextInt(1,11) + playerCardValue;
            System.out.println("Your card value is now: " + playerCardValue);
            playerPickingCards();
        }
        else if (playerDecision.equals("S")|| playerDecision.equals("s")) {
            System.out.println("You have decided to stand at a value of " + playerCardValue);
            if (playerCardValue < 22 && playerCardValue > dealerCardValue) {
                System.out.println("Congratulations! You won!");
                didWin = true;
                System.out.println("Your value: " + playerCardValue);
                System.out.println("Dealer value: " + dealerCardValue);
            }
            else if (playerCardValue > 21) {
                System.out.println("You busted! You lose!");
                didWin = false;
                System.out.println("Your value: " + playerCardValue);
                System.out.println("Dealer value: " + dealerCardValue);
            }
            else if (dealerCardValue > 21) {
                System.out.println("The dealer busted! You win!");
                didWin = true;
                System.out.println("Your value: " + playerCardValue);
                System.out.println("Dealer value: " + dealerCardValue);
            }
            else if (playerCardValue == dealerCardValue) {
                System.out.println("Push!");
                System.out.println("Your value: " + playerCardValue);
                System.out.println("Dealer value: " + dealerCardValue);
                System.out.println("Your wager of $" + wager + " will be returned");
            }
            else {
                System.out.println("You lose!");
                didWin = false;
                System.out.println("Your value: " + playerCardValue);
                System.out.println("Dealer value: " + dealerCardValue);
            }
        }
        else {
            System.out.println("Please try again.");
            playerPickingCards();
        }
    }

    public static void moneyReturned() {
        
    }
}