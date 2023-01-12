package game;

// Importing Libraries 
import java.util.Random;
import java.util.Scanner;

// Importing Files 
import src.player;
import src.player2;

public class wheelMethods {
    // Variables
    public static int raffelCardMoney;
    public static int userGettingFined;
    public static String showPlayer1Money = ("\nPlayer 1: Your current Balance In Your Account is: $" + String.format("$%.2f", player.playersMoney).replace("$0.", "$."));
    public static String showPlayer2Money = ("\nPlayer 2: Your current Balance In Your Account is: $" + String.format("$%.2f", player2.playersMoney).replace("$0.", "$."));
    
    // Creating Objects  
    static Random rnd = new Random();
    static Scanner in = new Scanner(System.in);

    // Method For Slots In The Chances Of Wheel
    public static void moveThreeSpaces() {
        // @athuor Sarim Siddiqui
        // this method will move the player 3 spaces forward
        System.out.println("\nYou have moved 3 spaces foward from your current position!");
    }

    public static void moveThreeSpaces1() {
        // @athuor Sarim Siddiqui
        gameBoard.totalSpace = gameBoard.totalSpace + player.space + 3;
    }

    public static void moveBackThreeSpaces() {
        // @athuor Sarim Siddiqui
        // this method will move the player 3 spaces backwards
        System.out.println("\nYou have moved 3 spaces backward from your current position!");
        
        gameBoard.totalSpace = gameBoard.totalSpace + player.space - 3;

        System.out.println("Your new position is " + gameBoard.totalSpace + "!");
        System.out.println("\nSorry...");
    }

    // This 3 methods will be called if player lands on jailFreeCard Slot
    public static void jailFreeCard() {
        // @athuor Sarim Siddiqui
        // this method will be a pass for player 1 and 2 to get out of jail
        System.out.println("\nYou have won a free pass to leave jail cell anytime!");
        System.out.println("You only can use this pass, when your in jail!");
    }

    public static void jailFreeCardPlayer1() {
        // @athuor Sarim Siddiqui
        // Player 1 free jail pass
        if(player.space == 8) {
            System.out.println("\nYou have moved 1 space forward!");
            player.space = player.space + 1;
        } else {
            System.out.println("\nSorry, you can't use this pass yet");
        }
    }

    public static void jailFreeCardPlayer2() {
        // @athuor Sarim Siddiqui
        // Player 2 free jail pass
        if(player2.space == 8) {
            System.out.println("\nYou have moved 1 space forward!");
            player2.space = player2.space + 1;
        } else {
            System.out.println("\nSorry, you can't use this pass yet");
        }
    }

    // This 3 methods will be called if player lands on raffelCard Slot
    public static void raffelCard() {
        // @athuor Sarim Siddiqui
        // This object will generate random amount of money
        int raffelCardMoney2 = rnd.nextInt(500, 5000);

        raffelCardMoney = raffelCardMoney2;

        // This method will let the player know, how much he is winning 
        System.out.println("\nCongrats, You have won a raffel card!");
        System.out.println("You have won $" + raffelCardMoney + "!");
    }

    // this raffel card method will be called, when player 1 or 2 lands on this slot
    public static void raffelCard1() {
        // @athuor Sarim Siddiqui
        // This method is for player 1, if he wins a raffel card
        player.playersMoney = player.playersMoney + raffelCardMoney;

        System.out.println("\nNow You have: $" + player.playersMoney + " In your account");
    }

    public static void raffelCard2() {
        // @athuor Sarim Siddiqui
        // This method is for player 2, if he wins a raffel card
        player2.playersMoney = player2.playersMoney + raffelCardMoney;

        System.out.println("\nNow You have: $" + player2.playersMoney + " In your account");
    }

    // This 3 methods will be called if player lands on yourBirthday Slot
    public static void yourBirthday() {
        // @athuor Sarim Siddiqui
        // Today is your birthday! All other players are obligated to give you money
        System.out.println("\nToday is your birthday!");
        System.out.println("All other players are obligated to give you money!");
        System.out.println("The other player owes you " + String.format("$%.2f", chanceWheel.birthdayMoney).replace("$0.", "$.") + "!");
    }

    // this birthdayMoney method will only be called when the player 1 or 2 land son this slot
    public static void birthdayMoney1() {
        // @athuor Sarim Siddiqui
        // Player 1 gives Player 2 money
        // this will subtract the money from players 1 account
        player.playersMoney = player.playersMoney - chanceWheel.birthdayMoney;
        // this will add money to players 2 account
        player2.playersMoney = player2.playersMoney + chanceWheel.birthdayMoney;
        System.out.println(showPlayer1Money);
        System.out.println(showPlayer2Money);
    }
    
    public static void birthdayMoney2() {
        // @athuor Sarim Siddiqui
        // this will subtract the money from players 2 account
        player2.playersMoney = player2.playersMoney - chanceWheel.birthdayMoney;
        // this will add money to players 1 account
        player.playersMoney = player.playersMoney + chanceWheel.birthdayMoney;            
    }

    // This 3 methods will be called if player lands on advanceToFreeSpot Slot
    public static void advanceToFreeSpot() {
        // @athuor Sarim Siddiqui
        // this method will congrats the player to the free spot
        System.out.println("\nYou have moved to the free spot on the board!");
        System.out.println("CONGRATS!");
    }

    // this advanceToFreeSpot method will only be called when the player 1 or 2 land on this slot
    public static void advanceToFreeSpot1() {
        // @athuor Sarim Siddiqui
        // Player 1 advance to the free spot
        if(player.space == 4) {
            player.space = player.space + 12;
        } else if(player2.space == 10) {
            player.space = player.space + 6;
        } else {
            System.out.println("\nError");
        }
    }

    public static void advanceToFreeSpot2() {
        // @athuor Sarim Siddiqui
        // Player 1 advance to the free spot
        if(player2.space == 4) {
            player.space = player2.space + 12;
        } else if(player2.space == 10) {
            player2.space = player2.space + 6;
        } else {
            System.out.println("\nError");
        }
    }

    // This 1 methods will be called if player lands on freeSpinForGaintCasinoWheel Slot
    public static void freeSpinForGaintCasinoWheel() {
        System.out.println("test 7");
    }

    // This 1 methods will be called if player lands on buyingAnyObjects Slot
    public static void buyingAnyObjects() {
        System.out.println("test 8");
    }
    
    
    // This 3 methods will be called if player lands on goToJail Slot
    public static void goToJail() {
        // @athuor Sarim Siddiqui
        // Go directly to jail for illegal gambling
        System.out.println("\nYou have been sent back to jail for illegal gambling...");
        System.out.println("Sad to see you go :(");
    }

    // this goToJail method will only be called when the player 1 or 2 land on this slot
    public static void goToJail1() {
        // @athuor Sarim Siddiqui
        // Player 1 sent to jail
        if(player.space == 4) {
            player.space = player.space + 4;
        } else if(player2.space == 10) {
            player.space = player.space - 2;
        } else {
            System.out.println("\nError");
        }
    }

    public static void goToJail2() {
        // @athuor Sarim Siddiqui
        // Player 2 sent to jail
        if(player2.space == 4) {
            player2.space = player2.space + 4;
        } else if(player2.space == 10) {
            player2.space = player2.space - 2;
        } else {
            System.out.println("\nError");
        }
    }

    // This 3 methods will be called if player lands on youLost Slot
    public static void youLost() {
        // @athuor Sarim Siddiqui
        // You lost a game to the other player, pay them random amount
        System.out.println("\nYou have lost a bet, you got to pay your opponent a random amount of money!");
        System.out.println("Range: Any Amount between $1000 - $10000!");
        System.out.println("You owe the other player " + String.format("$%.2f", chanceWheel.payOpponent).replace("$0.", "$.") + "!");
    }

    public static void youLost1() {
        // @athuor Sarim Siddiqui
        // This method is called when player 1 loses
        player.playersMoney = player.playersMoney - chanceWheel.payOpponent;
        player2.playersMoney = player2.playersMoney + chanceWheel.payOpponent;
        System.out.println(showPlayer1Money);
        System.out.println(showPlayer2Money);
    }

    public static void youLost2() {
        // @athuor Sarim Siddiqui
        // This method is called when player 2 loses
        player2.playersMoney = player2.playersMoney - chanceWheel.payOpponent;
        System.out.println(showPlayer1Money);
        System.out.println(showPlayer2Money);
    }
    
    // This 3 methods will be called if player lands on youHaveBeenFined Slot
    public static void youHaveBeenFined() {
        // @athuor Sarim Siddiqui
        // You have been fined for excessive gambling!
        System.out.println("\nYou have been fined for excessive gambling...");
        System.out.println("Fine: " + String.format("$%.2f", chanceWheel.userGettingFined).replace("$0.", "$."));
    }

    // this GettingFined method will only be called when the player 1 land on this slot
    public static void gettingFined1() {
        // @athuor Sarim Siddiqui
        // This method will be called if player 1 get fined
        player.playersMoney = player.playersMoney - chanceWheel.userGettingFined;
        System.out.println(showPlayer1Money);
    }

    // this GettingFined method will only be called when the player 2 land on this slot
    public static void gettingFined2() {
        // @athuor Sarim Siddiqui
        // This method will be called if player 2 get fined
        player2.playersMoney = player2.playersMoney - chanceWheel.userGettingFined;
        System.out.println(showPlayer2Money);
    }

    // This 1 methods will be called if player lands on casinopolyPenaltySpace Slot
    public static void casinopolyPenaltySpace() {
        // Go directly to the Casinopoly penalty space
        System.out.println("test 12");
    }

    // This 3 methods will be called if player lands on playerChoosesToMoveYou Slot
    public static void playerChoosesToMoveYou() {
        // @athuor Sarim Siddiqui
        // Player decides how much another player can move
        System.out.println("\nAnother player has to decide, how much you have to move backwards!");
        System.out.println("Player only can move another player between (1 - 3) spaces!");
    }

    public static void playerMove1() {
        // @athuor Sarim Siddiqui
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
        // @athuor Sarim Siddiqui
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

    // This 3 methods will be called if player lands on movingPrevelges Slot
    public static void movingPrevelges() {
        // @athuor Sarim Siddiqui
        // Player moving prevelges are gone until another player dont move more then 2 spaces
        System.out.println("\nYour moving prevelges are gone until another player dont move more then 2 spaces!");
        System.out.println("HAVE FUN!");
    }

    public static void movingPrevelges1() {
        // @athuor Sarim Siddiqui
        // Player 1

    }

    public static void movingPrevelges2() {
        // @athuor Sarim Siddiqui
        // Player 2

    }
}