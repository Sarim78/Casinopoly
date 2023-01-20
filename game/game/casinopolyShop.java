package game;

// Importing Libraries 
import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;

// Importing Files
import src.inventory1;
import src.player;

/**
 * Casinopoly Shop
 * @author adil
 */

public class casinopolyShop {
    
    //Creating Objects

    Random rnd = new Random();

    giantWheel giantWheel = new giantWheel();

    chanceWheel chanceWheel = new chanceWheel();

    allorNothing allorNothing = new allorNothing();

    inventory1 inventory1 = new inventory1();

    player player = new player();

    //Creating Variables

    String choice; //do they want to enter the shop/buy anything

    String exitShop = ("\nYou have exited the Casinopoly shop! Sorry to see you go :("); //exiting shop message

    int allOrNothing; //the all or nothing option lottery

    String buyingOption; //what they want to buy

    String withdraw = ("\nYour purchase has been withdrawn! Heading back to the shop menu..."); //withdrawing purchase message

    String confirm = ("\nPress anything to confirm this purchase, press N to withdraw"); //confirming purchase message

    String confirmChoice; //whether they want to confirm or withdraw

    String buyingLimit = ("\nSorry, this item can't be bought more than once. Please buy something else."); //buying limit reached message

    int timesBoughtGiantWheel = 0; //the # of times they bought giant wheel spin

    int timesBoughtChanceWheel = 0; //the # of time they bought chance wheel spin

    int getoutofJail; //lottery for whether they win a get out of jail for free card or not

    String ticketChoice; //their lottery ticket choice

    int lotteryTicket1; //ticket 1 lottery

    int lotteryTicket2; //ticket 2 lottery

    int lotteryTicket3; //ticket 3 lottery

    String bigWinner = ("\nCongratulations, today is your lucky day! You won the lottery!"); //message if they win lottery

    String bigLoser = ("\nSorry, the lottery balls were not in your favour today. Better luck next time!"); //message if they lose lottery

    String message; //what would you like to buy message

    int shopCounter = 0; //amount of items purchased

    String confirmPurchase = ("\nPurchase confirmed!"); //message for a confirmed purchase
    
    int allorNothingCounter = 0; //amount of times purchased all or nothing

    String plsExit; //whatever they enter when they are kicked out of the shop

    //Creating Methods

    //the message as you enter the shop, asks if they want to buy anything
    public void welcome() {
        System.out.println("\nWelcome to the Casinopoly Shop! Would you like to buy anything? Press Y for yes, N for no");
        System.out.println("\nPrices range from 1K to 10K.");
        Scanner in = new Scanner(System.in);
        choice = in.nextLine();
        //if they do then show them what they can buy and enter them into a chance to win all or nothing option
        if (choice.equals("Y") || choice.equals("y")) {
            allOrNothing = rnd.nextInt(1,10);
            displayBuyingOptions();
            //in.close();
            //if they don't then leave shop
        } else if (choice.equals("N") || choice.equals("n")) {
            System.out.println(exitShop);
            //in.close();
            //they have to do Y or N
        } else {
            System.out.println("Please enter either Y or N.");
            welcome();
            //in.close();
        }
    }

    //showing the player all the shop has to offer
    public void displayBuyingOptions() {
        //if they bought at least one item, then it asks if they want to buy anything else and reminds them of the purchase limit
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
        //5 is the magic number, if all or nothing is 5 then they win the option to play the game
        if (allOrNothing == 5) {
            System.out.println("\n13. You also have been given the option to play all or nothing! Risk almost all your money for the chance of doubling your entire total! ($10K)");
            sleep300();
        }
        userInput();
    }

    //now we ask the player what they want, they have to enter the number of their selected choice
    public void userInput() {
        message = ("\nWhat would you like to buy? Enter the number of your selected choice or press X to exit the shop. You can only make 5 purchases!");
        //show this message if they haven't bought anything yet, otherwise the other message would be shown
        if (shopCounter == 0) {
            System.out.println(message);
            sleep300();
        }
        //here's where they enter their selected choice
        Scanner in = new Scanner(System.in);
        buyingOption = in.nextLine();
        //the three following items have purchase limits of 1, so if they already bought it then they can't again
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
            //only trigger this else if statement if allornothing was something they could've bought
        } else if (buyingOption.equals("13") && allOrNothing == 5 && allorNothingCounter > 0) {
            System.out.println(buyingLimit);
            sleep300();
            userInput();
            //in.close();
            //force them to leave the shop if they surpass the purchase limit
        } else if (shopCounter > 5) {
            exitShop();
            //in.close();
            //otherwise just let them buy what they want
        } else {
            giveStuff();
            //in.close();
        }
    }

    //here's where we give them what they want
    public void giveStuff() {
        if (buyingOption.equals("1")) {
            //buying giant wheel spin
            System.out.println("\nYou have bought 1 spin of the Giant Casinopoly wheel for $1K!");
            sleep300();
            System.out.println(confirm); //every item has this to make sure they get what they wanted to buy
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            //if they didn't want to buy an item, then they can go back to the shop menu
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                sleep1500();
                displayBuyingOptions();
                //in.close();
            } else {
                //otherwise the purchase will be made, and bank account gets affected
                System.out.println(confirmPurchase);
                sleep300();
                timesBoughtGiantWheel = timesBoughtGiantWheel + 1; //because this item has a purchase limit
                shopCounter = shopCounter + 1; //items bought get tracked like this
                src.player.gameEarnings = src.player.gameEarnings - 1000; //bank account gets affected like this
                player.bankAccount();
                giantWheel.giantwheel();
                sleep1500();
                displayBuyingOptions();
                //in.close();
            }
        } else if (buyingOption.equals("2")) {
            //buying chance wheel spin
            System.out.println("\nYou have bought 1 spin of the Chance wheel for $1K!");
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
                timesBoughtChanceWheel = timesBoughtChanceWheel + 1; //item has purchase limit
                shopCounter = shopCounter + 1;
                src.player.gameEarnings = src.player.gameEarnings - 1000;
                player.bankAccount();
                chanceWheel.chancesOfWheel();
                sleep1500();
                displayBuyingOptions();
                //in.close();
            }
        } else if (buyingOption.equals("3")) {
            //buying get out of jail free card
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
            //buying reroll powerup
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
            //buying advance spaces powerup
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
            //buying refuse rent powerup
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
            //buying reverse rent powerup
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
            //buying re-spin wheel powerup
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
            //buying control opponent powerup
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
            //buying jail sentence powerup
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
            //buying a lottery ticket
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
                lotteryTickets(); //there's a seperate method for lottery tickets
                //in.close();
            } 
        } else if (buyingOption.equals("12")) {
            //betting on the game isn't available yet, so nothing happens if you choose this
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
            //buy allornothing as long as they did win the option
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
                //you need at least 20K to play, and it costs 10K to play from the shop, so at least 30K total
                System.out.println("Sorry, you don't have enough money to play all or nothing");
                displayBuyingOptions();
            } else {
                System.out.println(confirmPurchase);
                sleep300();
                allorNothingCounter = allorNothingCounter + 1; //purchase limit for this item
                shopCounter = shopCounter + 1;
                src.player.gameEarnings = src.player.gameEarnings - 10000;
                player.bankAccount();
                allorNothing.allOrNothing();
                sleep1500();
                displayBuyingOptions();
                //in.close();
            } 
        } else if (buyingOption.equals("X") || buyingOption.equals("x")) {
            //if they want to leave they can
            System.out.println(exitShop);
        } else {
            System.out.println("\nInvalid input! Please try again");
            sleep1500();
            displayBuyingOptions();
        }
    }

    //here is the method for lottery tickets
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
        //they select a lottery ticket here
        ticketChoice = in.nextLine();
        if (ticketChoice.equals("1")) {
            System.out.println("You bought the $1K lottery ticket! Will today be your lucky day...");
            src.player.gameEarnings = src.player.gameEarnings - 1000;
            sleep3000();
            lotteryTicket1 = rnd.nextInt(1,100);
            if (lotteryTicket1 <= 15) { //15% chance to win, here is if they do win
                System.out.println(bigWinner);
                sleep300();
                System.out.println("\n$15K will be added to your total.");
                src.player.gameEarnings = src.player.gameEarnings + 15000;
                player.bankAccount();
            } else if (lotteryTicket1 > 15) { //here is where if they lose
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

    //if you reached the max purchase limit you are banished here
    public void exitShop() {
        System.out.println("\nWoah, slow down! You have reached the max purchase limit. This means you can no longer make any more purchases.");
        sleep300();
        System.out.println("\nWould you like to exit the shop? Press anything to confirm."); //they can either exit the shop or stare at the screen
        Scanner in = new Scanner(System.in);
        plsExit = in.nextLine();
        if (plsExit != null) { //as long as the scanner wasn't null they are kicked out of the shop
            System.out.println(exitShop);
            //in.close();
        }
    }

    //how the class is called
    public void casinopolyshop() {
        welcome();
    }

    //the rest are just sleep methods that make the text animated
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