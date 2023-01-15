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
            confrimBet();
        } else if(bet < 1000) {
            System.out.println("Sorry, you went under the betting limit. Min: $1k");
            bet();
            confrimBet();
        }
    }

    public void confrimBet() {
        // this method will confrim the player bet

        Scanner confrimingBet = new Scanner(System.in);

        System.out.println("You have placed a bet of $" + bet);
        System.out.println("Please confrim if you want to place this bet (Y/N): ");

        String confrimBet = confrimingBet.nextLine();

        if(confrimBet.equals("Y") || confrimBet.equals("y")) {
            System.out.println("\nAlright, your bet of $" + bet + " has been confrimed!");
            confrimingBet.close();
        } else if(confrimBet.equals("N") || confrimBet.equals("n")) {
            System.out.println("\nPlease Re-Enter Your Bet.");
            bet();
            confrimingBet.close();
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
            confrimBet(); 
            numberGenerator(); 
            Ai(); 
            HiLo(); 
            instructions.close();
        } else {
            bet(); 
            confrimBet(); 
            numberGenerator(); 
            Ai(); 
            HiLo(); 
            instructions.close();
        }
    }

    public void Ai() {
        // this method will let the ai think of a number greater than or less then numberGenerator() method
        System.out.println("\nAi: Am i thinking of an number higher or Lower of: " + num1 + "?");

        aiNum = rnd.nextInt(numberLimit);
        ai = aiNum;
    }

    public void HiLo() {

        while(true) {
            // Player guess if the number is Hi or Lo
            System.out.println("\nPlease Enter Your Guess (Hi/Lo): ");

            Scanner newUserInput = new Scanner(System.in);
    
            String userInput = newUserInput.nextLine();
            
            if(userInput.equals("Hi") || userInput.equals("hi")) {
    
                if(ai > num1) {
                    System.out.println("\nCongrats, You Got It Right!");
                    playerGettingMoney();
                    break;
                } else if(ai < num1) {
                    System.out.println("\nSorry, you lost :(");
                    break;
                }
                newUserInput.close();

            } else if (userInput.equals("Lo") || userInput.equals("lo")) {
    
                if(ai < num1) {
                    System.out.println("\nCongrats, You Got It Right!");
                    playerGettingMoney();
                    break;
                } else if(ai > num1) {
                    System.out.println("\nSorry, you lost :(");
                    break;
                }
                newUserInput.close();
            } else {
                System.out.println("You only can pick between (Hi/Lo)"); 
                HiLo();
            }
            newUserInput.close();
        }
    }

    public void cardgame() {
            // Calling all methods into one method
            instructions(); 
            bet(); 
            confrimBet(); 
            numberGenerator(); 
            Ai(); 
            HiLo(); 
    }
}   