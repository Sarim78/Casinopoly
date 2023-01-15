package game;

// Importing Libraries 
import java.util.Scanner;
import java.util.Random;

/**
 * Casino Slot Game
 * @athuor Sarim Siddiqui
 */

public class slots {
    // Creating Objects 
    Random rnd = new Random();

    // Creating Variables
    int bet; // Player bet Variable

    int randomMoney = 5500; // This is for random money generated, when you bet your money

    int jackPot = 75000; // This will be a jackpot ($75k) for the slot machine. It will be very hard to win.

    int maxBet = 20000; // Max bet that player can make is $20k

    int minBet = 1000; // Min bet that player can make is $1k

    int slotMachine; // Slow Machine Variable

    int probability = 15; // The probability of winning the jackpot is 15%

    int money;

    int doubledMoney; // this will double the amount of money you win 

    String confrimBet;

    String playerInput;

    // Creating Methods

    public void moneyGeneratedAfterBetting() {
        // This method is called after you place a bet, it will generate a random amount money for you. 
        // Between $0 - $5500 but the amount will get double

        money = rnd.nextInt(randomMoney);
        doubledMoney = money * 2; 

        System.out.println("\nYou have won: " + "$" + doubledMoney);
    }

    public void instructions() { 

        Scanner instructions = new Scanner(System.in);

        // This methid will tell the players the instructions of this mini game
        System.out.println("\nIf you would like to check out the instructions of this mini game, press (g). Otherwise, press anything.");

        String playerInput = instructions.nextLine();

        if(playerInput.equals("G") || playerInput.equals("g")) {
            System.out.println("\nInstructions: ");
            System.out.println("You only can place an bet between $1k to $25k.");
            System.out.println("You have to place a bet.");
            System.out.println("You might win more money.");
            System.out.println("Or You might lose your money.");
            slotMachine();
            instructions.close();
        } else {
            slotMachine();
            instructions.close();
        }
    }

    public void jackPot() {
        // this method is for the jackpot of $75k, it will be hard to win.
        
        if(Math.random() < 0.15) {
            // This is for the jackpot, the chances to win this is (15%).
            System.out.println("\nYOU HAVE WON $" + jackPot + "!");
            System.out.println("Congrats!");
            slotMachine();
        }
    }

    public void confrimBet() {
        // this method will confrim the player bet

        Scanner playerConfrimBet = new Scanner(System.in);

        System.out.println("\nPlease confrim if you want to place this bet (Y/N): ");

        String confrimBet = playerConfrimBet.nextLine();

        if(confrimBet.equals("Y") || confrimBet.equals("y")) {
            System.out.println("\nAlright, your bet of $" + bet + " has been confrimed!");
        } else if(confrimBet.equals("N") || confrimBet.equals("n")) {
            System.out.println("\nPlease Re-Enter Your Bet.");
            slotMachine();
            playerConfrimBet.close();
        }
    }

    public void slotMachine() {
        Scanner betPlacer = new Scanner(System.in);

        System.out.println("\nPlease Place Your Bet: ");
        bet = betPlacer.nextInt();

        if(bet > maxBet) {
            System.out.println("\nYou have placed a bet of: " + "$" + bet);
            System.out.println("\nSorry, you went over the limit. The maximum limit of betting was: $20k...");
            betPlacer.close();
        } else if (bet < minBet) {
            System.out.println("\nYou have placed a bet of: " + "$" + bet);
            System.out.println("\nSorry, you went under the limit. The minimum limit of betting was: $1k...");
            betPlacer.close();
        } else {
            System.out.println("\nYou have placed a bet of: " + "$" + bet);
            confrimBet();
            moneyGeneratedAfterBetting();
            jackPot();
            betPlacer.close();
        }
    }
}