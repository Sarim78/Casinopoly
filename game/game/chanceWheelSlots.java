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

public class chanceWheelSlots {
        // Variables
        public static int raffelCardMoney;
        public static int userGettingFined;
        
        // Creating Objects  
        static Random rnd = new Random();
        static Scanner in = new Scanner(System.in);
    
        // Method For Slots In The Chances Of Wheel
        public static void moveThreeSpaces() {
            // this method will move the player 3 spaces forward
            System.out.println("\nYou have moved 3 spaces foward from your current position!");
            
            gameBoard.totalSpace = gameBoard.totalSpace + player.space + 3;
    
            System.out.println("Your new position is " + gameBoard.totalSpace + "!");
            System.out.println("\nCONGRATS!");
        }
    
        public static void moveBackThreeSpaces() {
            // this method will move the player 3 spaces backwards
            System.out.println("\nYou have moved 3 spaces backward from your current position!");
            
            gameBoard.totalSpace = gameBoard.totalSpace + player.space - 3;
    
            System.out.println("Your new position is " + gameBoard.totalSpace + "!");
            System.out.println("\nSorry...");
        }
    
        // This 3 methods will be called if player lands on jailFreeCard Slot
        public static void jailFreeCard() {
            // this method will be a pass for player 1 and 2 to get out of jail
            System.out.println("\nYou have won a free pass to leave jail cell anytime!");
            System.out.println("You only can use this pass, when your in jail!");
        }
    
        public static void jailFreeCardPlayer1() {
            // Player 1 free jail pass
            if(player.space == 8) {
                System.out.println("\nYou have moved 1 space forward!");
                player.space = player.space + 1;
            } else {
                System.out.println("\nSorry, you can't use this pass yet");
            }
        }
    
        public static void jailFreeCardPlayer2() {
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
            // This object will generate random amount of money
            int raffelCardMoney2 = rnd.nextInt(500, 5000);
    
            raffelCardMoney = raffelCardMoney2;
    
            // This method will let the player know, how much he is winning 
            System.out.println("\nCongrats, You have won a raffel card!");
            System.out.println("You have won $" + raffelCardMoney + "!");
        }
    
        // this raffel card method will be called, when player 1 or 2 lands on this slot
        public static void raffelCard1() {
            // This method is for player 1, if he wins a raffel card
            player.playersMoney = player.playersMoney + raffelCardMoney;
    
            System.out.println("\nNow You have: $" + player.playersMoney + " In your account");
        }
    
        public static void raffelCard2() {
            // This method is for player 2, if he wins a raffel card
            player2.playersMoney = player2.playersMoney + raffelCardMoney;
    
            System.out.println("\nNow You have: $" + player2.playersMoney + " In your account");
        }
    
        // This 3 methods will be called if player lands on yourBirthday Slot
        public static void yourBirthday() {
            // Today is your birthday! All other players are obligated to give you money
            System.out.println("\nToday is your birthday!");
            System.out.println("All other players are obligated to give you money!");
    
            // this will tell the player range to give the money to the birthday player
            System.out.println("\nThe range the player can give your is: $1000 - $8500");
        }
    
        // this birthdayMoney method will only be called when the player 1 or 2 land son this slot
        public static void birthdayMoney1() {
            // Player 1 gives Player 2 money
            System.out.println("\nPlease Enter An Amount: ");
            int player1GivesMoney = in.nextInt();
    
            // this if statement will print, once user input the amount of money
            if(player1GivesMoney > 8500) {
                System.out.println("Sorry, you went over the limit...");
                System.out.println("The limit is $8500...");
            } else if (player1GivesMoney < 1000) {
                System.out.println("Sorry, you went under the limit...");
                System.out.println("The minimum limit is $1000...");
            } else {
                // this will subtract the money from players 1 account
                player.playersMoney = player.playersMoney - player1GivesMoney;
    
                // this will add money to players 2 account
                player2.playersMoney = player2.playersMoney + player1GivesMoney;
            }
        }
        
        public static void birthdayMoney2() {
            // Player 2 gives Player 1 money
            System.out.println("\nPlease Enter An Amount: ");
            int player2GivesMoney = in.nextInt();
    
            // this if statement will print, once user input the amount of money
            if(player2GivesMoney > 8500) {
                System.out.println("Sorry, you went over the limit...");
                System.out.println("The limit is $8500...");
            } else if (player2GivesMoney < 1000) {
                System.out.println("Sorry, you went under the limit...");
                System.out.println("The minimum limit is $1000...");
            } else {
                // this will subtract the money from players 2 account
                player2.playersMoney = player2.playersMoney - player2GivesMoney;
    
                // this will add money to players 1 account
                player.playersMoney = player.playersMoney + player2GivesMoney;            
            }
        }
    
        // This 3 methods will be called if player lands on advanceToFreeSpot Slot
        public static void advanceToFreeSpot() {
            // this method will congrats the player to the free spot
            System.out.println("\nYou have moved to the free spot on the board!");
            System.out.println("CONGRATS!");
        }
    
        // this advanceToFreeSpot method will only be called when the player 1 or 2 land on this slot
        public static void advanceToFreeSpot1() {
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
            // Go directly to jail for illegal gambling
            System.out.println("\nYou have been sent back to jail for illegal gambling...");
            System.out.println("Sad to see you go :(");
        }

        // this goToJail method will only be called when the player 1 or 2 land on this slot
        public static void goToJail1() {
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
            // You lost a game to the other player, pay them random amount
            System.out.println("\nYou have lost a bet, you got to pay your opponent a random amount of money!");
            System.out.println("Range: Any Amount between $1000 - $10000!");
        }
    
        public static void youLost1() {
            // This method is called when player 1 loses
            System.out.println("\nPlayer 1: Please pick an amount: ");
            int payOpponent = in.nextInt();
    
            if(payOpponent < 1000) {
                // If player picks an amount under $1k, it will print this statment.
                System.out.println("\nSorry, you have picked an amount over $1000.");
                System.out.println("Please pick again...");
                youLost();
    
            } else if(payOpponent > 10000) {
                // If player picks an amount under $10k, it will print this statment.
                System.out.println("\nSorry, you have picked an amount under $10000.");
                System.out.println("Please pick again...");
                youLost();
    
            } else {
                // New Scanner Object
                Scanner confrimPay = new Scanner(System.in);
    
                // If player picks an amount over $1k, it will print this statment.
                System.out.println("\nYou sure you wanna pay your opponent: $" + payOpponent + "?");
                System.out.println("To confrim press (Y/N): ");
                String userConfrimPay = confrimPay.nextLine();
    
                if(userConfrimPay.equals("Y") || userConfrimPay.equals("y")) {
                    // If player press (Y), it will print this statment
                    System.out.println("\nYou had payed: $" + payOpponent);
        
                    player.playersMoney = player.playersMoney - payOpponent;
                    player2.playersMoney = player2.playersMoney + payOpponent;
        
                    System.out.println("\nPlayer 1: Your current Balance In Your Account is: $" + player.playersMoney);
                    System.out.println("\nPlayer 1: Your current Balance In Your Account is: $" + player2.playersMoney);
                } else if(userConfrimPay.equals("N") || userConfrimPay.equals("n")) {
                    // If player press (N), it will print this statment
                    System.out.println("\nSIKE, You still gotta pay your opponent!");
    
                    System.out.println("\n$" + payOpponent + " has been withdrawn from your account!");
        
                    player.playersMoney = player.playersMoney - payOpponent;
                    player2.playersMoney = player2.playersMoney + payOpponent;
        
                    System.out.println("\nPlayer 1: Your current Balance In Your Account is: $" + player.playersMoney);
                    System.out.println("\nPlayer 1: Your current Balance In Your Account is: $" + player2.playersMoney);
                }
            }
        }
    
        public static void youLost2() {
            // This method is called when player 2 loses
            System.out.println("\nPlayer 2: Please pick an amount: ");
            int payOpponent = in.nextInt();
    
            if(payOpponent < 1000) {
                // If player picks an amount under $1k, it will print this statment.
                System.out.println("\nSorry, you have picked an amount over $1000.");
                System.out.println("Please pick again...");
                youLost();
    
            } else if(payOpponent > 10000) {
                // If player picks an amount under $10k, it will print this statment.
                System.out.println("\nSorry, you have picked an amount under $10000.");
                System.out.println("Please pick again...");
                youLost();
    
            } else {
                // New Scanner Object
                Scanner confrimPay = new Scanner(System.in);
    
                // If player picks an amount over $1k, it will print this statment.
                System.out.println("\nYou sure you wanna pay your opponent: $" + payOpponent + "?");
                System.out.println("To confrim press (Y/N): ");
                String userConfrimPay = confrimPay.nextLine();
    
                if(userConfrimPay.equals("Y") || userConfrimPay.equals("y")) {
                    // If player press (Y), it will print this statment
                    System.out.println("\nYou had payed: $" + payOpponent);
        
                    player.playersMoney = player.playersMoney - payOpponent;
                    player2.playersMoney = player2.playersMoney + payOpponent;
        
                    System.out.println("\nPlayer 1: Your current Balance In Your Account is: $" + player.playersMoney);
                    System.out.println("\nPlayer 2: Your current Balance In Your Account is: $" + player2.playersMoney);
                } else if(userConfrimPay.equals("N") || userConfrimPay.equals("n")) {
                    // If player press (N), it will print this statment
                    System.out.println("\nSIKE, You still gotta pay your opponent!");
    
                    System.out.println("\n$" + payOpponent + " has been withdrawn from your account!");
        
                    player.playersMoney = player.playersMoney - payOpponent;
                    player2.playersMoney = player2.playersMoney + payOpponent;
        
                    System.out.println("\nPlayer 1: Your current Balance In Your Account is: $" + player.playersMoney);
                    System.out.println("\nPlayer 2: Your current Balance In Your Account is: $" + player2.playersMoney);
                }
            }
        }
        
        // This 3 methods will be called if player lands on youHaveBeenFined Slot
        public static void youHaveBeenFined() {
            // Creating object for random library for this method.
            Random fined = new Random();
    
            userGettingFined = fined.nextInt(500, 5000);
    
            // You have been fined for excessive gambling!
            System.out.println("\nYou have been fined for excessive gambling...");
            System.out.println("Fine: $" + userGettingFined);
        }
    
        // this GettingFined method will only be called when the player 1 or 2 land on this slot
        public static void gettingFined1() {
            // This method will be called if player 1 get fined
            System.out.println("\nPlayer 1: Would You Like To Pay Your Fine? (Y/N): ");
            String userInput = in.nextLine();
    
            if(userInput.equals("Y") || userInput.equals("y")) {
                // If player press (Y), it will print this statment
                System.out.println("\nYou fined as been paid!");
    
                player.playersMoney = player.playersMoney - userGettingFined;
    
                System.out.println("\nYour current Balance In Your Account is: $" + player.playersMoney);
    
            } else {
                // If player press any key, it will print this statment
                System.out.println("\nSIKE, You still gotta pay your fine!");
    
                System.out.println("$" + userGettingFined + " has been withdrawn from your account!");
    
                player.playersMoney = player.playersMoney - userGettingFined;
    
                System.out.println("\nYour current Balance In Your Account is: $" + player.playersMoney);
            }
        }
    
        public static void gettingFined2() {
            // This method will be called if player 2 get fined
            System.out.println("\nPlayer 2: Would You Like To Pay Your Fine? (Y/N): ");
            String userInput = in.nextLine();
    
            if(userInput.equals("Y") || userInput.equals("y")) {
                // If player press (Y), it will print this statment
                System.out.println("\nYou fined as been paid!");
    
                player2.playersMoney = player2.playersMoney - userGettingFined;
    
                System.out.println("\nYour current Balance In Your Account is: $" + player.playersMoney);
    
            } else {
                // If player press any key, it will print this statment
                System.out.println("\nSIKE, You still gotta pay your fine!");
    
                System.out.println("$" + userGettingFined + " has been withdrawn from your account!");
    
                player2.playersMoney = player2.playersMoney - userGettingFined;
    
                System.out.println("\nYour current Balance In Your Account is: $" + player.playersMoney);
            }
        }
    
        // This 1 methods will be called if player lands on casinopolyPenaltySpace Slot
        public static void casinopolyPenaltySpace() {
            // Go directly to the Casinopoly penalty space
            System.out.println("\nYou have won: Free spin of Casinopoly Penalty!");
            penaltyWheel.wheelOfPenalty();
        }
}