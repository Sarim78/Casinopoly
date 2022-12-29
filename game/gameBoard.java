package game;

// Importing Libraries 
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import src.player;

/**
 * Game Board
 * @athuor Sarim Siddiqui
 * @athuor Adil Baig
 */

public class gameBoard {
    // Creating Objects 
    static Random rnd = new Random();
    static Scanner in = new Scanner(System.in);

    // Creating Variables
    static int totalSpace;

    // Array
    static int[] spaces = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}; 

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