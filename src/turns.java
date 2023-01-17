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

    public String choice1;

    public String choice2;

    // Creating Variables

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
            //show them their inventory
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
            gameBoard.dice2();
        } else {
            System.out.println("\nInvalid input! Please try again.");
            playerTurn2();
        }
        playerTurn1();
    }
}
