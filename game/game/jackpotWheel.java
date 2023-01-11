package game;

import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;

public class jackpotWheel {
    
    public static void jackpotWheel() {
        Random rnd = new Random();
        int spinWheel = rnd.nextInt(1,11);
        System.out.println("Spinning the jackpot wheel...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (spinWheel == 1) {
            System.out.println("Advance to START!");
        } else if (spinWheel == 2) {
            System.out.println("You won a get out of jail free card!");
            wheelMethods.jailFreeCard();
        } else if (spinWheel == 3) {
            System.out.println("Advance to the nearest game!");
        } else if (spinWheel == 4) {
            int jackpot = rnd.nextInt(1,3);
            if (jackpot == 1) {
                Scanner in = new Scanner(System.in);
                System.out.println("You have been given the opportunity to go ALL OR NOTHING! Would you like to play and get a 50% chance of either doubling your money or losing it all, or would you instead like to spin the jackpot wheel? Press y to go all or nothing, anything else to spin the jackpot wheel again.");
                String choice = in.nextLine();
                if (choice.equals("Y") || choice.equals("y")) {
                    System.out.println("You have chosen to go all or nothing!");
                } else {
                    System.out.println("You have chosen to spin the jackpot wheel again instead!");
                }
            } else {
                System.out.println("Spin the jackpot wheel again!");
            }
        } else if (spinWheel == 5) {
            double winMoney = rnd.nextDouble(1000,20000);
            System.out.println("You won " + String.format("$%.2f", winMoney).replace("$0.", "$.") + "!");
        } else if (spinWheel == 6) {
            double takeMoney = rnd.nextDouble(1000,10000);
            System.out.println("The other player owes you " + String.format("$%.2f", takeMoney).replace("$0.", "$.") + "!");  
        }
    }
}
