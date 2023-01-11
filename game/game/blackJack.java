package game;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.lang.Math;


/**
@author adil
 */
public class blackJack {
    //Creating objects
    Random rnd = new Random();

    //cards the human and dealer will take
    int card;

    //the amount of cards the dealer will take
    //IT APPEARS THIS IS NOT USED
    int dealerCards;

    //the total value of the cards the dealer took
    int dealerCardValue;

    //the amount of cards the player will take
    int playerCards;

    //the total value of the cards the player took
    int playerCardValue;

    //the max value the player can have
    int maxValue = 21;

    //the minimum value the dealer can have
    int minValue = 17;

    //the amount of money the player bet
    double wager;

    //the maximum a player can wager
    int maxBet = 20000;

    //the minimum a player can wager
    int minBet = 1000;

    public double minMoneyEarned = 1.5;
    public double maxMoneyEarned = 2.5;
    public double minMoneyLost = 2.5;
    public double maxMoneyLost = 1.5;


    //the value of cards player/dealer chooses from
    int dealerRandomNumber = rnd.nextInt(1,11);
    int playerRandomNumber = rnd.nextInt(1,11);

    //whether the player hits or stand
    String playerDecision;

    public int dealerPickingCards() {
        dealerCardValue = dealerRandomNumber;
        while (dealerCardValue < 17) {
            dealerCardValue = dealerCardValue + rnd.nextInt(1,11);
        }
    return dealerCardValue;
    }

    public void instructions() {
        System.out.println("Welcome to blackjack! Enter w for instrcutions, anything else to continue");
        Scanner in = new Scanner(System.in);
        String instruction = in.nextLine();
        if (instruction.equals("W") || instruction.equals("w")) {
            System.out.println("Here's how to play.");
            System.out.println("Wager a value in between 1K and 20K. This is how much money you will be betting. If you win, you will win at least 20% more than what you wagered, and up to double your wager. If you lose, you will lose at least 20% of what you wagered, and up to losing everything you bet entirely.");
            System.out.println("Once you've wagered, you will receive two cards which will add up to a value. Each card has a value from 1 to 11. You can choose to either stand, and submit your total, or hit, and add another card to increase your total. The dealer will also pick cards. The goal is to submit and finish with a higher number than the dealer, but you CANNOT go over 21, or you will lose! The dealer cannot have a value under 17, so it is wise to avoid standing before you reach that number.");
            System.out.println("If you have a higher value than the dealer does after standing, you win, as long as you didn't bust! You can also win if the dealer busts (goes over 21) and you don't. However, if you go over 21, you lose regardless of what the dealer gets. If you and the dealer tie, then no one wins and you get your wager back, nothing less or more.");
        }
    }

    public void playerWager() {
        try {
            System.out.println("How much money would you like to wager? (please bet from 1K to 20K)");
            Scanner in = new Scanner(System.in);
            wager = in.nextDouble();
            if (wager > maxBet) {
                System.out.println("You cannot go over the max bet of $20K! Please enter a value between 1000 and 20000.");
                playerWager();
            }
            else if (wager < minBet) {
                System.out.println("You cannot go under the max bet of $1K! Please enter a value between 1000 and 20000.");
                playerWager();
            }
            else {
                System.out.println("You have wagered " + String.format("$%.2f", wager).replace("$0.", "$.") + "!");
                playerCardValue = rnd.nextInt(1,11) + playerRandomNumber;
                System.out.println("Your starting value is " + playerCardValue);
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please try again.");
            playerWager();
        }
    }


    public void playerPickingCards() {
        double minMoneyEarnedBeforeRound = wager*0.2 + wager;
        minMoneyEarned = Math.round(minMoneyEarnedBeforeRound*1000.00/1000.00);
        maxMoneyEarned = wager*2;
        double minMoneyLostBeforeRound = wager - wager*0.2;
        minMoneyLost = Math.round(minMoneyLostBeforeRound*1000.00/1000.00);
        maxMoneyLost = wager - wager;
        double moneyEarnedWinBeforeRound = rnd.nextDouble(minMoneyEarned, maxMoneyEarned);
        double moneyEarnedWin = Math.round(moneyEarnedWinBeforeRound*1000.00/1000.00);
        double moneyEarnedBeforeRound = moneyEarnedWin - wager;
        double moneyEarned = Math.round(moneyEarnedBeforeRound*1000.00/1000.00);
        double moneyEarnedLossBeforeRound = rnd.nextDouble(maxMoneyLost, minMoneyLost);
        double moneyEarnedLoss = Math.round(moneyEarnedLossBeforeRound*1000.00/1000.00);
        double moneyLostBeforeRound = wager - moneyEarnedLoss;
        double moneyLost = Math.round(moneyLostBeforeRound*1000.00/1000.00);
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
                System.out.println("You have won " + String.format("$%.2f", moneyEarned).replace("$0.", "$."));
                System.out.println(String.format("$%.2f", moneyEarnedWin).replace("$0.", "$.") + " will be added to your total");
            }
            else if (playerCardValue > 21) {
                System.out.println("You busted! You lose!");
                System.out.println("Your value: " + playerCardValue);
                System.out.println("Dealer value: " + dealerCardValue);
                System.out.println("You have lost " + String.format("$%.2f", moneyLost).replace("$0.", "$."));
                System.out.println(String.format("$%.2f", moneyEarnedLoss).replace("$0.", "$.") + " will be added to your total");
            }
            else if (dealerCardValue > 21) {
                System.out.println("The dealer busted! You win!");
                System.out.println("Your value: " + playerCardValue);
                System.out.println("Dealer value: " + dealerCardValue);
                System.out.println("You have won " + String.format("$%.2f", moneyEarned).replace("$0.", "$."));
                System.out.println(String.format("$%.2f", moneyEarnedWin).replace("$0.", "$.") + " will be added to your total");
            }
            else if (playerCardValue == dealerCardValue) {
                System.out.println("Push!");
                System.out.println("Your value: " + playerCardValue);
                System.out.println("Dealer value: " + dealerCardValue);
                System.out.println("Your wager of " + String.format("$%.2f", wager).replace("$0.", "$.") + " will be returned");
            }
            else {
                System.out.println("You lose!");
                System.out.println("Your value: " + playerCardValue);
                System.out.println("Dealer value: " + dealerCardValue);
                System.out.println("You have lost " + String.format("$%.2f", moneyLost).replace("$0.", "$."));
                System.out.println(String.format("$%.2f", moneyEarnedLoss).replace("$0.", "$.") + " will be added to your total");
            }
        }
        else {
            System.out.println("Please try again.");
            playerPickingCards();
        }
    }

    public void blackJack() {
        instructions();
        dealerPickingCards();
        playerWager();
        playerPickingCards();
    }
}