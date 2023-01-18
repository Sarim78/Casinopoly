package src;

// Importing Libraries 
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

/**
 * Player 1 Data
 * @athuor Sarim Siddiqui
 */

public class player {

    // Creating Objects  

    Random rnd = new Random();

    // Creating Variables
    
    public int space = 1;

    public double playersMoney = 10000;

    public int diceRoller;

    public int totalSpace;

    public String name;

    String choice;

    public void rollDice() {
        diceRoller = rnd.nextInt(1, 6);
        totalSpace = space + diceRoller;
    }
}