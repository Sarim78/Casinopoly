package Src;
import java.util.Scanner;
import java.util.Random;

/**
 * Slot Game
 * @athuor Sarim Siddiqui
 */

public class slots {
    // Creating Objects 
    static Random rnd = new Random();
    static Scanner in = new Scanner(System.in);

    // Creating Variables
    static int bet; // Player bet Variable

    static int randomMoney = 5500; // This is for random money generated, when you bet your money

    static int jackPot = 75000; // This will be a jackpot ($75k) for the slot machine. It will be very hard to win.

    static int maxBet = 20000; // Max bet that player can make is $20k
    static int minBet = 1000; // Min bet that player can make is $1k

    static int slotMachine; // Slow Machine Variable

    // Methods for Casino Slot Machine
    public static void moneyGeneratedAfterBetting() {

        // This method is called after you place a bet, it will generate a random amount money for you. 
        // Between $0 - $5500 but the amount will get double

        int money = rnd.nextInt(randomMoney);
        int doubledMoney = money * 2; // this will double the amount of money you win 

        System.out.println("\nYou have won: " + "$" + doubledMoney);

        // This will make a play have a chance of 50/50 to lose or gain money.

    }

    public static void jackPot() {
        // this method is for the jackpot of $75k, it will be hard to win.
    }

    public static void slotMachine() {
        // This is a main methid for the Slot Machine. This is were all the methods gonna get called together.

        System.out.println("\nPlease Place Your Bet: ");
        bet = in.nextInt(); 

        if(bet > maxBet) {
            System.out.println("\nYou have placed a bet of: " + "$" + bet);
            System.out.println("Sorry, you went over the limit. The maximum limit of betting was: $20k...");
        } else if (bet < minBet) {
            System.out.println("\nYou have placed a bet of: " + "$" + bet);
            System.out.println("Sorry, you went under the limit. The minimum limit of betting was: $1k...");
        } else {
            System.out.println("\nYou have placed a bet of: " + "$" + bet);
            moneyGeneratedAfterBetting();
        }
    }
}