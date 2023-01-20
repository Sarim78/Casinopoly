package src;

// Importing Libraries 
import java.util.Scanner;

// Importing Files

import game.gameBoard;
import game2.gameBoard2;

/**
 * Player 1 Data
 * @author adil
 */

public class turns {
    // Creating Objects
    
    player player = new player();

    player2 player2 = new player2();

    gameBoard gameBoard = new gameBoard();

    inventory1 inventory1 = new inventory1();

    inventory2 inventory2 = new inventory2();

    public String choice1;

    public String choice2;

    String play;

    String confirm;

    String howToPlay;

    String ins;

    String Continue;

    String powerChoice;

    // Creating Variables

    //game menu when you open the game
    public void gameMenu() {
        System.out.println("\nWelcome to Casinopoly, the casino version of Monopoly you never knew you needed!");
        System.out.println("\nThis where luck wins over skill!");
        System.out.println("\nYou need 2 players to play this game.");
        System.out.println("\nWould you like to play? Press anything to continue, x to exit");
        Scanner in = new Scanner(System.in);
        play = in.nextLine();
        if (play.equals("x") || play.equals("X")) {
            System.out.println("\nExiting the game...");
        } else {
            System.out.println("\nIt's time to choose names!");
            player1Name();
        }
    }

    //player 1 sets name
    public void player1Name() {
        System.out.println("\nPlayer 1, what would you like to be called?");
        Scanner in = new Scanner(System.in);
        player.name = in.nextLine();
        player1ConfirmName();
    }

    //player 2 sets name
    public void player2Name() {
        System.out.println("\nPlayer 2, what would you like to be called?");
        Scanner in = new Scanner(System.in);
        player2.name = in.nextLine();
        player2ConfirmName();
    }

    public void player1ConfirmName() {
        System.out.println("\nPress anything to confirm, N to select a different name");
        Scanner in = new Scanner(System.in);
        confirm = in.nextLine();
        if (confirm.equals("N") || confirm.equals("n")) {
            System.out.println("\nSelect a different name!");
            player1Name();
        } else {
            System.out.println("\nName confirmed!");
            player2Name();
        }
    }

    public void player2ConfirmName() {
        System.out.println("\nPress anything to confirm, N to select a different name");
        Scanner in = new Scanner(System.in);
        confirm = in.nextLine();
        if (confirm.equals("N") || confirm.equals("n")) {
            System.out.println("\nSelect a different name!");
            player2Name();
        } else {
            System.out.println("\nName confirmed!");
            instructions();
        }
    }

    //if they want to know how to play
    public void instructions() {
        System.out.println("\nWould you like to see how to play? Click (I) for instructions, anything else to start the game");
        Scanner in = new Scanner(System.in);
        howToPlay = in.nextLine();
        if (howToPlay.equals("I") || howToPlay.equals("i")) {
            instructionsMenu();
            System.out.println("\nStarting the game...");
            noNamefornow();
            playerTurn1();
        } else {
            System.out.println("\nStarting the game...");
            noNamefornow();
            playerTurn1();
        }
    }

    public void anythingToContinue() {
        System.out.println("\nPress anything to continue.");
        Scanner in = new Scanner(System.in);
        Continue = in.nextLine();
        if (Continue != null) {
            
        }
    }

    //the game instructions
    public void instructionsMenu() {
        System.out.println("\nWelcome to the instructions menu! What would you like to do?");
        System.out.println("\nPress (I) to view the entire game instructions");
        System.out.println("\nPress (C) to view the Casinopoly introduction");
        System.out.println("\nPress (R) to view what player options are during a turn");
        System.out.println("\nPress (G) to view the gameboard");
        System.out.println("\nPress (D) to view information about the games");
        System.out.println("\nPress (W) to view information about wheels");
        System.out.println("\nPress (S) to view information about the Casinopoly Shop");
        System.out.println("\nPress (J) to view information about the Casinopoly jail");
        System.out.println("\nPress (O) to view information about other game spaces");
        System.out.println("\nPress (P) to view information about powerups");
        System.out.println("\nPress (F) to view Frequently Asked Questions");
        System.out.println("\nPress (X) to exit");
        Scanner in = new Scanner(System.in);
        ins = in.nextLine();
        if (ins.equals("I") || ins.equals("i")) {
            intro();
            anythingToContinue();
            playerOptions();
            anythingToContinue();
            gameBoard();
            anythingToContinue();
            games();
            anythingToContinue();
            wheels();
            anythingToContinue();
            shop();
            anythingToContinue();
            jail();
            anythingToContinue();
            otherSpaces();
            anythingToContinue();
            powerups();
            anythingToContinue();
            faq();
            System.out.println("You reached the end of the instructions.");
            anythingToContinue();
            instructionsMenu();
        } else if (ins.equals("C") || ins.equals("c")) {
            intro();
            anythingToContinue();
            instructionsMenu();
        } else if (ins.equals("R") || ins.equals("r")) {
            playerOptions();
            anythingToContinue();
            instructionsMenu();
        } else if (ins.equals("G") || ins.equals("g")) {
            gameBoard();
            anythingToContinue();
            instructionsMenu();
        } else if (ins.equals("D") || ins.equals("d")) {
            games();
            anythingToContinue();
            instructionsMenu();
        } else if (ins.equals("W") || ins.equals("w")) {
            wheels();
            anythingToContinue();
            instructionsMenu();
        } else if (ins.equals("S") || ins.equals("s")) {
            shop();
            anythingToContinue();
            instructionsMenu();
        } else if (ins.equals("J") || ins.equals("j")) {
            jail();
            anythingToContinue();
            instructionsMenu();
        } else if (ins.equals("O") || ins.equals("o")) {
            otherSpaces();
            anythingToContinue();
            instructionsMenu();
        } else if (ins.equals("P") || ins.equals("p")) {
            powerups();
            anythingToContinue();
            instructionsMenu();
        } else if (ins.equals("F") || ins.equals("f")) {
            faq();
            anythingToContinue();
            instructionsMenu();
        } else if (ins.equals("X") || ins.equals("x")) {
            System.out.println("Exiting instructions menu...");
        } else {
            System.out.println("Invalid input!");
            instructionsMenu();
        }
    }

    public void intro() {
        System.out.println("\nIntroduction: ");
        System.out.println("\nCasinopoly is meant to be a casino version of the popular Monopoly game. The goal of the game is to win as much money as possible. The first player to get to $100K wins the game! Money can be earned in many different ways throughout the game, but it can be lost in many ways too! You can also win powerups, which help you in the game. Both players start with $10K.");
        System.out.println("\nAs always, make sure to gamble responsibly! Casinopoly is not responsible for any gambling sprees caused by the enjoyment of this game.");
        System.out.println("\nThis game was created and developed by Adil Baig and Sarim Sidiqqui");
    }

    public void playerOptions() {
        System.out.println("\nPlayer Options during a Turn:");
        System.out.println("\n1. View the game instructions menu");
        System.out.println("\n2. View your inventory (any items you own)");
        System.out.println("\n3. View your current money total");
        System.out.println("\n4. View the gameboard");
        System.out.println("\n5. View what space you're currently on");
        System.out.println("\n6. View and activate powerups");
        System.out.println("\n7. Roll the dice and begin your turn by moving around the board");
        System.out.println("\nAfter you roll the dice, you can't do anything else.");
    }

    public void gameBoard() {
        System.out.println("\nGameboard: ");
        System.out.println("\n1. START");
        System.out.println("\n2. Jackpot Wheel");
        System.out.println("\n3. Roulette");
        System.out.println("\n4. Chance Wheel");
        System.out.println("\n5. Slot Machine");
        System.out.println("\n6. Blackjack");
        System.out.println("\n7. Hi-Lo");
        System.out.println("\n8. Jail");
        System.out.println("\n9. Slot Machine");
        System.out.println("\n10. Chance Wheel");
        System.out.println("\n11. Free Space");
        System.out.println("\n12. Roulette");
        System.out.println("\n13. Blackjack");
        System.out.println("\n14. Go to Jail");
        System.out.println("\n15. Giant Casinopoly Wheel");
        System.out.println("\n16. Free Space");
        System.out.println("\n17. Casinopoly Shop");
        System.out.println("\n18. Hi-Lo");
        System.out.println("\n19. Penalty Wheel");
    }

    public void games() {
        System.out.println("\nGames:");
        System.out.println("\nBlackjack");
        System.out.println("\nHi-Lo");
        System.out.println("\nRoulette");
        System.out.println("\nSlot Machine");
        System.out.println("\nAll or Nothing");
        System.out.println("\nFor information on how to play these games, ask for game instructions before you play the game. All games will either win you money, or lose you money. They require the player to wager an amount of money. Wagers can be any amount you want within the game requirements, it doesn't matter how much money you have. If you win, you'll win a percentage of the money you wagered, but if you lose, you will lose a percentage of your wager. This means if you wager more money than you have, you could end up in debt, so be careful!");
        System.out.println("\nWhen do you make a wager, don't expect to win or lose all of that money. A smart wager would be double the amount of money you're comfortable with either winning or losing.");
        System.out.println("\nYou may be given the opportunity to play all or nothing, via the Giant Casinopoly Wheel, Jackpot Wheel or Casinopoly Store. If you have at least 20K in your bank account, you can play for the chance to either double all your money or lose almost all of it. If you do lose, we'll still leave you with 5K. Keep in mind you don't have to pay 20K to play, you just have to have that much money to play.");
    }

    public void wheels() {
        System.out.println("\nWheels:");
        System.out.println("\nGiant Casinopoly Wheel");
        System.out.println("\nChance Wheel");
        System.out.println("\nPenalty Wheel");
        System.out.println("\nJackpot Wheel");
        System.out.println("\nCasinopoly gives you the opportunity to spin wheels and win prizes!");
        System.out.println("\nThe Giant Casinopoly Wheel is the biggest wheel in the game. Included in the wheel are a large assortment of either good prizes or bad ones, ranging from money to inventory to moving around the board");
        System.out.println("\nThe Chance Wheel is similar to chance cards in Monopoly. You spin and win either something good or something bad!");
        System.out.println("\nThe Jackpot Wheel is the Giant Casinopoly Wheel, but only the good prizes! This means you're guaranteed to win");
        System.out.println("\nThe Penalty Wheel is the opposite, only the bad prizes from the Giant Casinopoly Wheel. This means you're guaranteed to lose");
    }

    public void shop() {
        System.out.println("\nCasinopoly Shop:");
        System.out.println("\nIf you end up in the Casinopoly Shop, that means you can buy anything the store has to offer (provided you have enough money!). Items that can be purchased range from powerups to wheel spins to lottery tickets. All shop items are meant to help you in the game, but remember, you need to have as much money as possible to win! Make sure to make smart purchases that you think will be worth the money spent. You also can't purchase more than 5 items in one trip. In order to purchase an item, just enter in the item number and it will be yours!");
    }

    public void jail() {
        System.out.println("\nJail:");
        System.out.println("\nJust like in Monopoly, Casinopoly has its very own jail, which you will find yourself in if you aren't careful! When you get sent to jail, you do not get money for crossing START. Until you're out of jail, you cannot earn any money no matter what. This means if the other player owes you while you're in jail, they won't have to pay it. In order to get out of jail, you need to pay a bail of $5K. If you don't have enough money to pay bail, then your only option is to roll your way out of jail for free. You can only do this if you can't pay bail, otherwise bail is required. If you roll an even number, you can leave jail for free, but if you don't, then you have to wait until your next turn to try to get out again. You can also leave jail for free if you have a get out of jail for free card, awarded in wheels and the shop.");
    }

    public void otherSpaces() {
        System.out.println("\nOther Spaces:");
        System.out.println("\nSTART - the starting point of the game. Just like in Monopoly, you'll earn money for crossing START, exactly $2K. If you land directly onto START, you'll earn an extra $2K bonus, for a total of $4K.");
        System.out.println("\nJail - if you land on jail, you're just visiting and you don't do anything");
        System.out.println("\nFree Space - there are two free spaces on the game board, where you can relax and take from gambling. That's the only thing you can do though");
        System.out.println("\nGo To Jail - if you land here, you go directly to jail without getting money for crossing START");
    }

    public void powerups() {
        System.out.println("\nPower-ups:");
        System.out.println("\nRe-roll: If you own the re-roll powerup, you can decide to re-roll if you don't like the space you landed on! You will be prompted with the option to use the powerup after every roll, before starting the activity");
        System.out.println("\nAdvance Spaces: Before you begin your turn, you can advance from 1-5 spaces on the game board. You would do whatever activity you land on, then roll to finish your turn. This is a powerup you have to activate yourself using the (P) key");
        System.out.println("\nRefuse Rent: When you owe the other player money, you can simply say no with this powerup! If you own the powerup, you will be prompted with the option to refuse paying the other player if you ever owe money.");
        System.out.println("\nReverse Rent: When you owe the player money, don't just say no, also say that's my money now! If you own the powerup, you will be prompted with the option to have them owe you instead if you ever owe money. If you decide to use it, then you pay nothing, and they pay you that amount instead");
        System.out.println("\nRe-Spin Wheel: Don't like what you got on a wheel? You can spin again! If you own this powerup, you will be prompted with the option to re-spin the wheel instead of getting what the wheel landed on.");
        System.out.println("\nControl Opponent: Want to control the other player? Now you can! If you own this powerup, you can skip your turn and instead control your opponent! You activate the powerup using the (P) key. When activated, you'll be able to see the gameboard and where your opponent is. Choose to move them anywhere from 1-3 spaces, and they'll have to play the activity they land on. You can roll after they've completed that turn.");
        System.out.println("\nJail Sentence: If you decide to activate this powerup using the (P) key, you can send your opponent directly to jail! You still get to complete your turn after.");
        System.out.println("\nAll powerups are one-time use, but you can own more than one of each powerup.");
    }

    public void faq() {
        System.out.println("\nFAQ:");
        System.out.println("\nQ: Can I wager more money than I have?");
        System.out.println("\nA: Absolutely! But if you lose, you could end up in debt, so be careful!");
        System.out.println("\nQ: What do I do if I'm in debt?");
        System.out.println("\nA: If you have no money, you won't be able to buy anything, but luckily most of the game doesn't require that. You can still spin wheels and play games to earn money and get out of debt.");
        System.out.println("\nQ: Can I refuse to play a game if I don't want to?");
        System.out.println("\nA: Sadly, no. You have to play all the games and wheels if you land there. The lone exception is all or nothing, which if given the opportunity to play it, you can turn down.");
        System.out.println("\nQ: Is there a maximum amount of money you can wager?");
        System.out.println("\nA: Yes there is, and it's different for every game. There's a minimum amount of money you can bet as well.");
        System.out.println("\nQ: How do I get to play all or nothing?");
        System.out.println("\nA: You can either win the chance to play it from a wheel, or you can buy it if it's available in the shop (it won't be every time you visit). It costs $10K to play it from the shop, and you need at least $20K to play, so you need at least $30K to buy it from the shop.");
        System.out.println("\nQ: Can I use powerups while I'm in jail?");
        System.out.println("\nA: That's the one thing you can do in jail! If you own the reverse rent or refuse rent powerups, you can use them even if you're imprisoned, and refuse paying the other player. However, you still can't earn any money, so the reverse rent powerup only refuses rent if used in jail.");
        System.out.println("\nYou won't have the option to activate any other powerups while in jail");
        System.out.println("\nQ: What are lottery tickets?");
        System.out.println("\nA: Lottery tickets are items that can be purchased in the shop. If you buy one, you're entered in a lottery with the chance to win big! There are 3 lottery tickets with different costs. The more expensive, the bigger the jackpot is. You have a 15% chance to win the lottery, for all three.");
    }

    public void powerMenu() {
        System.out.println("\nWelcome to the Powerups menu! What would you like to do?");
        System.out.println("\nPress (P) to view powerups information/details");
        System.out.println("\nPress (A) to activate the advance spaces powerup");
        System.out.println("\nPress (C) to activate the control opponent powerup");
        System.out.println("\nPress (J) to activate the jail sentence powerup");
        System.out.println("\nPress anything else to go back to your turn");
        Scanner in = new Scanner(System.in);
        powerChoice = in.nextLine();
        if (powerChoice.equals("P") || powerChoice.equals("p")) {
            powerups();
            anythingToContinue();
            powerMenu();
        }
    }

    //setting up game
    public void noNamefornow(){
        gameBoard.start();
    }


    //player1 turn
    public void playerTurn1() {
        if (inventory1.lostTurn > 0) {
            inventory1.lostTurn = inventory1.lostTurn - 1;
            playerTurn2();
        }
        System.out.println("\n" + player.name + ", it's your turn! What would you like to do?");
        System.out.println("\nPress (H) to view game instructions");
        System.out.println("\nPress (I) to view inventory");
        System.out.println("\nPress (M) to view your current money total");
        System.out.println("\nPress (G) to view the gameboard");
        System.out.println("\nPress (S) to view what space you're currently on");
        System.out.println("\nPress (P) to activate powerups or see what they do");
        System.out.println("\nPress (R) to roll and begin your turn!");
        Scanner in = new Scanner(System.in);
        choice1 = in.nextLine();
        if (choice1.equals("H") || choice1.equals("h")) {
            instructionsMenu();
            playerTurn1();
        } else if (choice1.equals("I") || choice1.equals("i")) {
            inventory1.viewInventory();
            anythingToContinue();
            playerTurn1();
        } else if (choice1.equals("M") || choice1.equals("m")) {
            player.plsWorklol(src.player.playersMoney);
            anythingToContinue();
            playerTurn1();
        } else if (choice1.equals("G") || choice1.equals("g")) {
            gameBoard();
            anythingToContinue();
            playerTurn1();
        } else if (choice1.equals("S") || choice1.equals("s")) {
            System.out.println("\nYou are on " + gameBoard.spaceName + "!");
            anythingToContinue();
            playerTurn1();
        } else if (choice1.equals("P") || choice1.equals("p")) {
            powerMenu();
            anythingToContinue();
            playerTurn1();
        } else if (choice1.equals("R") || choice1.equals("r")) {
            //roll
            gameBoard.dice1();
        } else {
            System.out.println("\nInvalid input! Please try again.");
            playerTurn1();
        }
        playerTurn2();
    }

    //player2 turn
    public void playerTurn2() {
        if (inventory2.lostTurn > 0) {
            inventory2.lostTurn = inventory2.lostTurn - 1;
            playerTurn1();
        }
        System.out.println("\n" + player2.name + ", it's your turn! What would you like to do?");
        System.out.println("\nPress (H) to view game instructions");
        System.out.println("\nPress (I) to view inventory");
        System.out.println("\nPress (M) to view your current money total");
        System.out.println("\nPress (G) to view the gameboard");
        System.out.println("\nPress (S) to view what space you're currently on");
        System.out.println("\nPress (P) to activate powerups or see what they do");
        System.out.println("\nPress (R) to roll and begin your turn!");
        Scanner in = new Scanner(System.in);
        choice2 = in.nextLine();
        if (choice2.equals("H") || choice2.equals("h")) {
            instructionsMenu();
            playerTurn2();
        } else if (choice2.equals("I") || choice2.equals("i")) {
            inventory2.viewInventory();
            anythingToContinue();
            playerTurn2();
        } else if (choice2.equals("M") || choice2.equals("m")) {
            player2.plsWorklol(src.player2.playersMoney);
            anythingToContinue();
            playerTurn2();
        } else if (choice2.equals("G") || choice2.equals("g")) {
            gameBoard();
            anythingToContinue();
            playerTurn2();
        } else if (choice2.equals("S") || choice2.equals("s")) {
            System.out.println("\nYou are on " + gameBoard2.spaceName + "!");
            anythingToContinue();
            playerTurn2();
        } else if (choice2.equals("P") || choice2.equals("p")) {
            powerMenu();
            anythingToContinue();
            playerTurn2();
        } else if (choice2.equals("R") || choice2.equals("r")) {
            //roll
            gameBoard2.dice2();
        } else {
            System.out.println("\nInvalid input! Please try again.");
            playerTurn2();
        }
        playerTurn1();
    }
}
