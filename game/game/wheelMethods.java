package game;

// Importing Libraries 
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

// Importing Files 
import src.player;
import src.player2;

/**
 * wheel methods
 * @author adil
 * @author Sarim Siddiqui
 */

public class wheelMethods {

    // Creating Objects
     
    Random rnd = new Random();
 
    player player = new player();

    player2 player2 = new player2();

    // Creating Variables

    int raffelCardMoney;
    int raffelCardMoney2;

    String showPlayer1Money = ("\nPlayer 1: Your current Balance In Your Account is: $" + String.format("$%.2f", player.playersMoney).replace("$0.", "$."));
    String showPlayer2Money = ("\nPlayer 2: Your current Balance In Your Account is: $" + String.format("$%.2f", player2.playersMoney).replace("$0.", "$."));

    int player1Decides;
    int player2Decides;

    int blackjackSpace1;
    int blackjackSpace2;

    int blackjackDistance1;
    int blackjackDistance2;

    int cardgameSpace1;
    int cardgameSpace2;

    int cardgameDistance1;
    int cardgameDistance2;

    int rouletteSpace1;
    int rouletteSpace2;

    int rouletteDistance1;
    int rouletteDistance2;

    int slotsSpace1;
    int slotsSpace2;

    int slotsDistance1;
    int slotsDistance2;

    int smallestBlackjack;
    int smallestcardGame;
    int smallestRoulette;
    int smallestSlots;
    int smallest;

    double birthdayMoney;

    double payOpponent;

    double userGettingFined;

    double loseMoney;

    double winMoney;

    double takeMoney;

    double moneyTaken;

    int powerup;

    // Creating Methods
    
    public void moveThreeSpaces() {
        // @Author Sarim 
        // this method will move the player 3 spaces forward
        System.out.println("\nYou have moved 3 spaces foward from your current position!");
    }

    public void moveThreeSpaces1() {
        // @Author Sarim 
        player.totalSpace = player.totalSpace + player.space + 3;
    }

    public void moveBackThreeSpaces() {
        // @Author Sarim 
        // this method will move the player 3 spaces backwards
        System.out.println("\nYou have moved 3 spaces backward from your current position!");
        System.out.println("Sorry...");
        player.totalSpace = player.totalSpace + player.space - 3;
    }

    // This 3 methods will be called if player lands on jailFreeCard Slot
    public void jailFreeCard() {
        // @Author Sarim 
        // this method will be a pass for player 1 and 2 to get out of jail
        System.out.println("\nYou have won a free pass to leave jail cell anytime!");
        System.out.println("You only can use this pass, when your in jail!");
    }

    public void jailFreeCardPlayer1() {
        // @Author Sarim 
        // Player 1 free jail pass 
        if(player.space == 8) {
            System.out.println("\nYou have moved 1 space forward!");
            player.space = player.space + 1;
        } else {
            System.out.println("\nSorry, you can't use this pass yet");
        }
    }

    public void jailFreeCardPlayer2() {
        // @Author Sarim 
        // Player 2 free jail pass
        if(player2.space == 8) {
            System.out.println("\nYou have moved 1 space forward!");
            player2.space = player2.space + 1;
        } else {
            System.out.println("\nSorry, you can't use this pass yet");
        }
    }

    // This 3 methods will be called if player lands on raffelCard Slot
    public void raffelCard() {
        // @Author Sarim 
        // This object will generate random amount of money
        raffelCardMoney2 = rnd.nextInt(500, 5000);

        raffelCardMoney = raffelCardMoney2;

        // This method will let the player know, how much he is winning 
        System.out.println("\nCongrats, You have won a raffel card!");
        System.out.println("You have won $" + raffelCardMoney + "!");
    }

    // this raffel card method will be called, when player 1 or 2 lands on this slot
    public void raffelCard1() {
        // @Author Sarim 
        // This method is for player 1, if he wins a raffel card
        player.playersMoney = player.playersMoney + raffelCardMoney;

        System.out.println("\nNow You have: $" + player.playersMoney + " In your account");
    }

    public void raffelCard2() {
        // @Author Sarim 
        // This method is for player 2, if he wins a raffel card
        player2.playersMoney = player2.playersMoney + raffelCardMoney;

        System.out.println("\nNow You have: $" + player2.playersMoney + " In your account");
    }

    // This 3 methods will be called if player lands on yourBirthday Slot
    public void yourBirthday() {
        // @Author Sarim 
        // Today is your birthday! All other players are obligated to give you money
        birthdayMoney = rnd.nextDouble(1000,10000);
        System.out.println("\nToday is your birthday!");
        System.out.println("All other players are obligated to give you money!");
        System.out.println("The other player owes you " + String.format("$%.2f", birthdayMoney).replace("$0.", "$.") + "!");
    }

    // this birthdayMoney method will only be called when the player 1 or 2 land son this slot
    public void birthdayMoney1() {
        // @Author Sarim 
        // Player 1 gives Player 2 money
        // this will subtract the money from players 1 account
        player.playersMoney = player.playersMoney - birthdayMoney;
        // this will add money to players 2 account
        player2.playersMoney = player2.playersMoney + birthdayMoney;
        System.out.println(showPlayer1Money);
        System.out.println(showPlayer2Money);
    }
    
    public void birthdayMoney2() {
        // @Author Sarim 
        // this will subtract the money from players 2 account
        player2.playersMoney = player2.playersMoney - birthdayMoney;
        // this will add money to players 1 account
        player.playersMoney = player.playersMoney + birthdayMoney;            
    }

    // This 3 methods will be called if player lands on advanceToFreeSpot Slot
    public void advanceToFreeSpot() {
        // @Author Sarim 
        // this method will congrats the player to the free spot
        System.out.println("\nYou have moved to the free spot on the board!");
        System.out.println("CONGRATS!");
    }

    // this advanceToFreeSpot method will only be called when the player 1 or 2 land on this slot
    public void advanceToFreeSpot1() {
        // @Author Sarim 
        // Player 1 advance to the free spot
        if(player.space == 4) {
            player.space = player.space + 12;
        } else if(player2.space == 10) {
            player.space = player.space + 6;
        } else {
            System.out.println("\nError");
        }
    }

    public void advanceToFreeSpot2() {
        // @Author Sarim 
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
    public void freeSpinForGaintCasinoWheel() {
        System.out.println("test 7");
    }

    // This 1 methods will be called if player lands on buyingAnyObjects Slot
    public void buyingAnyObjects() {
        System.out.println("test 8");
    }
    
    
    // This 3 methods will be called if player lands on goToJail Slot
    public void goToJail() {
        // @Author Sarim 
        // Go directly to jail for illegal gambling
        System.out.println("\nYou have been sent back to jail for illegal gambling...");
        System.out.println("\nYou do not get money for crossing GO");
        System.out.println("Sad to see you go :(");
    }

    // this goToJail method will only be called when the player 1 or 2 land on this slot
    public void goToJail1() {
        // @Author Sarim 
        // Player 1 sent to jail
        if(player.space == 4) { 
            player.space = player.space + 4;
        } else if(player2.space == 10) {
            player.space = player.space - 2;
        } else {
            System.out.println("\nError");
        }
    }

    public void goToJail2() {
        // @Author Sarim 
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
    public void youLost() {
        // You lost a game to the other player, pay them random amount
        payOpponent = rnd.nextDouble(1000,10000);
        System.out.println("\nYou have lost a bet, you got to pay your opponent a random amount of money!");
        System.out.println("Range: Any Amount between $1000 - $10000!");
        System.out.println("You owe the other player " + String.format("$%.2f", payOpponent).replace("$0.", "$.") + "!");
    }

    public void youLost1() {
        // This method is called when player 1 loses
        player.playersMoney = player.playersMoney - payOpponent;
        player2.playersMoney = player2.playersMoney + payOpponent;
        System.out.println(showPlayer1Money);
        System.out.println(showPlayer2Money);
    }

    public void youLost2() {
        // This method is called when player 2 loses
        player2.playersMoney = player2.playersMoney - payOpponent;
        System.out.println(showPlayer1Money);
        System.out.println(showPlayer2Money);
    }

    public void loseMoney() {
        loseMoney = rnd.nextDouble(1000,20000);
        System.out.println("\nYou lost " + String.format("$%.2f", loseMoney).replace("$0.", "$.") + "!");
    }

    public void loseMoney1() {
        player.playersMoney = player.playersMoney - loseMoney;
        System.out.println(showPlayer1Money);
    }

    public void loseMoney2() {
        player2.playersMoney = player2.playersMoney - loseMoney;
        System.out.println(showPlayer2Money);
    }

    public void winMoney() {
        winMoney = rnd.nextDouble(1000,20000);
        System.out.println("\nYou won " + String.format("$%.2f", winMoney).replace("$0.", "$.") + "!");
    }

    public void winMoney1() {
        player.playersMoney = player.playersMoney + winMoney;
        System.out.println(showPlayer1Money);
    }

    public void winMoney2() {
        player2.playersMoney = player2.playersMoney + winMoney;
        System.out.println(showPlayer2Money);
    }

    public void takeMoney() {
        takeMoney = rnd.nextDouble(1000,10000);
        System.out.println("\nThe other player owes you " + String.format("$%.2f", takeMoney).replace("$0.", "$.") + "!");
    }

    public void takeMoney1() {
        player.playersMoney = player.playersMoney + takeMoney;
        player2.playersMoney = player2.playersMoney - takeMoney;
        System.out.println(showPlayer1Money);
        System.out.println(showPlayer2Money);
    }

    public void takeMoney2() {
        player.playersMoney = player.playersMoney - takeMoney;
        player2.playersMoney = player2.playersMoney + takeMoney;
        System.out.println(showPlayer2Money);
        System.out.println(showPlayer1Money);
    }

    public void moneyTaken() {
        moneyTaken = rnd.nextDouble(1000,10000);
        System.out.println("\nYou owe the other player " + String.format("$%.2f", moneyTaken).replace("$0.", "$.") + "!");
    }

    public void moneyTaken1() {
        player.playersMoney = player.playersMoney - takeMoney;
        player2.playersMoney = player2.playersMoney + takeMoney;
        System.out.println(showPlayer1Money);
        System.out.println(showPlayer2Money);
    }

    public void moneyTaken2() {
        player.playersMoney = player.playersMoney + takeMoney;
        player2.playersMoney = player2.playersMoney - takeMoney;
        System.out.println(showPlayer2Money);
        System.out.println(showPlayer1Money);
    }
    
    // This 3 methods will be called if player lands on youHaveBeenFined Slot
    public void youHaveBeenFined() {
        // @Author Sarim 
        // You have been fined for excessive gambling!
        userGettingFined = rnd.nextDouble(500, 5000);
        System.out.println("\nYou have been fined for excessive gambling...");
        System.out.println("Fine: " + String.format("$%.2f", userGettingFined).replace("$0.", "$."));
    }

    // this GettingFined method will only be called when the player 1 land on this slot
    public void gettingFined1() {
        // @Author Sarim 
        // This method will be called if player 1 get fined
        player.playersMoney = player.playersMoney - userGettingFined;
        System.out.println(showPlayer1Money);
    }

    // this GettingFined method will only be called when the player 2 land on this slot
    public void gettingFined2() {
        // @Author Sarim 
        // This method will be called if player 2 get fined
        player2.playersMoney = player2.playersMoney - userGettingFined;
        System.out.println(showPlayer2Money);
    }

    // This 1 methods will be called if player lands on casinopolyPenaltySpace Slot
    public void casinopolyPenaltySpace() {
        // Go directly to the Casinopoly penalty space
        System.out.println("test 12");
    }

    // This 3 methods will be called if player lands on playerChoosesToMoveYou Slot
    public void playerChoosesToMoveYou() {
        // Player decides how much another player can move
        System.out.println("\nThe other player has won a control opponent powerup! This means they can move you 1-3 spaces at any time (one time use).");
        //give other player control opponent powerup
    }

    public void playerMove1() {
        // Player 1
        System.out.println("\nPlayer 2: Please enter the amount, you want Player 1 to move!");
        System.out.println("Player 2: Please enter the amount: ");
        Scanner in = new Scanner(System.in);
        player2Decides = in.nextInt();

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
            in.close();
        }
    }

    public void playerMove2() {
        // Player 2
        System.out.println("\nPlayer 1: Please enter the amount, you want Player 1 to move!");
        System.out.println("Player 1: Please enter the amount: ");
        Scanner in = new Scanner(System.in);
        player1Decides = in.nextInt();

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
        in.close();
    }

    // This 3 methods will be called if player lands on movingPrevelges Slot
    public void movingPrevelges() {
        // @Author Sarim 
        // Player moving prevelges are gone until another player dont move more then 2 spaces
        System.out.println("\nYou have lost one turn!");
        System.out.println("HAVE FUN!");
    }

    public void movingPrevelges1() {
        // @Author Sarim 
        // Player 1

    }

    public void movingPrevelges2() {
        // @Author Sarim 
        // Player 2

    }
    

    public void advanceToNearestGame() {
        System.out.println("Advance to the nearest game!");
        blackjackSpace1 = 6;
        blackjackSpace2 = 13;
        blackjackDistance1 = blackjackSpace1 - player.totalSpace;
        blackjackDistance2 = blackjackSpace2 - player.totalSpace;
        cardgameSpace1 = 7;
        cardgameSpace2 = 18;
        cardgameDistance1 = cardgameSpace1 - player.totalSpace;
        cardgameDistance2 = cardgameSpace2 - player.totalSpace;
        rouletteSpace1 = 3;
        rouletteSpace2 = 12;
        rouletteDistance1 = rouletteSpace1 - player.totalSpace;
        rouletteDistance2 = rouletteSpace2 - player.totalSpace;
        slotsSpace1 = 5;
        slotsSpace2 = 9;
        slotsDistance1 = slotsSpace1 - player.totalSpace;
        slotsDistance2 = slotsSpace2 - player.totalSpace;
        if (blackjackDistance1 < 0) {
            blackjackDistance1 = 100;
        } else if (blackjackDistance2 < 0) {
            blackjackDistance2 = 100;
        } else if (cardgameDistance1 < 0) {
            cardgameDistance1 = 100;
        } else if (cardgameDistance2 < 0) {
            cardgameDistance2 = 100;
        } else if (rouletteDistance1 < 0) {
            rouletteDistance1 = 100;
        } else if (rouletteDistance2 < 0) {
            rouletteDistance2 = 100;
        } else if (slotsDistance1 < 0) {
            slotsDistance1 = 100;
        } else if (slotsDistance2 < 0) {
            slotsDistance2 = 100;
        }
        smallestBlackjack = Math.min(blackjackDistance1, blackjackDistance2);
        smallestcardGame = Math.min(cardgameDistance1, cardgameDistance2);
        smallestRoulette = Math.min(rouletteDistance1, rouletteDistance2);
        smallestSlots = Math.min(slotsDistance1, slotsDistance2);
        smallest = Math.min(smallestBlackjack, Math.min(smallestcardGame, Math.min(smallestRoulette, smallestSlots)));
        player.totalSpace = smallest;
    }

    public void powerUp() {
        powerup = rnd.nextInt(1,7);
        if (powerup == 1) {
            System.out.println("You won the advance spaces powerup! It will be added to your inventory");
            //give advance spaces powerup
        } else if (powerup == 2) {
            System.out.println("You won the re-roll powerup! It will be added to your inventory");
            //give reroll powerup
        } else if (powerup == 3) {
            System.out.println("You won the refuse rent powerup! It will be added to your inventory");
            //give refuse rent powerup
        } else if (powerup == 4) {
            System.out.println("You won the reverse rent powerup! It will be added to your inventory");
            //give reverse rent powerup
        } else if (powerup == 5) {
            System.out.println("You won the re-spin wheel powerup! It will be added to your inventory");
            //give respin wheel powerup
        } else if (powerup == 6) {
            System.out.println("You won the control opponent powerup! It will be added to your inventory");
            //give control opponent powerup
        } else if (powerup == 7) {
            System.out.println("You won the jail sentence powerup! It will be added to your inventory");
            //give jail sentence powerup
        }
    }

    public void advanceStart() {
        System.out.println("\nAdvance to START!");
        player.totalSpace = 1;
    }
}