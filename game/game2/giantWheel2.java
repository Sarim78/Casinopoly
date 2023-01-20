package game;

import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;

/**
 * Giant Wheel
 * @author adil
 */

public class giantWheel {

    // Creating Objects

    Random rnd = new Random();

    penaltyWheel penaltyWheel = new penaltyWheel();

    wheelMethods wheelMethods = new wheelMethods();

    jackpotWheel jackpotWheel = new jackpotWheel();

    allorNothing allorNothing = new allorNothing();

    chanceWheel chanceWheel = new chanceWheel();

    // Creating Variables

    int spinWheel; //random number is generated as a wheel simulator

    int jackpot; //the lottery for the all or nothing option

    String choice; //whether they want to play all or nothing or not

    //Creating Methods

    //here it is, the giant casinopoly wheel
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
            //win a chance wheel spin
            System.out.println("\nSpin the chance wheel!");
            chanceWheel.chancewheel();
        } else if (spinWheel == 2) {
            //win a penalty wheel spin
            System.out.println("\nSpin the penalty wheel!");
            penaltyWheel.wheelOfPenalty();
        } else if (spinWheel == 3) {
            //win advance to start
            wheelMethods.advanceStart();
        } else if (spinWheel == 4) {
            //win go to jail
            wheelMethods.goToJail();
        } else if (spinWheel == 5) {
            //win get out of jail for free card
            wheelMethods.jailFreeCard();
        } else if (spinWheel == 6) {
            //win advance to nearest game
            wheelMethods.advanceToNearestGame();
        } else if (spinWheel == 7) {
            jackpot = rnd.nextInt(1,6);
            if (jackpot == 1) { //if jackpot is 1, then they can play or nothing
                Scanner in = new Scanner(System.in);
                System.out.println("\nYou have been given the opportunity to go ALL OR NOTHING! Would you like to play and get a 50% chance of either doubling your money or losing almost all of it, or would you instead like to spin the jackpot wheel? Press y to go all or nothing, anything else to spin the jackpot wheel.");
                choice = in.nextLine(); //they can pass and re-spin instead
                if (choice.equals("Y") || choice.equals("y")) {
                    System.out.println("\nYou have chosen to go all or nothing!");
                    allorNothing.allOrNothing();
                } else {
                    System.out.println("\nYou have chosen to spin the jackpot wheel instead!");
                    jackpotWheel.jackpotwheel();
                }
                in.close();
            } else { //otherwise they re-spin the jackpot wheel
                System.out.println("\nSpin the jackpot wheel!");
                jackpotWheel.jackpotwheel();
            }
        } else if (spinWheel == 8) {
            //win money
            wheelMethods.winMoney();
        } else if (spinWheel == 9) {
            //lose money
            wheelMethods.loseMoney();
        } else if (spinWheel == 10) {
            //take money from opponent
            wheelMethods.takeMoney();
        } else if (spinWheel == 11) {
            //opponent takes their money
            wheelMethods.moneyTaken();
        } else if (spinWheel == 12) {
            //opponent wins control opponent powerup
            wheelMethods.playerChoosesToMoveYou();
        } else if (spinWheel == 13) {
            //player loses turn
            wheelMethods.movingPrevelges();  
        } else if (spinWheel == 14) {
            //player wins a powerup
            wheelMethods.powerUp();
        }
    }
}