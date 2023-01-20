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

    public int diceRoller;

    public static int totalSpace = 1;

    public String name;

    String choice;

    public static double gameEarnings;

    public String showMoney;

    public static double playersMoney;

    public int plsworktoo(int totalSpace) {
        System.out.println("This is space #" + totalSpace);
        return totalSpace;
    }

    public void rollDice() {
        diceRoller = rnd.nextInt(1, 6);
        totalSpace = totalSpace + diceRoller;
        plsworktoo(totalSpace);
    }

    public double plsWorklol(double playersMoney) {
        showMoney = ("\nYour current Balance In Your Account is now : " + String.format("$%.2f", playersMoney).replace("$0.", "$."));
        System.out.println(showMoney);
        return playersMoney;
    }

    public void bankAccount() {
        playersMoney = 10000;
        playersMoney = playersMoney + gameEarnings;
        plsWorklol(playersMoney);
    }
}