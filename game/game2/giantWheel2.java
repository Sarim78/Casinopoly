package game2;

import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;

/**
 * Giant Wheel
 * @author adil
 */

public class giantWheel2 {

    // Creating Objects

    Random rnd = new Random();

<<<<<<< HEAD
    penaltyWheel2 penaltyWheel = new penaltyWheel2();

    wheelMethods2 wheelMethods = new wheelMethods2();

    jackpotWheel2 jackpotWheel = new jackpotWheel2();

    allorNothing2 allorNothing = new allorNothing2();

    chanceWheel2 chanceWheel = new chanceWheel2();
=======
    penaltyWheel2 penaltyWheel2 = new penaltyWheel2();

    wheelMethods2 wheelMethods2 = new wheelMethods2();

    jackpotWheel2 jackpotWheel2 = new jackpotWheel2();

    allorNothing2 allorNothing2 = new allorNothing2();

    chanceWheel2 chanceWheel2 = new chanceWheel2();
>>>>>>> 8deca5c680e252a9ef0ca080de4c8d3a67f54282

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
            chanceWheel2.chancewheel();
        } else if (spinWheel == 2) {
            //win a penalty wheel spin
            System.out.println("\nSpin the penalty wheel!");
            penaltyWheel2.wheelOfPenalty();
        } else if (spinWheel == 3) {
            //win advance to start
            wheelMethods2.advanceStart();
        } else if (spinWheel == 4) {
            //win go to jail
            wheelMethods2.goToJail();
        } else if (spinWheel == 5) {
            //win get out of jail for free card
            wheelMethods2.jailFreeCard();
        } else if (spinWheel == 6) {
            //win advance to nearest game
            wheelMethods2.advanceToNearestGame();
        } else if (spinWheel == 7) {
            jackpot = rnd.nextInt(1,6);
            if (jackpot == 1) { //if jackpot is 1, then they can play or nothing
                Scanner in = new Scanner(System.in);
                System.out.println("\nYou have been given the opportunity to go ALL OR NOTHING! Would you like to play and get a 50% chance of either doubling your money or losing almost all of it, or would you instead like to spin the jackpot wheel? Press y to go all or nothing, anything else to spin the jackpot wheel.");
                choice = in.nextLine(); //they can pass and re-spin instead
                if (choice.equals("Y") || choice.equals("y")) {
                    System.out.println("\nYou have chosen to go all or nothing!");
                    allorNothing2.allOrNothing();
                } else {
                    System.out.println("\nYou have chosen to spin the jackpot wheel instead!");
                    jackpotWheel2.jackpotwheel();
                }
                in.close();
            } else { //otherwise they re-spin the jackpot wheel
                System.out.println("\nSpin the jackpot wheel!");
                jackpotWheel2.jackpotwheel();
            }
        } else if (spinWheel == 8) {
            //win money
            wheelMethods2.winMoney();
        } else if (spinWheel == 9) {
            //lose money
            wheelMethods2.loseMoney();
        } else if (spinWheel == 10) {
            //take money from opponent
            wheelMethods2.takeMoney();
        } else if (spinWheel == 11) {
            //opponent takes their money
            wheelMethods2.moneyTaken();
        } else if (spinWheel == 12) {
            //opponent wins control opponent powerup
            wheelMethods2.playerChoosesToMoveYou();
        } else if (spinWheel == 13) {
            //player loses turn
            wheelMethods2.movingPrevelges();  
        } else if (spinWheel == 14) {
            //player wins a powerup
            wheelMethods2.powerUp();
        }
    }
}