package src;

// Importing Libraries 
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

// Importing Files

import game.gameBoard;

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

    // Creating Variables

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

    public void player1Name() {
        System.out.println("\nPlayer 1, what would you like to be called?");
        Scanner in = new Scanner(System.in);
        player.name = in.nextLine();
        player1ConfirmName();
    }

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

    public void instructions() {
        System.out.println("\nWould you like to see how to play? Click (I) for instructions, anything else to start the game");
        Scanner in = new Scanner(System.in);
        howToPlay = in.nextLine();
        if (howToPlay.equals("I") || howToPlay.equals("i")) {
            System.out.println("\ntoo bad lol");
            System.out.println("\nStarting the game...");
            noNamefornow();
            playerTurn1();
        } else {
            System.out.println("\nStarting the game...");
            noNamefornow();
            playerTurn1();
        }
    }

    public void noNamefornow(){
        gameBoard.start();
    }


    public void playerTurn1() {
        System.out.println("\n" + player.name + ", it's your turn! What would you like to do?");
        System.out.println("\nPress (H) to view game instructions");
        System.out.println("\nPress (I) to view inventory");
        System.out.println("\nPress (M) to view your current money total");
        System.out.println("\nPress (S) to view what space you're currently on");
        System.out.println("\nPress (R) to roll and begin your turn!");
        Scanner in = new Scanner(System.in);
        choice1 = in.nextLine();
        if (choice1.equals("H") || choice1.equals("h")) {
            //show them instructions
            playerTurn1();
        } else if (choice1.equals("I") || choice1.equals("i")) {
            inventory1.viewInventory();
            playerTurn1();
        } else if (choice1.equals("M") || choice1.equals("m")) {
            System.out.println("\nYour current money total: " + player.playersMoney);
            playerTurn1();
        } else if (choice1.equals("S") || choice1.equals("s")) {
            System.out.println("\nYou are on " + gameBoard.spaceName + "!");
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

    public void playerTurn2() {
        System.out.println("\n" + player2.name + ", it's your turn! What would you like to do?");
        System.out.println("\nPress (H) to view game instructions");
        System.out.println("\nPress (I) to view inventory");
        System.out.println("\nPress (M) to view your current money total");
        System.out.println("\nPress (S) to view what space you're currently on");
        System.out.println("\nPress (R) to roll and begin your turn!");
        Scanner in = new Scanner(System.in);
        choice2 = in.nextLine();
        if (choice2.equals("H") || choice2.equals("h")) {
            //show them instructions
            playerTurn2();
        } else if (choice2.equals("I") || choice2.equals("i")) {
            //show them their inventory
            playerTurn2();
        } else if (choice2.equals("M") || choice2.equals("m")) {
            System.out.println("\nYour current money total: " + player.playersMoney);
            playerTurn2();
        } else if (choice2.equals("S") || choice2.equals("s")) {
            System.out.println("\nYou are on " + gameBoard.spaceName + "!");
            playerTurn2();
        } else if (choice2.equals("R") || choice2.equals("r")) {
            //roll
            gameBoard.dice1();
        } else {
            System.out.println("\nInvalid input! Please try again.");
            playerTurn2();
        }
        playerTurn1();
    }
}
