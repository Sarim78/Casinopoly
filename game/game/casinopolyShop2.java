package game;

// Importing Libraries 
import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;

// Importing Files
import src.inventory1;
import src.player;

/**
 * Casinopoly Shop (the exact same thing but from the chance wheel, so you can't go back to the chance wheel from here)
 * This was made to avoid a stack overflow error
 * @author adil
 */

public class casinopolyShop2 {
    
    //Creating Objects

    Random rnd = new Random();

    giantWheel2 giantWheel2 = new giantWheel2();

    allorNothing allorNothing = new allorNothing();

    inventory1 inventory1 = new inventory1();

    player player = new player();

    //Creating Variables

    String choice;

    String exitShop = ("\nYou have exited the Casinopoly shop! Sorry to see you go :(");

    int allOrNothing;

    String buyingOption;

    String withdraw = ("\nYour purchase has been withdrawn! Heading back to the shop menu...");

    String confirm = ("\nPress anything to confirm this purchase, press N to withdraw");

    String confirmChoice;

    String buyingLimit = ("\nSorry, this item can't be bought more than once. Please buy something else.");

    int timesBoughtGiantWheel = 0;

    int timesBoughtChanceWheel = 0;

    int getoutofJail;

    String ticketChoice;

    int lotteryTicket1;

    int lotteryTicket2;

    int lotteryTicket3;

    String bigWinner = ("\nCongratulations, today is your lucky day! You won the lottery!");

    String bigLoser = ("\nSorry, the lottery balls were not in your favour today. Better luck next time!");

    String message;

    int shopCounter = 0;

    String confirmPurchase = ("\nPurchase confirmed!");
    
    int allorNothingCounter = 0;

    String plsExit;

    //Creating Methods

    public void welcome() {
        System.out.println("\nWelcome to the Casinopoly Shop! Would you like to buy anything? Press Y for yes, N for no");
        System.out.println("\nPrices range from 1K to 10K.");
        Scanner in = new Scanner(System.in);
        choice = in.nextLine();
        if (choice.equals("Y") || choice.equals("y")) {
            allOrNothing = rnd.nextInt(1,10);
            displayBuyingOptions();
            //in.close();
        } else if (choice.equals("N") || choice.equals("n")) {
            System.out.println(exitShop);
            //in.close();
        } else {
            System.out.println("Please enter either Y or N.");
            welcome();
            //in.close();
        }
    }

    public void displayBuyingOptions() {
        if (shopCounter > 0) {
            System.out.println("\nAnything else you would like to buy? Enter the number of your selected choice or press X to exit the shop.");
            System.out.println("\nRemember, you can only make 5 purchases!");
            sleep1500();
        }
        System.out.println("\nCasinopoly Shop Items: ");
        sleep100();
        System.out.println("\n1. Buy 1 spin of the Giant Casinopoly Wheel ($1K)");
        sleep100();
        System.out.println("\n2. Buy 1 spin of the Chance Wheel ($1K)");
        sleep100();
        System.out.println("\n1. Buy a 50% chance of winning a one-time use get out of jail for free card ($2.5K)");
        sleep100();
        System.out.println("\n4. Buy a one-time use re-roll powerup ($5K)");
        sleep100();
        System.out.println("\n5. Buy a one-time use powerup that allows you to advance 1-5 spaces ($1.5K)");
        sleep100();
        System.out.println("\n6. Buy a one-time use powerup that allows you to refuse when you owe the other player ($5K)");
        sleep100();
        System.out.println("\n7. Buy a one-time use powerup that allows you to not only refuse when you owe the other player, but now they owe that money to you ($10K)");
        sleep100();
        System.out.println("\n8. Buy a one-time use powerup that allows you to re-spin a wheel (works for any wheel) ($10K)");
        sleep100();
        System.out.println("\n9. Buy a one-time use powerup that allows you to move the other player 1-3 spaces ($7K)");
        sleep100();
        System.out.println("\n10. Buy a one-time use powerup that allows you to put the other player in jail ($12.5K)");
        sleep100();
        System.out.println("\n11. Buy a lottery ticket:");
        sleep100();
        System.out.println("\nA lottery ticket of $1K gives you a 15% chance of winning the $15K jackpot");
        sleep100();
        System.out.println("\nA lottery ticket of $2.5K gives you a 15% chance of winning the $10K jackpot");
        sleep100();
        System.out.println("\nA lottery ticket of $5K gives you a 15% chance of winning the $50K jackpot");
        sleep100();
        System.out.println("\n12. Betting options:");
        sleep100();
        System.out.println("\nBetting options are unavailable at this time");
        sleep100();
        if (allOrNothing == 5) {
            System.out.println("\n13. You also have been given the option to play all or nothing! Risk almost all your money for the chance of doubling your entire total! ($10K)");
            sleep300();
        }
        userInput();
    }

    public void userInput() {
        message = ("\nWhat would you like to buy? Enter the number of your selected choice or press X to exit the shop. You can only make 5 purchases!");
        
        if (shopCounter == 0) {
            System.out.println(message);
            sleep300();
        }
        Scanner in = new Scanner(System.in);
        buyingOption = in.nextLine();
        if (buyingOption.equals("1") && timesBoughtGiantWheel > 0) {
            System.out.println(buyingLimit);
            sleep300();
            userInput();
            //in.close();
        } else if (buyingOption.equals("2") && timesBoughtChanceWheel > 0) {
            System.out.println(buyingLimit);
            sleep300();
            userInput();
            //in.close();
        } else if (buyingOption.equals("13") && allOrNothing == 5 && allorNothingCounter > 0) {
            System.out.println(buyingLimit);
            sleep300();
            userInput();
            //in.close();
        } else if (shopCounter > 5) {
            exitShop();
            //in.close();
        } else {
            giveStuff();
            //in.close();
        }
    }

    public void giveStuff() {
        if (buyingOption.equals("1")) {
            System.out.println("\nYou have bought 1 spin of the Giant Casinopoly wheel for $1K!");
            sleep300();
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                sleep1500();
                displayBuyingOptions();
                //in.close();
            } else {
                System.out.println(confirmPurchase);
                sleep300();
                timesBoughtGiantWheel = timesBoughtGiantWheel + 1;
                shopCounter = shopCounter + 1;
                src.player.gameEarnings = src.player.gameEarnings - 1000;
                player.bankAccount();
                giantWheel2.giantwheel();
                sleep1500();
                displayBuyingOptions();
                //in.close();
            }
        } else if (buyingOption.equals("2")) {
            System.out.println("\nYou were just in the chance wheel! Please buy something else");
            sleep300();
            displayBuyingOptions();
        } else if (buyingOption.equals("3")) {
            System.out.println("\nYou have bought a 50% chance of winning a one-time use get out of jail for free card for $2.5K!");
            sleep300();
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                sleep1500();
                displayBuyingOptions();
                //in.close();
            } else {
                System.out.println(confirmPurchase);
                sleep300();
                shopCounter = shopCounter + 1;
                src.player.gameEarnings = src.player.gameEarnings - 2500;
                player.bankAccount();
                getoutofJail = rnd.nextInt(1,100);
                if (getoutofJail >= 1 && getoutofJail <= 50) {
                    System.out.println("\nCongratulations, you won the get out of jail for free card! It will be added to your inventory.");
                    inventory1.getOutOfJailFreeCard = inventory1.getOutOfJailFreeCard + 1; //add it to their inventory
                } else if (getoutofJail >= 51 && getoutofJail <= 100) {
                    System.out.println("\nSorry, you didn't win a get out of jail for free card. Better luck next time!");
                }
                sleep1500();
                displayBuyingOptions();
                //in.close();
            }
        } else if (buyingOption.equals("4")) {
            System.out.println("\nYou have bought a one-time use re-roll powerup for $5K!");
            sleep300();
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                sleep1500();
                displayBuyingOptions();
                //in.close();
            } else {
                System.out.println(confirmPurchase);
                sleep300();
                System.out.println("\nThe re-roll powerup will be added to your inventory.");
                inventory1.reroll = inventory1.reroll + 1; //add it to their inventory
                shopCounter = shopCounter + 1;
                src.player.gameEarnings = src.player.gameEarnings - 5000;
                player.bankAccount();
                sleep1500();
                displayBuyingOptions();
                //in.close();
            }
        } else if (buyingOption.equals("5")) {
            System.out.println("\nYou have bought a one-time use advance spaces powerup for $3.5K!");
            sleep300();
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                sleep1500();
                displayBuyingOptions();
                //in.close();
            } else {
                System.out.println(confirmPurchase);
                sleep300();
                System.out.println("\nThe advance spaces powerup will be added to your inventory.");
                inventory1.advanceSpaces = inventory1.advanceSpaces + 1; //add it to their inventory
                shopCounter = shopCounter + 1;
                src.player.gameEarnings = src.player.gameEarnings - 3500;
                player.bankAccount();
                sleep1500();
                displayBuyingOptions();
                //in.close();
            }
        } else if (buyingOption.equals("6")) {
            System.out.println("\nYou have bought a one-time use refuse rent powerup for $5K!");
            sleep300();
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                sleep1500();
                displayBuyingOptions();
                //in.close();
            } else {
                System.out.println(confirmPurchase);
                sleep300();
                System.out.println("\nThe refuse rent powerup will be added to your inventory.");
                inventory1.refuseRent = inventory1.refuseRent + 1; //add it to their inventory
                shopCounter = shopCounter + 1;
                src.player.gameEarnings = src.player.gameEarnings - 5000;
                player.bankAccount();
                sleep1500();
                displayBuyingOptions();
                //in.close();
            }
        } else if (buyingOption.equals("7")) {
            System.out.println("\nYou have bought a one-time use reverse rent powerup for $10K!");
            sleep300();
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                sleep1500();
                displayBuyingOptions();
                //in.close();
            } else {
                System.out.println(confirmPurchase);
                sleep300();
                System.out.println("\nThe reverse rent powerup will be added to your inventory.");
                inventory1.reverseRent = inventory1.reverseRent + 1; //add it to their inventory
                shopCounter = shopCounter + 1;
                src.player.gameEarnings = src.player.gameEarnings - 10000;
                player.bankAccount();
                sleep1500();
                displayBuyingOptions();
                //in.close();
            }
        } else if (buyingOption.equals("8")) {
            System.out.println("\nYou have bought a one-time use re-spin wheel powerup for $10K!");
            sleep300();
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                sleep1500();
                displayBuyingOptions();
                //in.close();
            } else {
                System.out.println(confirmPurchase);
                sleep300();
                System.out.println("\nThe re-spin wheel powerup will be added to your inventory.");
                inventory1.reSpin = inventory1.reSpin + 1; //add it to their inventory
                shopCounter = shopCounter + 1;
                src.player.gameEarnings = src.player.gameEarnings - 10000;
                player.bankAccount();
                sleep1500();
                displayBuyingOptions();
                //in.close();
            }
        } else if (buyingOption.equals("9")) {
            System.out.println("\nYou have bought a one-time use control opponent powerup for $10K!");
            sleep300();
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                sleep1500();
                displayBuyingOptions();
                //in.close();
            } else {
                System.out.println(confirmPurchase);
                sleep300();
                System.out.println("\nThe control opponent powerup will be added to your inventory.");
                inventory1.controlOpponent = inventory1.controlOpponent + 1; //add it to their inventory
                shopCounter = shopCounter + 1;
                src.player.gameEarnings = src.player.gameEarnings - 10000;
                player.bankAccount();
                sleep1500();
                displayBuyingOptions();
                //in.close();
            }
        } else if (buyingOption.equals("10")) {
            System.out.println("\nYou have bought a one-time use jail sentence powerup for $12.5K!");
            sleep300();
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                sleep1500();
                displayBuyingOptions();
                //in.close();
            } else {
                System.out.println(confirmPurchase);
                sleep300();
                System.out.println("\nThe jail sentence powerup will be added to your inventory.");
                inventory1.jailSentence = inventory1.jailSentence + 1; //add it to their inventory
                shopCounter = shopCounter + 1;
                src.player.gameEarnings = src.player.gameEarnings - 12500;
                player.bankAccount();
                sleep1500();
                displayBuyingOptions();
                //in.close();
            } 
        } else if (buyingOption.equals("11")) {
            System.out.println("\nYou have decided to buy one of the three lottery tickets!");
            sleep300();
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                sleep1500();
                displayBuyingOptions();
                //in.close();
            } else {
                System.out.println(confirmPurchase);
                sleep300();
                shopCounter = shopCounter + 1;
                lotteryTickets();
                //in.close();
            } 
        } else if (buyingOption.equals("12")) {
            System.out.println("\nYou have decided to wager on the game!");
            sleep300();
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                sleep1500();
                displayBuyingOptions();
                //in.close();
            } else {
                System.out.println(confirmPurchase);
                System.out.println("no betting lol");
                sleep1500();
                displayBuyingOptions();
                //in.close();
            } 
        } else if (buyingOption.equals("13") && allOrNothing == 5) {
            System.out.println("\nYou have decided to go ALL OR NOTHING");
            sleep300();
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                sleep1500();
                displayBuyingOptions();
                //in.close();
            } else if (src.player.gameEarnings < 30000) {
                System.out.println("Sorry, you don't have enough money to play all or nothing");
                displayBuyingOptions();
            } else {
                System.out.println(confirmPurchase);
                sleep300();
                allorNothingCounter = allorNothingCounter + 1;
                shopCounter = shopCounter + 1;
                src.player.gameEarnings = src.player.gameEarnings - 10000;
                player.bankAccount();
                allorNothing.allOrNothing();
                sleep1500();
                displayBuyingOptions();
                //in.close();
            } 
        } else if (buyingOption.equals("X") || buyingOption.equals("x")) {
            System.out.println(exitShop);
        } else {
            System.out.println("\nInvalid input! Please try again");
            sleep1500();
            displayBuyingOptions();
        }
    }

    public void lotteryTickets() {
        System.out.println("\nWhich lottery ticket would you like to purchase? Enter the number please");
        sleep300();
        System.out.println("\n1. $1K lottery ticket, 15% chance of winning the $15K jackpot");
        sleep300();
        System.out.println("\n2. $2.5K lottery ticket, 15% chance of winning the $30K jackpot");
        sleep300();
        System.out.println("\n3. $5K lottery ticket, 15% chance of winning the $50K jackpot");
        sleep300();
        Scanner in = new Scanner(System.in);
        ticketChoice = in.nextLine();
        if (ticketChoice.equals("1")) {
            System.out.println("You bought the $1K lottery ticket! Will today be your lucky day...");
            src.player.gameEarnings = src.player.gameEarnings - 1000;
            sleep3000();
            lotteryTicket1 = rnd.nextInt(1,100);
            if (lotteryTicket1 <= 15) {
                System.out.println(bigWinner);
                sleep300();
                System.out.println("\n$15K will be added to your total.");
                src.player.gameEarnings = src.player.gameEarnings + 15000;
                player.bankAccount();
            } else if (lotteryTicket1 > 15) {
                System.out.println(bigLoser);
                player.bankAccount();
            }
        } else if (ticketChoice.equals("2")) {
            System.out.println("You bought the $2.5K lottery ticket! Will today be your lucky day...");
            src.player.gameEarnings = src.player.gameEarnings - 2500;
            sleep3000();
            lotteryTicket2 = rnd.nextInt(1,100);
            if (lotteryTicket2 <= 15) {
                System.out.println(bigWinner);
                sleep300();
                System.out.println("\n$30K will be added to your total.");
                src.player.gameEarnings = src.player.gameEarnings + 30000;
                player.bankAccount();
            } else if (lotteryTicket2 > 15) {
                System.out.println(bigLoser);
                player.bankAccount();
            }
        } else if (ticketChoice.equals("3")) {
            System.out.println("You bought the $5K lottery ticket! Will today be your lucky day...");
            src.player.gameEarnings = src.player.gameEarnings - 5000;
            sleep3000();
            lotteryTicket3 = rnd.nextInt(1,100);
            if (lotteryTicket3 <= 15) {
                System.out.println(bigWinner);
                sleep300();
                System.out.println("\n$50K will be added to your total.");
                src.player.gameEarnings = src.player.gameEarnings + 50000;
                player.bankAccount();
            } else if (lotteryTicket3 > 15) {
                System.out.println(bigLoser);
                player.bankAccount();
            }
        } else {
            System.out.println("Invalid input! Please try again.");
            sleep300();
            lotteryTickets();
            //in.close();
        }
        sleep2000();
        displayBuyingOptions();
        //in.close();
    }

    public void exitShop() {
        System.out.println("\nWoah, slow down! You have reached the max purchase limit. This means you can no longer make any more purchases.");
        sleep300();
        System.out.println("\nWould you like to exit the shop? Press anything to confirm.");
        Scanner in = new Scanner(System.in);
        plsExit = in.nextLine();
        if (plsExit != null) {
            System.out.println(exitShop);
            //in.close();
        }
    }

    public void casinopolyshop() {
        welcome();
    }

    public void sleep3000() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sleep300() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sleep1500() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sleep100() {
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sleep2000() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}