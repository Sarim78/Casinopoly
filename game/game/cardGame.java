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
        num = rnd.nextInt(1, 50);
        num1 = num;
    }

    public void bet() {
        // this method will let the player bet on them self. If they lose the game, they will lose all the money earned and even the bet.
        System.out.print("\nPlease Place Your Bet (Between 1000 - 20000): ");

        Scanner playerPlacingBet = new Scanner(System.in);
        playerBet = playerPlacingBet.nextInt();

        bet = playerBet;

        // after player make there bet, this methods will be called
        betOverUnderLimit();

        confrimBet(); 
        
        numberGenerator(); 

        //playerPlacingBet.close();
    }

    public void playerGettingMoney() {
        // This method will give the player money
        Random playerGettingMoneyGenerated = new Random(); 

        int moneyEarned = playerGettingMoneyGenerated.nextInt(1000, 8500);

        playerEarningRandomAmountMoney = moneyEarned;

        System.out.print("\nYou have earned: $" + moneyEarned + "!");
    }

    // This 4 methods if for playimng gaining ot losing money
    public void playerGettingMoney1CardGame() {
        // Player 1 earning the money
        player.gameEarnings = player.playersMoney + playerEarningRandomAmountMoney;
        player.bankAccount();
    }

    public void playerLosingMoney1CardGame() {
        // This method will let the player 1 lose money
        player.gameEarnings = player.playersMoney - playerBet;
        player.bankAccount();
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
        System.out.println("\nWelcome to Hi/Lo (CARD GAME)!");
        System.out.println("\nIf you would like to check out the instructions of this mini game, press (g). Otherwise, press anything.");
        Scanner instructions = new Scanner(System.in);
        String playerInput = instructions.nextLine();

        if(playerInput.equals("G") || playerInput.equals("g")) {
            // If the player presses G/g then this IF STATEMENT will run.
            System.out.println("\nInstructions: ");
            System.out.println("You will be assigned an number.");
            System.out.println("The A.i will decided if he should think of an number higher or lower of the assigned number.");
            System.out.println("Then you have to decide if the number is (Hi/Lo).");
            System.out.println("If you get the answer wrong, you will lose all the money you gained from this mini game and the game will end...");
            bet(); 
            //instructions.close();
        } else {
            bet();
            //instructions.close();
        }
    }
        
    public void confrimBet() {
        // this method will confrim the player bet
        try {
            Scanner confrimbet = new Scanner(System.in);

            // Asking user to confrim his bet
            System.out.println("\nYou have placed a bet of $" + bet);
            System.out.println("Please confrim if you want to place this bet (Y/N): ");

            String userConfrimBet = confrimbet.nextLine();

            // this if statement will check if player confrimed his bet or not
            if(userConfrimBet.equals("Y") || userConfrimBet.equals("y")) {
                System.out.println("\nAlright, your bet of $" + bet + " has been confrimed!");
                Ai(); 
                HiLo(); 
            } else if(userConfrimBet.equals("N") || userConfrimBet.equals("n")) {
                System.out.println("\nPlease Re-Enter Your Bet.");
                bet();
            }
            //confrimbet.close();
        } catch (Exception e) {
            System.out.println("\nERROR");
            confrimBet();
        }
    }

    public void Ai() {
        // this method will let the ai think of a number greater than or less then numberGenerator() method

        aiNum = rnd.nextInt(1, 50);
        ai = aiNum;

        System.out.println("\nAi: Am i thinking of an number higher or Lower of: " + ai + "?");
    }

    public void wouldYouTryAgainAfterWinning() {
        // This method will be called, if player wants to try again after winning
        try {
            Scanner tryAgain = new Scanner(System.in);

            // asking player if they want to play again
            System.out.println("\nWould you like to try again?");
            System.out.println("\nEnter Your Input (Y/N): ");
    
            String userTryAgain = tryAgain.nextLine();

            // this if statement will check user input
            if(userTryAgain.equals("Y") || userTryAgain.equals("y")) {
                Ai(); 
                HiLo2();
                //tryAgain.close();
            } else if(userTryAgain.equals("N") || userTryAgain.equals("n")) {
                System.out.println("\nYou have left the game...");
                //tryAgain.close();
            } else {
                System.out.println("\nYou have inputed an wrong answer.");
                System.out.println("Please try again");
                wouldYouTryAgainAfterWinning();
                //tryAgain.close();
            }
        } catch (Exception e) {
            System.out.println("\nError");
            wouldYouTryAgainAfterWinning();
        }
    }

    public void HiLo() {
        // Player guess if the number is Hi or Lo
        try {

            // This will ask the player there guess of hi or lo
            System.out.println("\nPlease Enter Your Guess (Hi/Lo): ");

            Scanner HiLo = new Scanner(System.in);

            String HiLoInput = HiLo.nextLine();

            // This if statement will check user guess
            if(HiLoInput.equals("Hi") || HiLoInput.equals("hi")) {

                // this if statement will check if the user guess is lower of grater then the ai guessed
                if(ai > num1) {
                    System.out.println("\nCongrats, You Got It Right!");
                    System.out.println("\nCONGRATS, you have won: $ " + playerEarningRandomAmountMoney);
                    playerGettingMoney();
                    wouldYouTryAgainAfterWinning();
                } else if(ai < num1) {
                    System.out.println("\nSorry, you lost :(");
                    System.out.println("You have lost all your bet money...");
                    System.out.println("The bet amount you have lost is: $" + bet);
                    playerLosingMoney1CardGame();
                } else {
                    System.out.println("\nYou only can pick between (Hi/Lo)"); 
                    bet();
                    HiLo();
                }

                //HiLo.close();

            } else if (HiLoInput.equals("Lo") || HiLoInput.equals("lo")) {

                // this if statement will check if the user guess is lower of grater then the ai guessed
                if(ai < num1) {
                    System.out.println("\nCongrats, You Got It Right!");
                    System.out.println("\nCONGRATS, you have won: $ " + playerEarningRandomAmountMoney);
                    playerGettingMoney();
                    wouldYouTryAgainAfterWinning();
                } else if(ai > num1) {
                    System.out.println("\nSorry, you lost :(");
                    System.out.println("You have lost all your bet money...");
                    System.out.println("The bet amount you have lost is: $" + bet);
                    playerLosingMoney1CardGame();
                } else {
                    System.out.println("\nYou only can pick between (Hi/Lo)"); 
                    bet();
                    HiLo();
                }

                //HiLo.close();

            }
        } catch (Exception e) {
            System.out.println("\nYou only can pick between (Hi/Lo)"); 
            bet();
            HiLo();
        }
    }

    public void HiLo2() {
        // If player wants to try again winning, this method will be called
        try {
            System.out.println("\nPlease Enter Your Guess (Hi/Lo): ");

            Scanner HiLo2 = new Scanner(System.in);
    
            String HiLo2Input = HiLo2.nextLine();
            
            if(HiLo2Input.equals("Hi") || HiLo2Input.equals("hi")) {
    
                if(ai > num1) {
                    System.out.println("\nCongrats, You Got It Right!");
                    System.out.println("\nCONGRATS, you have won: $ " + playerEarningRandomAmountMoney);
                    playerGettingMoney();
                } else if(ai < num1) {
                    System.out.println("\nSorry, you lost :(");
                    playerLosingMoney1CardGame();
                } else {
                    System.out.println("\nYou only can pick between (Hi/Lo)"); 
                    bet();
                    HiLo2();
                }
    
                //HiLo2.close();
    
            } else if (HiLo2Input.equals("Lo") || HiLo2Input.equals("lo")) {
    
                if(ai < num1) {
                    System.out.println("\nCongrats, You Got It Right!");
                    System.out.println("\nCONGRATS, you have won: $ " + playerEarningRandomAmountMoney);
    
                    playerGettingMoney();
                } else if(ai > num1) {
                    System.out.println("\nSorry, you lost :(");
                    playerLosingMoney1CardGame();
                }
    
                //HiLo2.close();
    
            } else {
                System.out.println("\nYou only can pick between (Hi/Lo)"); 
                HiLo();
                //HiLo2.close();
            }
        } catch (Exception e) {
            System.out.println("\nYou only can pick between (Hi/Lo)"); 
            bet();
            HiLo();
        }
    }
}   