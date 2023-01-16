package game;

// Importing Libraries 
import java.util.Random;
import java.util.Scanner;

public class allorNothing {
    
    // Creating Objects
    
    Random rnd = new Random();

    //Creating Variables

    String instructions;

    int aiPick;

    double choice;

    // Creating Methods

    public void introduction() {
        System.out.println("\nWelcome to all or nothing! Lay it all on the line, risk all your money, and get a 50% chance of either doubling your money or losing almost all of it.");
        System.out.println("\nHow to play: You will pick a number. Either 1 or 2. The AI will do the same. If the numbers match, you double your money! But if the numbers do not match, you will be left with 5K");
        System.out.println("\nAre you up to the task? Press anything to continue.");
        Scanner in = new Scanner(System.in);
        instructions = in.nextLine();
        if (instructions.equals("no") || instructions.equals("NO") || instructions.equals("No")) {
            System.out.println("\nSorry, there's no way out...");
            aiPicks();
            game();
            in.close();
        } else {
            aiPicks();
            game();
            in.close();
        }
    }

    public void aiPicks() {
        aiPick = rnd.nextInt(1,100);
        if (aiPick >= 1 && aiPick <= 50) {
            aiPick = 1;
        } else if (aiPick >= 51 && aiPick <= 100) {
            aiPick = 2;
        }
    }

    public void game() {
        try { 
            System.out.println("\nPick a number, either 1 or 2. Choose wisely.");
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            if (choice != 1 && choice != 2) {
                System.out.println("\nYou have to pick a number from 1 or 2! Try again.");
                game();
            } else if (choice == aiPick) {
                System.out.println("\nThe numbers match! Congratulations, you have won double your entire money!");
            } else if (choice != aiPick) {
                System.out.println("\nSorry, the numbers do not match. You have lost all your money and will now be left with just 5K :(");
            }
            in.close();
        } catch (Exception e) {
            System.out.println("\nInvalid input! Please try again.");
            game();
        }
    }

    public void allOrNothing() {
        introduction();
    }
}