package game;

import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;

public class giantWheel {

    // Creating Objects

    Random rnd = new Random();

    chanceWheel chanceWheel = new chanceWheel();

    penaltyWheel penaltyWheel = new penaltyWheel();

    wheelMethods wheelMethods = new wheelMethods();

    // Creating Variables

    double winMoney;

    double loseMoney;

    int spinWheel;

    int jackpot;

    double takeMoney;

    double moneyTaken;

    //Creating Methods

    public void giantwheel() {
        spinWheel = rnd.nextInt(1,15);
        System.out.println("Spinning the giant Casinopoly wheel...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (spinWheel == 1) {
            System.out.println("Spin the chance wheel!");
            chanceWheel.chancesOfWheel();
        } else if (spinWheel == 2) {
            System.out.println("Spin the penalty wheel!");
            penaltyWheel.wheelOfPenalty();
        } else if (spinWheel == 3) {
            System.out.println("Advance to START!");
        } else if (spinWheel == 4) {
            wheelMethods.goToJail();
        } else if (spinWheel == 5) {
            wheelMethods.jailFreeCard();
        } else if (spinWheel == 6) {
            System.out.println("Advance to the nearest game!");
        } else if (spinWheel == 7) {
            jackpot = rnd.nextInt(1,6);
            if (jackpot == 1) {
                Scanner in = new Scanner(System.in);
                System.out.println("You have been given the opportunity to go ALL OR NOTHING! Would you like to play and get a 50% chance of either doubling your money or losing it all, or would you instead like to spin the jackpot wheel? Press y to go all or nothing, anything else to spin the jackpot wheel.");
                String choice = in.nextLine();
                if (choice.equals("Y") || choice.equals("y")) {
                    System.out.println("You have chosen to go all or nothing!");
                } else {
                    System.out.println("You have chosen to spin the jackpot wheel instead!");
                }
                in.close();
            } else {
                System.out.println("Spin the jackpot wheel!");
            }
        } else if (spinWheel == 8) {
            winMoney = rnd.nextDouble(1000,20000);
            System.out.println("You won " + String.format("$%.2f", winMoney).replace("$0.", "$.") + "!");
        } else if (spinWheel == 9) {
            loseMoney = rnd.nextDouble(1000,20000);
            System.out.println("You lost " + String.format("$%.2f", loseMoney).replace("$0.", "$.") + "!");
        } else if (spinWheel == 10) {
            takeMoney = rnd.nextDouble(1000,10000);
            System.out.println("The other player owes you " + String.format("$%.2f", takeMoney).replace("$0.", "$.") + "!");  
        } else if (spinWheel == 11) {
            moneyTaken = rnd.nextDouble(1000,10000);
            System.out.println("You owe the other player " + String.format("$%.2f", moneyTaken).replace("$0.", "$.") + "!");
        } else if (spinWheel == 12) {
            System.out.println("The other player has won a move control powerup! This means they can move you 1-3 spaces at any time (one time use).");
            wheelMethods.playerChoosesToMoveYou();
        } else if (spinWheel == 13) {
            System.out.println("You have lost one turn!");
            wheelMethods.movingPrevelges();  
        }
    }
}