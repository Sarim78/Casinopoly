package src;

// Importing Libraries 
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class turns {
    // Creating Objects
    
    player player = new player();

    player2 player2 = new player2();

    public String choice;

    // Creating Variables

    public void playerTurn1() {
        System.out.println(player.name + ", it's your turn! What would you like to do?");
        System.out.println("\nPress (H) to view game instructions");
        System.out.println("\nPress (I) to view inventory");
        System.out.println("\nPress (M) to view your current money total");
        System.out.println("\nPress (S) to view what space you're currently on");
        System.out.println("\nPress (R) to roll and begin your turn!");
        Scanner in = new Scanner(System.in);
        choice = in.nextLine();
        if (choice.equals("H") || choice.equals("h")) {
            //show them instructions
        } else if (choice.equals("I") || choice.equals("i")) {
            //show them their inventory
        } else if (choice.equals("M") || choice.equals("m")) {
            System.out.println("Your current money total: " + player.playersMoney);
        } else if (choice.equals("S") || choice.equals("s")) {
            //show them what space they're on
        } else if (choice.equals("R") || choice.equals("r")) {
            //roll
        } else {
            System.out.println("Invalid input! Please try again.");
            playerTurn2();
        }
    }

    public void playerTurn2() {
        System.out.println(player2.name + ", it's your turn! What would you like to do?");
        System.out.println("\nPress (H) to view game instructions");
        System.out.println("\nPress (I) to view inventory");
        System.out.println("\nPress (M) to view your current money total");
        System.out.println("\nPress (S) to view what space you're currently on");
        System.out.println("\nPress (R) to roll and begin your turn!");
        playerTurn1();
    }
}
