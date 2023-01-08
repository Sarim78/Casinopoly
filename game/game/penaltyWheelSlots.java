package game;

// Importing Libraries 
import java.util.Random;
import java.util.Scanner;

// Importing Files 
import src.player;
import src.player2;

/**
 * Chances Wheel
 * @athuor Sarim Siddiqui
 */

public class penaltyWheelSlots {
    // Creating Objects  
    static Random rnd = new Random();
    static Scanner in = new Scanner(System.in);

    // Creating Variables
    static int userGettingFined;

    // This 3 methods will be called if player lands on playerChoosesToMoveYou Slot
    public static void playerChoosesToMoveYou() {
        // Player decides how much another player can move
        System.out.println("\nAnother player has to decide, how much you have to move backwards!");
        System.out.println("Player only can move another player between (1 - 3) spaces!");
    }

    public static void playerMove1() {
        // Player 1
        System.out.println("\nPlayer 2: Please enter the amount, you want Player 1 to move!");
        System.out.println("Player 2: Please enter the amount: ");
        int player2Decides = in.nextInt();

        if(player2Decides < 3) {
            // If player pick any number over 3, this statment will print
            System.out.println("\nSorry, you went over the limit...");
            System.out.println("Please Enter Again...");
        } else if (player2Decides > 1) {
            // If player pick any number under 1, this statment will print
            System.out.println("\nSorry, you went under the limit...");
            System.out.println("Please Enter Again...");
        } else { 
            // If player picks between (1-3), this if statment will print
            if(player2Decides == 1) {
                // if player 2 decides to pick 1, player 1 moves back 1.
                player.space = player.space - player2Decides;
            } else if(player2Decides == 2) {
                // if player 2 decides to pick 2, player 1 moves back 1.
                player.space = player.space - player2Decides;
            } else if(player2Decides == 3) {
                // if player 2 decides to pick 3, player 1 moves back 1.
                player.space = player.space - player2Decides;
            }
        }
    }

    public static void playerMove2() {
        // Player 2
        System.out.println("\nPlayer 1: Please enter the amount, you want Player 1 to move!");
        System.out.println("Player 1: Please enter the amount: ");
        int player1Decides = in.nextInt();

        if(player1Decides > 3) {
            // If player pick any number over 3, this statment will print
            System.out.println("\nSorry, you went over the limit...");
            System.out.println("Please Enter Again...");
        } else if (player1Decides < 1) {
            // If player pick any number under 1, this statment will print
            System.out.println("\nSorry, you went under the limit...");
            System.out.println("Please Enter Again...");
        } else { 
            // If player picks between (1-3), this if statment will print
            if(player1Decides == 1) {
                // if player 1 decides to pick 1, player 2 moves back 1.
                player.space = player.space - player1Decides;
            } else if(player1Decides == 2) {
                // if player 1 decides to pick 2, player 2 moves back 1.
                player.space = player.space - player1Decides;
            } else if(player1Decides == 3) {
                // if player 1 decides to pick 3, player 2 moves back 1.
                player.space = player.space - player1Decides;
            }
        }
    }

    // This 3 methods will be called if player lands on goToJail Slot
    public static void goToJail() {
        // Player will go directly to jail for illegal gambling
        System.out.println("\nYou have been sent back to jail for illegal gambling...");
        System.out.println("Sad to see you go :(");
    }

    public static void goToJail1() {
        // Player 1 sent to jail

        // This IF statement will check if player 1 is at space 19
        if(player.space == 19) {
            player.space = player.space - 11;
            System.out.println("\nYour current position: " + player.space);
        } else {
            // if player is not at space 19, it will show error
            System.out.println("\nError");
        }
    }

    public static void goToJail2() {
        // Player 2 sent to jail

        // This IF statement will check if player 2 is at space 19
        if(player2.space == 19) {
            player2.space = player2.space - 11;
            System.out.println("\nYour current position: " + player2.space);
        } else {
            // if player is not at space 19, it will show error
            System.out.println("\nError");
        }
    }

    // This 3 methods will be called if player lands on goToJail Slot
    public static void playerLosesMoney() {
        // Player loses money, another player decides by how much they lose
        System.out.println("\nPlayer decides how much money you will lose...");
        System.out.println("The range the player can decide is between ($500 to $2000)");
    }

    public static void playerLosesMoney1() {
        // Player 1
        System.out.println("Player 2: Please enter an amount: ");
        int player2DecidesMoney = in.nextInt();

        if(player2DecidesMoney > 2000) {
            // If player 2 pickes an amount over $2000, it will print this statement
            System.out.println("\nSorry, you went over the limit...");
            System.out.println("Please Enter Again...");
        } else if(player2DecidesMoney < 500) {
            // If player 2 pickes an amount under $500, it will print this statement
            System.out.println("\nSorry, you went under the limit...");
            System.out.println("Please Enter Again...");
        } else {
            // If player 2 picks an amount between the range, it will print this statement
            player.playersMoney = player.playersMoney - player2DecidesMoney;

            // this print statment will print player 1 balance
            System.out.println("\n Player 1 current balance is: $" + player.playersMoney);
        }
    }

    public static void playerLosesMoney2() {
        // Player 2
        System.out.println("Player 1: Please enter an amount: ");
        int player1DecidesMoney = in.nextInt();

        if(player1DecidesMoney > 2000) {
            // If player 2 pickes an amount over $2000, it will print this statement
            System.out.println("\nSorry, you went over the limit...");
            System.out.println("Please Enter Again...");
        } else if(player1DecidesMoney < 500) {
            // If player 2 pickes an amount under $500, it will print this statement
            System.out.println("\nSorry, you went under the limit...");
            System.out.println("Please Enter Again...");
        } else {
            // If player 2 picks an amount between the range, it will print this statement
            player.playersMoney = player.playersMoney - player1DecidesMoney;

            // this print statment will print player 1 balance
            System.out.println("\n Player 1 current balance is: $" + player.playersMoney);
        }
    }

    // This 3 methods will be called if player lands on goToJail Slot
    public static void gettingFined() {
        // Player getting fined

        // Calling the random library for random generating the fine
        int fined = rnd.nextInt(500, 6550);
        userGettingFined = fined;
        
        System.out.println("\nYou are getting fined for no reason :)");

        // this statement will tell the user, how much he getting fined
        System.out.println("\nYou have been fined: $" + userGettingFined);
    }
    
    public static void gettingFined1() {
        // Player 1

        // this statement will subtract the fined money from users balance
        player.playersMoney = player.playersMoney - userGettingFined;

        // this print statement will tell the player 1 balance
        System.out.println("Your current balance is: $" + player.playersMoney);
    }

    public static void gettingFined2() {
        // Player 2

        // this statement will subtract the fined money from users balance
        player2.playersMoney = player2.playersMoney - userGettingFined;

        // this print statement will tell the player 2 balance
        System.out.println("Your current balance is: $" + player2.playersMoney);
    }

    // This 3 methods will be called if player lands on movingPrevelges Slot
    public static void movingPrevelges() {
        // Player moving prevelges are gone until another player dont move more then 2 spaces
        System.out.println("\nYour moving prevelges are gone until another player dont move more then 2 spaces!");
        System.out.println("HAVE FUN!");
    }

    public static void movingPrevelges1() {
        // Player 1

    }

    public static void movingPrevelges2() {
        // Player 2

    }
}