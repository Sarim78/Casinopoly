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
	Scanner in = new Scanner(System.in);

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

    //the value of cards player/dealer chooses from
    static int randomNumber = rnd.nextInt(1,11);

    public static int dealerPickingCards() {
        dealerCardValue = randomNumber;
        while (dealerCardValue < 17) {
            dealerCardValue = dealerCardValue + randomNumber;
        }
    return dealerCardValue;
    }

    public int playerWager() {
    System.out.println("How much money would you like to wager?");
    return 0;
    }
}