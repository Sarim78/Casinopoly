package game2;

// Importing Libraries 
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

// Importing Files 
import src.player;
import src.player2;
import src.inventory1;
import src.inventory2;

/**
 * wheel methods
 * @author adil
 * @author Sarim Siddiqui
 */

public class wheelMethods2 {

    // Creating Objects
     
    Random rnd = new Random();
 
    player player = new player();

    player2 player2 = new player2();

    inventory1 inventory1 = new inventory1();

    inventory2 inventory2 = new inventory2();

<<<<<<< HEAD
    jail2 Jail = new jail2();

    startAndGo2 startAndGo = new startAndGo2();
=======
    jail2 Jail2 = new jail2();

    startAndGo2 startAndGo2 = new startAndGo2();
>>>>>>> 8deca5c680e252a9ef0ca080de4c8d3a67f54282

    // Creating Variables

    int raffelCardMoney;
    int raffelCardMoney2;

    int player1Decides;
    int player2Decides;

    //blackjack space #
    int blackjackSpace1;
    int blackjackSpace2;

    //figuring out blackjack distance
    int blackjackDistance1;
    int blackjackDistance2;

    //cardgame space #
    int cardgameSpace1;
    int cardgameSpace2;

    //figuring out cardgame distance
    int cardgameDistance1;
    int cardgameDistance2;

    //roulette space #
    int rouletteSpace1;
    int rouletteSpace2;

    //figuring out roulette distance
    int rouletteDistance1;
    int rouletteDistance2;

    //slots space #
    int slotsSpace1;
    int slotsSpace2;

    //figuring out slots distance
    int slotsDistance1;
    int slotsDistance2;

    //finding the smallest of each game, then all combined
    int smallestBlackjack;
    int smallestcardGame;
    int smallestRoulette;
    int smallestSlots;
    int smallest;

    double birthdayMoney;

    double payOpponent; //money for losing game to other player

    double userGettingFined;

    double loseMoney; //money for when player loses money

    double winMoney; //money for when player wins money

    double takeMoney; //money for when player is owed money from opponent

    double moneyTaken; //money for when player owes opponent money

    int powerup; //random number to generate a powerup

    // Creating Methods
    
    public void moveThreeSpaces() {
        // @Author Sarim 
        // this method will move the player 3 spaces forward
        System.out.println("\nYou have moved 3 spaces foward from your current position!");
        src.player2.totalSpace = src.player2.totalSpace + 3;
    }

    public void moveBackThreeSpaces() {
        // @Author Sarim 
        // this method will move the player 3 spaces backwards
        System.out.println("\nYou have moved 3 spaces backward from your current position!");
        System.out.println("Sorry...");
        src.player2.totalSpace = src.player2.totalSpace - 3;
    }

    // This 3 methods will be called if player lands on jailFreeCard Slot
    public void jailFreeCard() {
        // @Author Sarim 
        // this method will be a pass for player 1 and 2 to get out of jail
        System.out.println("\nYou have won a free pass to leave jail cell anytime!");
        System.out.println("You only can use this pass, when your in jail!");
        inventory2.getOutOfJailFreeCard = inventory2.getOutOfJailFreeCard + 1;
    }

    // This 3 methods will be called if player lands on raffelCard Slot
    public void raffelCard() {
        // @author Sarim 
        // This object will generate random amount of money
        raffelCardMoney = rnd.nextInt(500, 5000);

        // This method will let the player know, how much he is winning 
        System.out.println("\nCongrats, You have won a raffel card!");
        System.out.println("You have won $" + raffelCardMoney + "!");
        raffelCard2();
    }

    // this raffel card method will be called, when player 1 or 2 lands on this slot
    public void raffelCard2() {
        // @Author Sarim 
        // This method is for player 2, if he wins a raffel card
        src.player2.gameEarnings = src.player2.gameEarnings + raffelCardMoney;
        player2.bankAccount();
    }

    // This 3 methods will be called if player lands on yourBirthday Slot
    public void yourBirthday() {
        // @Author Sarim 
        // Today is your birthday! All other players are obligated to give you money
        birthdayMoney = rnd.nextDouble(1000,10000);
        System.out.println("\nToday is your birthday!");
        System.out.println("All other players are obligated to give you money!");
        System.out.println("The other player owes you " + String.format("$%.2f", birthdayMoney).replace("$0.", "$.") + "!");
        birthdayMoney2();
    }

    // this birthdayMoney method will only be called when the player 1 or 2 land son this slot
    public void birthdayMoney2() {
        // @Author Sarim 
        // Player 1 gives Player 2 money
        // this will subtract the money from players 1 account
        src.player2.gameEarnings = src.player2.gameEarnings + birthdayMoney;
        // this will add money to players 2 account
        src.player.gameEarnings = src.player.gameEarnings - birthdayMoney;
        player.bankAccount();
        player2.bankAccount();
    }

    // This 3 methods will be called if player lands on advanceToFreeSpot Slot
    public void advanceToFreeSpot() {
        // @Author Sarim 
        // this method will congrats the player to the free spot
        System.out.println("\nYou have moved to the free spot on the board!");
        System.out.println("CONGRATS!");
        advanceToFreeSpot2();
    }

    // this advanceToFreeSpot method will only be called when the player 1 or 2 land on this slot
    public void advanceToFreeSpot2() {
        // @Author Sarim 
        // Player 2 advance to the free spot
        src.player2.totalSpace = 11;
    }
    
    
    // This 3 methods will be called if player lands on goToJail Slot
    public void goToJail() {
        // @Author Sarim 
        // Go directly to jail for illegal gambling
        System.out.println("\nYou have been sent back to jail for illegal gambling...");
        System.out.println("\nYou do not get money for crossing GO");
        System.out.println("Sad to see you go :(");
        goToJail2();
    }

    // this goToJail method will only be called when the player 1 or 2 land on this slot
    public void goToJail2() {
        // @Author Sarim 
        // Player 2 sent to jail
        src.player2.totalSpace = 8;
        Jail2.grettingUserToJail();
    }

    // This 3 methods will be called if player lands on youLost Slot
    public void youLost() {
        //@author adil
        // You lost a game to the other player, pay them random amount
        payOpponent = rnd.nextDouble(1000,10000);
        System.out.println("\nYou have lost a bet, you got to pay your opponent a random amount of money!");
        System.out.println("Range: Any Amount between $1000 - $10000!");
        System.out.println("You owe the other player " + String.format("$%.2f", payOpponent).replace("$0.", "$.") + "!");
        youLost2();
    }

    public void youLost2() {
        //@author adil
        // This method is called when player 2 loses
        src.player2.gameEarnings = src.player2.gameEarnings - payOpponent;
        src.player.gameEarnings = src.player.gameEarnings + payOpponent;
        player.bankAccount();
        player2.bankAccount();
    }

    public void loseMoney() {
        //@author adil
        //Player loses random amount of money
        loseMoney = rnd.nextDouble(1000,20000);
        System.out.println("\nYou lost " + String.format("$%.2f", loseMoney).replace("$0.", "$.") + "!");
        loseMoney2();
    }

    public void loseMoney2() {
        //@author adil
        //Called when player 2 loses
        src.player2.gameEarnings = src.player2.gameEarnings - loseMoney;
        player2.bankAccount();
    }

    public void winMoney() {
        //@author adil
        //Player wins random amount of money
        winMoney = rnd.nextDouble(1000,20000);
        System.out.println("\nYou won " + String.format("$%.2f", winMoney).replace("$0.", "$.") + "!");
        winMoney2();
    }

    public void winMoney2() {
        //@author adil
        //Called when player 2 wins
        src.player2.gameEarnings = src.player2.gameEarnings + winMoney;
        player2.bankAccount();
    }

    public void takeMoney() {
        //@author adil
        //Player is owed random amount of money from opponent
        takeMoney = rnd.nextDouble(1000,10000);
        System.out.println("\nThe other player owes you " + String.format("$%.2f", takeMoney).replace("$0.", "$.") + "!");
        takeMoney2();
    }

    public void takeMoney2() {
        //@author adil
        //Called when player 2 wins
        src.player2.gameEarnings = src.player2.gameEarnings + takeMoney;
        src.player.gameEarnings = src.player.gameEarnings - takeMoney;
        player.bankAccount();
        player2.bankAccount();
    }

    public void moneyTaken() {
        //@author adil
        //Player owes opponent random amount of money
        moneyTaken = rnd.nextDouble(1000,10000);
        System.out.println("\nYou owe the other player " + String.format("$%.2f", moneyTaken).replace("$0.", "$.") + "!");
        moneyTaken2();
    }

    public void moneyTaken2() {
        //@author adil
        //Called when player 2 loses
        src.player2.gameEarnings = src.player2.gameEarnings - takeMoney;
        src.player.gameEarnings = src.player.gameEarnings + takeMoney;
        player.bankAccount();
        player2.bankAccount();
    }
    
    // This 3 methods will be called if player lands on youHaveBeenFined Slot
    public void youHaveBeenFined() {
        // @Author Sarim 
        // You have been fined for excessive gambling!
        userGettingFined = rnd.nextDouble(500, 5000);
        System.out.println("\nYou have been fined for excessive gambling...");
        System.out.println("Fine: " + String.format("$%.2f", userGettingFined).replace("$0.", "$."));
        gettingFined2();
    }

    // this GettingFined method will only be called when the player 1 land on this slot
    public void gettingFined2() {
        // @Author Sarim 
        // This method will be called if player 1 get fined
        src.player2.gameEarnings = src.player2.gameEarnings - userGettingFined;
        player2.bankAccount();
    }

    // This 3 methods will be called if player lands on playerChoosesToMoveYou Slot
    public void playerChoosesToMoveYou() {
        //@Author Sarim
        // Player decides how much another player can move
        System.out.println("\nThe other player has won a control opponent powerup! This means they can move you 1-3 spaces at any time (one time use).");
        inventory1.controlOpponent = inventory1.controlOpponent + 1; //give other player control opponent powerup
    }

    //powerups feature not ready
    /**
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
    } /** */

    // This 3 methods will be called if player lands on movingPrevelges Slot
    public void movingPrevelges() {
        // @Author Sarim 
        // Player moving prevelges are gone until another player dont move more then 2 spaces
        System.out.println("\nYou have lost one turn!");
        System.out.println("HAVE FUN!");
        inventory2.lostTurn = inventory2.lostTurn + 1;
    }
    

    public void advanceToNearestGame() {
        //@author adil
        //Player advances to the nearest game
        //Calculates distance of every single game and figures out which is the closest
        System.out.println("Advance to the nearest game!");
        blackjackSpace1 = 6; //just putting the space number in
        blackjackSpace2 = 13;
        blackjackDistance1 = blackjackSpace1 - src.player2.totalSpace; //this is how distance is calculated
        blackjackDistance2 = blackjackSpace2 - src.player2.totalSpace;
        cardgameSpace1 = 7;
        cardgameSpace2 = 18;
        cardgameDistance1 = cardgameSpace1 - src.player2.totalSpace;
        cardgameDistance2 = cardgameSpace2 - src.player2.totalSpace;
        rouletteSpace1 = 3;
        rouletteSpace2 = 12;
        rouletteDistance1 = rouletteSpace1 - src.player2.totalSpace;
        rouletteDistance2 = rouletteSpace2 - src.player2.totalSpace;
        slotsSpace1 = 5;
        slotsSpace2 = 9;
        slotsDistance1 = slotsSpace1 - src.player2.totalSpace;
        slotsDistance2 = slotsSpace2 - src.player2.totalSpace;
        if (blackjackDistance1 < 0) { //the following if/else if are for if the distance is negative, the player will advance forward not backwards so we want to disregard anything that has them going backwards
            blackjackDistance1 = 100; //setting it = to 100 makes sure it won't be the smallest
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
        //math.min to get the smallest for each game then the smallest of all of them
        smallestBlackjack = Math.min(blackjackDistance1, blackjackDistance2);
        smallestcardGame = Math.min(cardgameDistance1, cardgameDistance2);
        smallestRoulette = Math.min(rouletteDistance1, rouletteDistance2);
        smallestSlots = Math.min(slotsDistance1, slotsDistance2);
        smallest = Math.min(smallestBlackjack, Math.min(smallestcardGame, Math.min(smallestRoulette, smallestSlots)));
        src.player2.totalSpace = src.player2.totalSpace + smallest; //the smallest distance is added to the player's game space to send them to the closest game
    }

    public void powerUp() {
        //@author adil
        //Player wins a powerup
        powerup = rnd.nextInt(1,7); //random number generator to pick a powerop
        if (powerup == 1) {
            System.out.println("You won the advance spaces powerup! It will be added to your inventory");
            inventory2.advanceSpaces = inventory2.advanceSpaces + 1; //give advance spaces powerup
        } else if (powerup == 2) {
            System.out.println("You won the re-roll powerup! It will be added to your inventory");
            inventory2.reroll = inventory2.reroll + 1; //give reroll powerup
        } else if (powerup == 3) {
            System.out.println("You won the refuse rent powerup! It will be added to your inventory");
            inventory2.refuseRent = inventory2.refuseRent + 1; //give refuse rent powerup
        } else if (powerup == 4) {
            System.out.println("You won the reverse rent powerup! It will be added to your inventory");
            inventory2.reverseRent = inventory2.reverseRent + 1; //give reverse rent powerup
        } else if (powerup == 5) {
            System.out.println("You won the re-spin wheel powerup! It will be added to your inventory");
            inventory2.reSpin = inventory2.reSpin + 1; //give respin wheel powerup
        } else if (powerup == 6) {
            System.out.println("You won the control opponent powerup! It will be added to your inventory");
            inventory2.controlOpponent = inventory2.controlOpponent + 1; //give control opponent powerup
        } else if (powerup == 7) {
            System.out.println("You won the jail sentence powerup! It will be added to your inventory");
            inventory2.jailSentence = inventory2.jailSentence + 1; //give jail sentence powerup
        }
    }

    public void advanceStart() {
        //@author adil
        //Player advances to start
        System.out.println("\nAdvance to START!");
        src.player2.totalSpace = 20; //this puts them at the start game space
        startAndGo2.start(); //they will collect 4K for landing on go
    }
}