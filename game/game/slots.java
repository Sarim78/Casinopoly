package game;

// Importing Libraries 
import java.util.Scanner;
import java.util.Random;
import src.player;
import src.player2;

/**
 * Casino Slot Game
 * @athuor Sarim Siddiqui
 */

public class slots {
    // Creating Objects 
    Random rnd = new Random();

    player player = new player();

    player2 player2 = new player2();

    // Creating Variables
    
    int bet; // Player bet Variable

    int randomMoney = 5500; // This is for random money generated, when you bet your money

    int jackPotMoney = 75000; // This will be a jackpot ($75k) for the slot machine. It will be very hard to win.

    int maxBet = 20000; // Max bet that player can make is $20k

    int minBet = 1000; // Min bet that player can make is $1k

    int slotMachine; // Slow Machine Variable

    int probability = 15; // The probability of winning the jackpot is 15%

    int money;

    int doubledMoney; // this will double the amount of money you win 

    String confrimBet;

    String playerInput;

    // Creating Methods
    public void instructions() { 
        try {
        // Scanner object for instructions
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
        } catch (Exception e) {
            System.out.println("\nError");
        }
    }

    public void jackPot() {
        // this method is for the jackpot of $75k, it will be hard to win.

        int jackpotPercentage = rnd.nextInt(1, 100);

        // if the random generator hit on 4 or 7, this IF STATEMENT will be printed
        if(jackpotPercentage == 4) {
            // This is for the jackpot, the chances to win this is (4%).
            System.out.println("\nYOU HAVE WON $" + jackPotMoney + "!");
            System.out.println("Congrats!");
        } else if(jackpotPercentage == 7) {
            // This is for the jackpot, the chances to win this is (7%).
            System.out.println("\nYOU HAVE WON $" + jackPotMoney + "!");
            System.out.println("Congrats!");
        }
    }

    public void jackpot1() {
        // this method will be called, if player 1 wins the jackpot
        player.playersMoney = player.playersMoney + jackPotMoney;
    }

    public void moneyGeneratedAfterBetting() {
        // This method is called after you place a bet, it will generate a random amount money for you. 
        // Between $0 - $5500 but the amount will get double

        money = rnd.nextInt(randomMoney);
        doubledMoney = money * 2; 

        System.out.println("\nYou have won: " + "$" + doubledMoney);
    }

    public void playerEarning1MoneySlots() {
        // Player 1 earning money
        player.playersMoney = player.playersMoney + doubledMoney;

        System.out.println("Your current balance is: $" + player.playersMoney);
    }

    public void confrimBet() {
        // this method will confrim the player bet
        try {
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
        } catch (Exception e) {
            System.out.println("\nError");
        }
    }

    public void slotMachine() {
        // this is a main method of slot machine
        try {
            // object for the scanner for slot machine
            Scanner betPlacer = new Scanner(System.in);

            // this is where use can input his bet
            System.out.println("\nPlease Place Your Bet: ");
            bet = betPlacer.nextInt();
    
            if(bet > maxBet) {
                // this statement gonna tell the player that his bet was over the limit
                System.out.println("\nYou have placed a bet of: " + "$" + bet);
                System.out.println("\nSorry, you went over the limit. The maximum limit of betting was: $20k...");
                betPlacer.close();
            } else if (bet < minBet) {
                // this statement gonna tell the player that his bet was under the limit
                System.out.println("\nYou have placed a bet of: " + "$" + bet);
                System.out.println("\nSorry, you went under the limit. The minimum limit of betting was: $1k...");
                betPlacer.close();
            } else {
                // If player place an bet between the range, this statement will print
                System.out.println("\nYou have placed a bet of: " + "$" + bet);
                confrimBet();
                moneyGeneratedAfterBetting();
                jackPot();
                betPlacer.close();
            }
        } catch (Exception e) {
            System.out.println("\nError");
        }
    }
}