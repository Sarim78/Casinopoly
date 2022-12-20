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

    public static double minMoneyEarned = 1.5;
    public static double maxMoneyEarned = 2.5;
    public static double minMoneyLost = 2.5;
    public static double maxMoneyLost = 1.5;


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

    public static void instructions() {
        System.out.println("Welcome to blackjack! Enter w for instrcutions, anything else to continue");
        Scanner in = new Scanner(System.in);
        String instruction = in.nextLine();
        if (instruction.equals("W") || instruction.equals("w")) {
            System.out.println("Here's how to play. ");
        }
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
        minMoneyEarned = wager*0.2 + wager;
        maxMoneyEarned = wager*2;
        minMoneyLost = wager - wager*0.2;
        maxMoneyLost = wager - wager;
        double moneyEarnedWin = rnd.nextDouble(minMoneyEarned, maxMoneyEarned);
        double moneyEarned = moneyEarnedWin - wager;
        double moneyEarnedLoss = rnd.nextDouble(maxMoneyLost, minMoneyLost);
        double moneyLost = wager - moneyEarnedLoss;
        System.out.println("Your starting value is " + playerCardValue);
        System.out.println("Would you like to hit or stand? Enter h for hit, s for stand");
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
                System.out.println("Your value: " + playerCardValue);
                System.out.println("Dealer value: " + dealerCardValue);
                System.out.println("You have won $" + moneyEarned);
                System.out.println("$" + moneyEarnedWin + " will be added to your total");
            }
            else if (playerCardValue > 21) {
                System.out.println("You busted! You lose!");
                System.out.println("Your value: " + playerCardValue);
                System.out.println("Dealer value: " + dealerCardValue);
                System.out.println("You have lost $" + moneyLost);
                System.out.println("$" + moneyEarnedLoss + " will be added to your total");
            }
            else if (dealerCardValue > 21) {
                System.out.println("The dealer busted! You win!");
                System.out.println("Your value: " + playerCardValue);
                System.out.println("Dealer value: " + dealerCardValue);
                System.out.println("You have won $" + moneyEarned);
                System.out.println("$" + moneyEarnedWin + " will be added to your total");
            }
            else if (playerCardValue == dealerCardValue) {
                System.out.println("Push!");
                System.out.println("Your value: " + playerCardValue);
                System.out.println("Dealer value: " + dealerCardValue);
                System.out.println("Your wager of $" + wager + " will be returned");
            }
            else {
                System.out.println("You lose!");
                System.out.println("Your value: " + playerCardValue);
                System.out.println("Dealer value: " + dealerCardValue);
                System.out.println("You have lost $" + moneyLost);
                System.out.println("$" + moneyEarnedWin + " will be added to your total");
            }
        }
        else {
            System.out.println("Please try again.");
            playerPickingCards();
        }
    }
}