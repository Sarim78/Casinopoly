package game;

// Importing Libraries 
import java.util.Scanner;
import java.util.Random;
import src.player;
import src.player2;

/**
 * Card Game (Hi-Lo)
 * @athuor Sarim Siddiqui
 */

public class cardGame {
    // Creating Objects 
    Random rnd = new Random(); 
    
    Scanner in = new Scanner(System.in);

    player player = new player();

    player2 player2 = new player2();

    // Creating Variables
    int numberLimit = 50; // this is for a limit that the numberGenerator() method can use

    int num1; // this Variable is for the method called numberGenerator()

    int ai; // this Variable is for the method called Ai()

    int bet; // this Variable is for the method called bet()

    int num;

    int playerBet;

    int aiNum;

    int playerEarningRandomAmountMoney;

    int maxMoneyLose;

    int minMoneyLose;

    // Creating Methods
    
    public void numberGenerator() {
        // This method will tell the player, if you need to guess Hi or Lo
        num = rnd.nextInt(numberLimit);
        num1 = num;
    }

    public void bet() {
        // this method will let the player bet on them self. If they lose the game, they will lose all the money earned and even the bet.
        System.out.print("\nPlease Place Your Bet (Between 1000 - 20000): ");

        Scanner playerPlacingBet = new Scanner(System.in);
        playerBet = playerPlacingBet.nextInt();

        bet = playerBet;

        betOverUnderLimit();

        playerPlacingBet.close();

        confrimBet(); 
    }

    public void playerGettingMoney() {
        // This method will give the player money
        int moneyEarned = rnd.nextInt(1000, 8500);

        playerEarningRandomAmountMoney = moneyEarned;

        System.out.print("\nYou have earned: $" + moneyEarned + "!");
    }

    public void playerGettingMoney1() {
        // Player 1 earning the money
        player.playersMoney = player.playersMoney + playerEarningRandomAmountMoney;

        System.out.println("\nYour current balance is: " + "$" + player.playersMoney);
    }

    public void playerGettingMoney2() {
        // Player 2 earning the money
        player2.playersMoney = player2.playersMoney + playerEarningRandomAmountMoney;

        System.out.println("\nYour current balance is: " + "$" + player2.playersMoney);
    }

    public void betOverUnderLimit() {
        // this method if for when the player bet over $20k or under $1k.
        if(bet > 20000) {
            System.out.println("Sorry, you went over the betting limit. Max: $20k");
            bet();
        } else if(bet < 1000) {
            System.out.println("Sorry, you went under the betting limit. Min: $1k");
            bet();
        }
    }

    public void instructions() { 
        // This methid will tell the players the instructions of this mini game
        System.out.println("\nIf you would like to check out the instructions of this mini game, press (g). Otherwise, press anything.");

        Scanner instructions = new Scanner(System.in);;
        String playerInput = in.nextLine();

        if(playerInput.equals("G") || playerInput.equals("g")) {
            // If the player presses G/g then this IF STATEMENT will run.
            System.out.println("\nInstructions: ");
            System.out.println("You will be assigned an number.");
            System.out.println("The A.i will decided if he should think of an number higher or lower of the assigned number.");
            System.out.println("Then you have to decide if the number is (Hi/Lo).");
            System.out.println("If you get the answer wrong, you will lose all the money you gained from this mini game and the game will end...");
            System.out.println("Otherwise, you will keep going on until you lose. You will earn $2k every round you WIN!");
            bet(); 
            numberGenerator(); 
            Ai(); 
            HiLo(); 
            instructions.close();
        } else {
            bet(); 
            numberGenerator(); 
            Ai(); 
            HiLo(); 
            instructions.close();
        }
    }

    public void confrimBet() {
        // this method will confrim the player bet
        Scanner confrimbet = new Scanner(System.in);

        System.out.println("\nYou have placed a bet of $" + bet);
        System.out.println("Please confrim if you want to place this bet (Y/N): ");

        String userConfrimBet = confrimbet.nextLine();

        if(userConfrimBet.equals("Y") || userConfrimBet.equals("y")) {
            System.out.println("\nAlright, your bet of $" + bet + " has been confrimed!");
            confrimbet.close();
        } else if(userConfrimBet.equals("N") || userConfrimBet.equals("n")) {
            System.out.println("\nPlease Re-Enter Your Bet.");
            bet();
            confrimbet.close();
        } else {
            System.out.println("\nERROR");
            confrimbet.close();
        }
    }

    public void Ai() {
        // this method will let the ai think of a number greater than or less then numberGenerator() method
        System.out.println("\nAi: Am i thinking of an number higher or Lower of: " + num1 + "?");

        aiNum = rnd.nextInt(numberLimit);
        ai = aiNum;
    }

    public void playerLosingMoney1() {
        // This method will let the player 1 lose money

    }

    public void playerLosingMoney2() {
        // This method will let the player 2 lose money

    }

    public void HiLo() {

        Scanner newUserInput = new Scanner(System.in);

            // Player guess if the number is Hi or Lo
            System.out.println("\nPlease Enter Your Guess (Hi/Lo): ");
    
            String userInput = newUserInput.nextLine();
            
            if(userInput.equals("Hi") || userInput.equals("hi")) {
    
            if(ai > num1) {
                System.out.println("\nCongrats, You Got It Right!");
                playerGettingMoney();
                newUserInput.close();
            } else if(ai < num1) {
                System.out.println("\nSorry, you lost :(");
            }
        } else if (userInput.equals("Lo") || userInput.equals("lo")) {
    
            if(ai < num1) {
                System.out.println("\nCongrats, You Got It Right!");
                playerGettingMoney();
                newUserInput.close();
            } else if(ai > num1) {
                System.out.println("\nSorry, you lost :(");
                newUserInput.close();
            }
        } else {
            System.out.println("\nYou only can pick between (Hi/Lo)"); 
            HiLo();
            newUserInput.close();
        }
    }

    // public void cardgame() {
    //         // Calling all methods into one method
    //         instructions(); 
    //         bet(); 
    //         confrimBet(); 
    //         numberGenerator(); 
    //         Ai(); 
    //         HiLo(); 
    // }
}   