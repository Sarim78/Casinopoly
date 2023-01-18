package src;

// Importing Libraries 
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

/**
 * Player 1 Data
 * @athuor Sarim Siddiqui
 * @athuor Adil
 */

public class player {

    // Creating Objects  

    Random rnd = new Random();

    // Creating Variables
    
    public int space = 1;

    public double playersMoney = 10000;

    public int diceRoller = rnd.nextInt(1, 6);

    public int totalSpace = space + diceRoller;

    public String name = "player1";

    String choice;
}