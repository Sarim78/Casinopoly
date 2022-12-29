package game;

// Importing Libraries 
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import src.player;

public class gameBoard {
    // Creating Objects 
    static Random rnd = new Random();
    static Scanner in = new Scanner(System.in);

    // Creating Variables
    static int totalSpace;

    // Methods 
    public static void dice() {
        int dice = rnd.nextInt(1, 6);
        System.out.println("You have rolled a: " + dice);

        totalSpace = player.space + dice;

        if(totalSpace > 18) {
            totalSpace = totalSpace - 18;
            System.out.println(totalSpace);
        } else {
            System.out.println(totalSpace);
        }
    }
}