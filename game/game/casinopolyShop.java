package game;

// Importing Libraries 
import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;

public class casinopolyShop {
    
    //Creating Objects

    Random rnd = new Random();

    //giantWheel giantWheel = new giantWheel();

    //chanceWheel chanceWheel = new chanceWheel();

    allorNothing allorNothing = new allorNothing();

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
            in.close();
        } else if (choice.equals("N") || choice.equals("n")) {
            System.out.println(exitShop);
            in.close();
        } else {
            System.out.println("Please enter either Y or N.");
            welcome();
            in.close();
        }
    }

    public void displayBuyingOptions() {
        if (shopCounter > 0) {
            System.out.println("\nAnything else you would like to buy? Enter the number of your selected choice or press X to exit the shop.");
            System.out.println("\nRemember, you can only make 5 purchases!");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nCasinopoly Shop Items: ");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n1. Buy 1 spin of the Giant Casinopoly Wheel ($1K)");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n2. Buy 1 spin of the Chance Wheel ($1K)");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n3. Buy a 50% chance of winning a one-time use get out of jail for free card ($2.5K)");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n4. Buy a one-time use re-roll powerup ($5K)");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n5. Buy a one-time use powerup that allows you to advance 1-5 spaces ($3.5K)");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n6. Buy a one-time use powerup that allows you to refuse when you owe the other player ($5K)");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n7. Buy a one-time use powerup that allows you to not only refuse when you owe the other player, but now they owe that money to you ($10K)");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n8. Buy a one-time use powerup that allows you to re-spin a wheel (works for any wheel) ($10K)");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n9. Buy a one-time use powerup that allows you to move the other player 1-3 spaces ($7K)");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n10. Buy a one-time use powerup that allows you to put the other player in jail ($12.5K)");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n11. Buy a lottery ticket:");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nA lottery ticket of $1K gives you a 15% chance of winning the $15K jackpot");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nA lottery ticket of $2.5K gives you a 15% chance of winning the $30K jackpot");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nA lottery ticket of $5K gives you a 15% chance of winning the $50K jackpot");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n12. Betting options:");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nBetting options are unavailable at this time");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (allOrNothing > 0) {
            System.out.println("\n13. You also have been given the option to play all or nothing! Risk almost all your money for the chance of doubling your entire total!");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        userInput();
    }

    public void userInput() {
        message = ("\nWhat would you like to buy? Enter the number of your selected choice or press X to exit the shop. You can only make 5 purchases!");
        
        if (shopCounter == 0) {
            System.out.println(message);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Scanner in = new Scanner(System.in);
        buyingOption = in.nextLine();
        if (buyingOption.equals("1") && timesBoughtGiantWheel > 0) {
            System.out.println(buyingLimit);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            userInput();
            in.close();
        } else if (buyingOption.equals("2") && timesBoughtChanceWheel > 0) {
            System.out.println(buyingLimit);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            userInput();
            in.close();
        } else if (buyingOption.equals("13") && allOrNothing == 5 && allorNothingCounter > 0) {
            System.out.println(buyingLimit);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            userInput();
            in.close();
        } else if (shopCounter > 5) {
            exitShop();
            in.close();
        } else {
            giveStuff();
            in.close();
        }
    }

    public void giveStuff() {
        if (buyingOption.equals("1")) {
            System.out.println("\nYou have bought 1 spin of the Giant Casinopoly wheel for $1K!");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            } else {
                //giantWheel.giantwheel();
                System.out.println(confirmPurchase);
                timesBoughtGiantWheel = timesBoughtGiantWheel + 1;
                shopCounter = shopCounter + 1;
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            }
        } else if (buyingOption.equals("2")) {
            System.out.println("\nYou have bought 1 spin of the Chance wheel for $1K!");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            } else {
                //chanceWheel.chancesOfWheel();
                System.out.println(confirmPurchase);
                timesBoughtChanceWheel = timesBoughtChanceWheel + 1;
                shopCounter = shopCounter + 1;
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            }
        } else if (buyingOption.equals("3")) {
            System.out.println("\nYou have bought a 50% chance of winning a one-time use get out of jail for free card for $2.5K!");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            } else {
                System.out.println(confirmPurchase);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                shopCounter = shopCounter + 1;
                getoutofJail = rnd.nextInt(1,100);
                if (getoutofJail >= 1 && getoutofJail <= 50) {
                    System.out.println("\nCongratulations, you won the get out of jail for free card! It will be added to your inventory.");
                    //add it to their inventory
                } else if (getoutofJail >= 51 && getoutofJail <= 100) {
                    System.out.println("\nSorry, you didn't win a get out of jail for free card. Better luck next time!");
                }
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            }
        } else if (buyingOption.equals("4")) {
            System.out.println("\nYou have bought a one-time use re-roll powerup for $5K!");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            } else {
                System.out.println(confirmPurchase);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("\nThe re-roll powerup will be added to your inventory.");
                //add it to their inventory
                shopCounter = shopCounter + 1;
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            }
        } else if (buyingOption.equals("5")) {
            System.out.println("\nYou have bought a one-time use advance spaces powerup for $3.5K!");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            } else {
                System.out.println(confirmPurchase);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("\nThe advance spaces powerup will be added to your inventory.");
                //add it to their inventory
                shopCounter = shopCounter + 1;
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            }
        } else if (buyingOption.equals("6")) {
            System.out.println("\nYou have bought a one-time use refuse rent powerup for $5K!");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            } else {
                System.out.println(confirmPurchase);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("\nThe refuse rent powerup will be added to your inventory.");
                //add it to their inventory
                shopCounter = shopCounter + 1;
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            }
        } else if (buyingOption.equals("7")) {
            System.out.println("\nYou have bought a one-time use reverse rent powerup for $10K!");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            } else {
                System.out.println(confirmPurchase);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("\nThe reverse rent powerup will be added to your inventory.");
                //add it to their inventory
                shopCounter = shopCounter + 1;
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            }
        } else if (buyingOption.equals("8")) {
            System.out.println("\nYou have bought a one-time use re-spin wheel powerup for $10K!");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            } else {
                System.out.println(confirmPurchase);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("\nThe re-spin wheel powerup will be added to your inventory.");
                //add it to their inventory
                shopCounter = shopCounter + 1;
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            }
        } else if (buyingOption.equals("9")) {
            System.out.println("\nYou have bought a one-time use control opponent powerup for $10K!");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            } else {
                System.out.println(confirmPurchase);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("\nThe control opponent powerup will be added to your inventory.");
                //add it to their inventory
                shopCounter = shopCounter + 1;
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            }
        } else if (buyingOption.equals("10")) {
            System.out.println("\nYou have bought a one-time use jail sentence powerup for $12.5K!");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            } else {
                System.out.println(confirmPurchase);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("\nThe jail sentence powerup will be added to your inventory.");
                //add it to their inventory
                shopCounter = shopCounter + 1;
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            } 
        } else if (buyingOption.equals("11")) {
            System.out.println("\nYou have decided to buy one of the three lottery tickets!");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            } else {
                System.out.println(confirmPurchase);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                shopCounter = shopCounter + 1;
                lotteryTickets();
                in.close();
            } 
        } else if (buyingOption.equals("12")) {
            System.out.println("\nYou have decided to wager on the game!");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            } else {
                System.out.println(confirmPurchase);
                System.out.println("no betting lol");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            } 
        } else if (buyingOption.equals("13") && allOrNothing > 0) {
            System.out.println("\nYou have decided to go ALL OR NOTHING");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            } else {
                System.out.println(confirmPurchase);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                allorNothingCounter = allorNothingCounter + 1;
                shopCounter = shopCounter + 1;
                allorNothing.allOrNothing();
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                displayBuyingOptions();
                in.close();
            } 
        } else if (buyingOption.equals("X") || buyingOption.equals("x")) {
            System.out.println(exitShop);
        } else {
            System.out.println("\nInvalid input! Please try again");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            displayBuyingOptions();
        }
    }

    public void lotteryTickets() {
        System.out.println("\nWhich lottery ticket would you like to purchase? Enter the number please");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n1. $1K lottery ticket, 15% chance of winning the $15K jackpot");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n2. $2.5K lottery ticket, 15% chance of winning the $30K jackpot");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n3. $5K lottery ticket, 15% chance of winning the $50K jackpot");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Scanner in = new Scanner(System.in);
        ticketChoice = in.nextLine();
        if (ticketChoice.equals("1")) {
            System.out.println("You bought the $1K lottery ticket! Will today be your lucky day...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lotteryTicket1 = rnd.nextInt(1,100);
            if (lotteryTicket1 <= 15) {
                System.out.println(bigWinner);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("\n$15K will be added to your total.");
            } else if (lotteryTicket1 > 15) {
                System.out.println(bigLoser);
            }
        } else if (ticketChoice.equals("2")) {
            System.out.println("You bought the $2.5K lottery ticket! Will today be your lucky day...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lotteryTicket2 = rnd.nextInt(1,100);
            if (lotteryTicket2 <= 15) {
                System.out.println(bigWinner);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("\n$30K will be added to your total.");
            } else if (lotteryTicket2 > 15) {
                System.out.println(bigLoser);
            }
        } else if (ticketChoice.equals("3")) {
            System.out.println("You bought the $5K lottery ticket! Will today be your lucky day...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lotteryTicket3 = rnd.nextInt(1,100);
            if (lotteryTicket3 <= 15) {
                System.out.println(bigWinner);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("\n$50K will be added to your total.");
            } else if (lotteryTicket3 > 15) {
                System.out.println(bigLoser);
            }
        } else {
            System.out.println("Invalid input! Please try again.");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lotteryTickets();
            in.close();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        displayBuyingOptions();
        in.close();
    }

    public void exitShop() {
        System.out.println("\nWoah, slow down! You have reached the max purchase limit. This means you can no longer make any more purchases.");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nWould you like to exit the shop? Press anything to confirm.");
        Scanner in = new Scanner(System.in);
        plsExit = in.nextLine();
        if (plsExit != null) {
            System.out.println(exitShop);
            in.close();
        }
    }

    public void casinopolyshop() {
        welcome();
    }
    
}