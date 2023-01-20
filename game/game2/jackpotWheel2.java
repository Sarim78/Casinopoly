package game;

import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;

/**
 * Jackpot Wheel
 * This is just all the good stuff on giant wheel
 * Not much else is different
 * @author adil
 */

public class jackpotWheel {

    // Creating Objects

    Random rnd = new Random();

    wheelMethods wheelMethods = new wheelMethods();

    startAndGo startAndGo = new startAndGo();

    allorNothing allorNothing = new allorNothing();

    // Creating Variables

    int spinWheel;

    int jackpot;

    String choice;

    //Creating Methods
    
    public void jackpotwheel() {
        System.out.println("\nWelcome to the jackpot wheel, where your biggest and wildest dreams come true!");
        spinWheel = rnd.nextInt(1,7);
        System.out.println("\nSpinning the jackpot wheel...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (spinWheel == 1) {
            wheelMethods.advanceStart();
        } else if (spinWheel == 2) {
            wheelMethods.jailFreeCard();
        } else if (spinWheel == 3) {
            wheelMethods.advanceToNearestGame();
        } else if (spinWheel == 4) {
            jackpot = rnd.nextInt(1,3); //there is a higher chance of winning all or nothing here
            if (jackpot == 1) {
                Scanner in = new Scanner(System.in);
                System.out.println("\nYou have been given the opportunity to go ALL OR NOTHING! Would you like to play and get a 50% chance of either doubling your money or losing almost all of it, or would you instead like to spin the jackpot wheel? Press y to go all or nothing, anything else to spin the jackpot wheel again.");
                choice = in.nextLine();
                if (choice.equals("Y") || choice.equals("y")) {
                    System.out.println("\nYou have chosen to go all or nothing!");
                    allorNothing.allOrNothing();
                } else {
                    System.out.println("\nYou have chosen to spin the jackpot wheel again instead!");
                    jackpotwheel();
                }
                //in.close();
            } else {
                System.out.println("\nSpin the jackpot wheel again!");
                jackpotwheel();
            }
        } else if (spinWheel == 5) {
            wheelMethods.winMoney();
        } else if (spinWheel == 6) {
            wheelMethods.takeMoney();
        } else if (spinWheel == 7) {
            wheelMethods.powerUp();
        }
    }
}
