package game;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
import src.player;
import src.player2;

/**
 * blackjack
@author adil
 */
public class blackJack {

    // Creating Objects

    Random rnd = new Random();

    player player = new player();

    player2 player2 = new player2();


    // Creating Variables

    int card; //cards the human and dealer will take

    int dealerCardValue; //the total value of the cards the dealer took

    int playerCards; //the amount of cards the player will take

    int playerCardValue; //the total value of the cards the player took

    int maxValue = 21; //the max value the player can have

    int minValue = 17; //the minimum value the dealer can have

    double wager; //the amount of money the player bet

    int maxBet = 20000; //the maximum a player can wager

    int minBet = 1000; //the minimum a player can wager

    double minMoneyEarned = 1.5; //the minimum amount of money you can earn

    double maxMoneyEarned = 2.5; //the maximum amount of money you can earn

    double minMoneyLost = 2.5; //the minimum amount of money you can earn

    double maxMoneyLost = 1.5; //the maximum amount of money you can earn

    double minMoneyEarnedBeforeRound; //minimum amount of money earned before rounded

    double minMoneyLostBeforeRound; //minimum amount of money lost before rounded

    double moneyEarnedWinBeforeRound; //amount of money earned if won before rounded

    double moneyEarnedWin; //amount of money earned if won

    double moneyEarnedBeforeRound; //amount of money earned before rounded

    double moneyEarned; //amount of money earned

    double moneyEarnedLossBeforeRound; //amount of money earned if lost before rounded

    double moneyEarnedLoss; //amount of money earned if lost

    double moneyLostBeforeRound; //amount of money lost before rounded

    double moneyLost; //amount of money lost

    //the value of cards player/dealer chooses from
    int dealerRandomNumber = rnd.nextInt(1,11);
    int playerRandomNumber = rnd.nextInt(1,11);

    String playerDecision; //whether the player hits or stand

    String instruction; //whether the player wants to see how to play or not

    //Creating Methods

    //welcome message and instructions if the player wants them
    public void instructions() {
        System.out.println("\nWelcome to blackjack! Enter w for instructions, anything else to continue");
        Scanner inStructions = new Scanner(System.in);
        instruction = inStructions.nextLine();
        if (instruction.equals("W") || instruction.equals("w")) { //if player wants to see instructions they are printed
            System.out.println("\nHere's how to play.");
            System.out.println("\nWager a value in between 1K and 20K. This is how much money you will be betting. If you win, you will win at least 20% more than what you wagered, and up to double your wager. If you lose, you will lose at least 20% of what you wagered, and up to losing everything you bet entirely.");
            System.out.println("\nOnce you've wagered, you will receive two cards which will add up to a value. Each card has a value from 1 to 11. You can choose to either stand, and submit your total, or hit, and add another card to increase your total. The dealer will also pick cards. The goal is to submit and finish with a higher number than the dealer, but you CANNOT go over 21, or you will lose! The dealer cannot have a value under 17, so it is wise to avoid standing before you reach that number.");
            System.out.println("\nIf you have a higher value than the dealer does after standing, you win, as long as you didn't bust! You can also win if the dealer busts (goes over 21) and you don't. However, if you go over 21, you lose regardless of what the dealer gets. If you and the dealer tie, then no one wins and you get your wager back, nothing less or more.");
            playerWager();
            //inStructions.close();
        } else {
            playerWager();
            //inStructions.close();
        }
    }
    
    // @author Sarim just this method
    public void player1EarningLosingMoneyBlackJack() {
        // this statement will let player add the money he/she earned
        src.player.gameEarnings = src.player.gameEarnings + moneyEarned;

        // this statement will let player subtract the money he/she lost
        src.player.gameEarnings = src.player.gameEarnings - moneyLost;
    }

    //the player enters their wager here
    public void playerWager() {
        try {
            System.out.println("\nHow much money would you like to wager? (please bet from 1K to 20K)");
            Scanner inWager = new Scanner(System.in);
            wager = inWager.nextDouble();
            //if the player goes over the max bet, they have to enter a different wager
            if (wager > maxBet) {
                System.out.println("\nYou cannot go over the max bet of $20K! Please enter a value between 1000 and 20000.");
                playerWager();
            }
            //if the player goes under the min bet, they have to enter a different wager
            else if (wager < minBet) {
                System.out.println("\nYou cannot go under the min bet of $1K! Please enter a value between 1000 and 20000.");
                playerWager();
            }
            //otherwise tell them their wager, starting value, and start playing
            else {
                System.out.println("\nYou have wagered " + String.format("$%.2f", wager).replace("$0.", "$.") + "!");
                playerCardValue = rnd.nextInt(1,11) + playerRandomNumber;
                System.out.println("\nYour starting value is " + playerCardValue);
                dealerPickingCards(); //this is when the dealer will pick cards
                playerPickingCards();
                //inWager.close();
            }
            
        } catch (Exception e) {
            System.out.println("\nInvalid input! Please try again.");
            playerWager();
        }
    }

    //the dealer keeps picking cards until they get a number of at least 17
    public int dealerPickingCards() {
        dealerCardValue = dealerRandomNumber;
        while (dealerCardValue < 17) {
            //this is how they keep adding cards
            dealerCardValue = dealerCardValue + rnd.nextInt(1,11);
        }
    return dealerCardValue;
    }

    //now the player gets to take cards
    public void playerPickingCards() {
        
        minMoneyEarnedBeforeRound = wager*0.2 + wager; //minimum money they can win, 20% of their wager
        minMoneyEarned = Math.round(minMoneyEarnedBeforeRound*1000.00/1000.00);
        maxMoneyEarned = wager*2; //maximum money they can win, 100% of their wager
        minMoneyLostBeforeRound = wager - wager*0.2; //minimum money they can lose, 20% of their wager
        minMoneyLost = Math.round(minMoneyLostBeforeRound*1000.00/1000.00);
        maxMoneyLost = wager - wager; //maximum money they can lose, all of their wager
        moneyEarnedWinBeforeRound = rnd.nextDouble(minMoneyEarned, maxMoneyEarned);
        moneyEarnedWin = Math.round(moneyEarnedWinBeforeRound*1000.00/1000.00);
        moneyEarnedBeforeRound = moneyEarnedWin - wager;
        moneyEarned = Math.round(moneyEarnedBeforeRound*1000.00/1000.00);
        moneyEarnedLossBeforeRound = rnd.nextDouble(maxMoneyLost, minMoneyLost);
        moneyEarnedLoss = Math.round(moneyEarnedLossBeforeRound*1000.00/1000.00);
        moneyLostBeforeRound = wager - moneyEarnedLoss;
        moneyLost = Math.round(moneyLostBeforeRound*1000.00/1000.00);
        //all the other variables here have been rendered irrelevant as the game has evolved

        System.out.println("\nWould you like to hit or stand? Enter h for hit, s for stand");
        Scanner inCards = new Scanner(System.in);
        
        playerDecision = inCards.nextLine();
        //if the player wants to hit (add cards)
        if (playerDecision.equals("H")|| playerDecision.equals("h")) {
            //add cards and add to their total card value
            playerCardValue = rnd.nextInt(1,11) + playerCardValue;
            System.out.println("\nYour card value is now: " + playerCardValue);
            playerPickingCards();
        }
        //if the player wants to stand
        else if (playerDecision.equals("S")|| playerDecision.equals("s")) {
            System.out.println("\nYou have decided to stand at a value of " + playerCardValue);
            //if the player didn't bust and they have a higher card value than the dealer they will win
            if (playerCardValue < 22 && playerCardValue > dealerCardValue) {
                System.out.println("\nCongratulations! You won!");
                System.out.println("\nYour value: " + playerCardValue);
                System.out.println("\nDealer value: " + dealerCardValue);
                System.out.println("\nYou have won " + String.format("$%.2f", moneyEarned).replace("$0.", "$."));
                //adding money to bank account
                src.player.gameEarnings = src.player.gameEarnings + moneyEarned;
                player.bankAccount();
            }
            else if (playerCardValue > 21) {
                //if the player goes over 21 they bust and lose regardless of the dealer
                System.out.println("\nYou busted! You lose!");
                System.out.println("\nYour value: " + playerCardValue);
                System.out.println("\nDealer value: " + dealerCardValue);
                System.out.println("\nYou have lost " + String.format("$%.2f", moneyLost).replace("$0.", "$."));
                //subtracting money from bank account
                src.player.gameEarnings = src.player.gameEarnings - moneyLost;
                player.bankAccount();
            }
            else if (dealerCardValue > 21) {
                //if they didn't bust but the dealer did, then they will win
                System.out.println("\nThe dealer busted! You win!");
                System.out.println("\nYour value: " + playerCardValue);
                System.out.println("\nDealer value: " + dealerCardValue);
                System.out.println("\nYou have won " + String.format("$%.2f", moneyEarned).replace("$0.", "$."));
                src.player.gameEarnings = src.player.gameEarnings + moneyEarned;
                player.bankAccount();
            }
            else if (playerCardValue == dealerCardValue) {
                //if they are the same, no one wins
                System.out.println("\nPush!");
                System.out.println("\nYour value: " + playerCardValue);
                System.out.println("\nDealer value: " + dealerCardValue);
                System.out.println("\nYou won't receive any money.");
            }
            else {
                //if the dealer has a higher value and no one busted, then the dealer will win
                System.out.println("\nYou lose!");
                System.out.println("\nYour value: " + playerCardValue);
                System.out.println("\nDealer value: " + dealerCardValue);
                System.out.println("\nYou have lost " + String.format("$%.2f", moneyLost).replace("$0.", "$."));
                src.player.gameEarnings = src.player.gameEarnings - moneyLost;
                player.bankAccount();
            }
        }
        else {
            System.out.println("\nPlease try again.");
            playerPickingCards();
        }
        //inCards.close();
    }

    //where the game gets called in other files
    public void blackjack() {
        instructions();
    }
}