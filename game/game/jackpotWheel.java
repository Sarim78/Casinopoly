package game;

import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;

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
        spinWheel = rnd.nextInt(1,11);
        System.out.println("\nSpinning the jackpot wheel...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (spinWheel == 1) {
            System.out.println("\nAdvance to START!");
            startAndGo.start();
        } else if (spinWheel == 2) {
            System.out.println("\nYou won a get out of jail free card!");
            wheelMethods.jailFreeCard();
        } else if (spinWheel == 3) {
            System.out.println("\nAdvance to the nearest game!");
            wheelMethods.advanceToNearestGame();
        } else if (spinWheel == 4) {
            jackpot = rnd.nextInt(1,3);
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
                in.close();
            } else {
                System.out.println("\nSpin the jackpot wheel again!");
                jackpotwheel();
            }
        } else if (spinWheel == 5) {
            wheelMethods.winMoney();
        } else if (spinWheel == 6) {
            wheelMethods.takeMoney();
        }
    }
}
