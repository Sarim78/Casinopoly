package game;

import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;

/**
 * Giant Wheel
 * Exact same as Giant Wheel, but this what the chance wheel uses when you win a giant wheel spin from there
 * This is to avoid a stack overflow error
 * @author adil
 */

public class giantWheel2 {

    // Creating Objects

    Random rnd = new Random();

    penaltyWheel penaltyWheel = new penaltyWheel();

    wheelMethods wheelMethods = new wheelMethods();

    jackpotWheel jackpotWheel = new jackpotWheel();

    allorNothing allorNothing = new allorNothing();

    // Creating Variables

    int spinWheel;

    int jackpot;

    String choice;

    //Creating Methods

    public void giantwheel() {
        System.out.println("\nWelcome to the Giant Casinopoly Wheel, where the outcomes are endless!");
        spinWheel = rnd.nextInt(1,14);
        System.out.println("\nSpinning the giant Casinopoly wheel...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (spinWheel == 1) {
            System.out.println("\nRe-spin the giant wheel!");
            giantwheel();
        } else if (spinWheel == 2) {
            System.out.println("\nSpin the penalty wheel!");
            penaltyWheel.wheelOfPenalty();
        } else if (spinWheel == 3) {
            wheelMethods.advanceStart();
        } else if (spinWheel == 4) {
            wheelMethods.goToJail();
        } else if (spinWheel == 5) {
            wheelMethods.jailFreeCard();
        } else if (spinWheel == 6) {
            wheelMethods.advanceToNearestGame();
        } else if (spinWheel == 7) {
            jackpot = rnd.nextInt(1,6);
            if (jackpot == 1) {
                Scanner in = new Scanner(System.in);
                System.out.println("\nYou have been given the opportunity to go ALL OR NOTHING! Would you like to play and get a 50% chance of either doubling your money or losing almost all of it, or would you instead like to spin the jackpot wheel? Press y to go all or nothing, anything else to spin the jackpot wheel.");
                choice = in.nextLine();
                if (choice.equals("Y") || choice.equals("y")) {
                    System.out.println("\nYou have chosen to go all or nothing!");
                    allorNothing.allOrNothing();
                } else {
                    System.out.println("\nYou have chosen to spin the jackpot wheel instead!");
                    jackpotWheel.jackpotwheel();
                }
                in.close();
            } else {
                System.out.println("\nSpin the jackpot wheel!");
                jackpotWheel.jackpotwheel();
            }
        } else if (spinWheel == 8) {
            wheelMethods.winMoney();
        } else if (spinWheel == 9) {
            wheelMethods.loseMoney();
        } else if (spinWheel == 10) {
            wheelMethods.takeMoney();
        } else if (spinWheel == 11) {
            wheelMethods.moneyTaken();
        } else if (spinWheel == 12) {
            wheelMethods.playerChoosesToMoveYou();
        } else if (spinWheel == 13) {
            wheelMethods.movingPrevelges();  
        } else if (spinWheel == 14) {
            wheelMethods.powerUp();
        }
    }
}
