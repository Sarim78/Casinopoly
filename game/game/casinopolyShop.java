package game;

// Importing Libraries 
import java.util.Random;
import java.util.Scanner;

public class casinopolyShop {
    
    //Creating Objects

    Random rnd = new Random();

    giantWheel giantWheel = new giantWheel();

    chanceWheel chanceWheel = new chanceWheel();

    //Creating Variables

    String choice;

    String exitShop = ("\nYou have exited the Casinopoly shop! Sorry to see you go :(");

    int allorNothing;

    boolean allorNothingOption = false;

    String buyingOption;

    String withdraw = ("\nYour purchase has been withdrawn! Heading back to the shop menu...");

    String confirm = ("\nPress anything to confirm this purchase, press N to withdraw");

    String confirmChoice;

    String buyingLimit = ("\nSorry, this item can't be bought more than once. Please buy something else.");

    int timesBoughtGiantWheel = 0;

    int timesBoughtChanceWheel = 0;

    int getoutofJail;

    //Creating Methods

    public void welcome() {
        System.out.println("\nWelcome to the Casinopoly Shop! Would you like to buy anything? Press Y for yes, N for no");
        System.out.println("\nPrices range from 1K to 10K.");
        Scanner in = new Scanner(System.in);
        choice = in.nextLine();
        if (choice.equals("Y") || choice.equals("y")) {
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
        System.out.println("\nCasinopoly Shop Items: ");
        System.out.println("\n1. Buy 1 spin of the Giant Casinopoly Wheel ($1K)");
        System.out.println("\n2. Buy 1 spin of the Chance Wheel ($1K)");
        System.out.println("\n3. Buy a 50% chance of winning a one-time use get out of jail for free card ($2.5K)");
        System.out.println("\n4. Buy a one-time use re-roll powerup ($5K)");
        System.out.println("\n5. Buy a one-time use powerup that allows you to advance 1-5 spaces ($3.5K)");
        System.out.println("\n6. Buy a one-time use powerup that allows you to refuse when you owe the other player ($5K)");
        System.out.println("\n7. Buy a one-time use powerup that allows you to not only refuse when you owe the other player, but now they owe that money to you ($10K)");
        System.out.println("\n8. Buy a one-time use powerup that allows you to re-spin a wheel (works for any wheel) ($10K)");
        System.out.println("\n9. Buy a one-time use powerup that allows you to move the other player 1-3 spaces ($7K)");
        System.out.println("\n10. Buy a lottery ticket:");
        System.out.println("\nA lottery ticket of $1K gives you a 15% chance of winning the $15K jackpot");
        System.out.println("\nA lottery ticket of $2.5K gives you a 15% chance of winning the $30K jackpot");
        System.out.println("\nA lottery ticket of $5K gives you a 15% chance of winning the $50K jackpot");
        System.out.println("\n11. Betting options:");
        System.out.println("\nBetting options are unavailable at this time");
        allorNothing = rnd.nextInt(1,10);
        if (allorNothing == 5) {
            System.out.println("\n12. You also have been given the option to play all or nothing! Risk almost all your money for the chance of doubling your entire total!");
            allorNothingOption = true;
        }
        userInput();
    }

    public void displayBuyingOptions2() {
        System.out.println("\nCasinopoly Shop Items: ");
        System.out.println("\n1. Buy 1 spin of the Giant Casinopoly Wheel ($1K)");
        System.out.println("\n2. Buy 1 spin of the Chance Wheel ($1K)");
        System.out.println("\n3. Buy a 50% chance of winning a one-time use get out of jail for free card ($2.5K)");
        System.out.println("\n4. Buy a one-time use re-roll powerup ($5K)");
        System.out.println("\n5. Buy a one-time use powerup that allows you to advance 1-5 spaces ($3.5K)");
        System.out.println("\n6. Buy a one-time use powerup that allows you to refuse when you owe the other player ($5K)");
        System.out.println("\n7. Buy a one-time use powerup that allows you to not only refuse when you owe the other player, but now they owe that money to you ($10K)");
        System.out.println("\n8. Buy a one-time use powerup that allows you to re-spin a wheel (works for any wheel) ($10K)");
        System.out.println("\n9. Buy a one-time use powerup that allows you to move the other player 1-3 spaces ($7K)");
        System.out.println("\n10. Buy a lottery ticket:");
        System.out.println("\nA lottery ticket of $1K gives you a 15% chance of winning the $15K jackpot");
        System.out.println("\nA lottery ticket of $2.5K gives you a 15% chance of winning the $30K jackpot");
        System.out.println("\nA lottery ticket of $5K gives you a 15% chance of winning the $50K jackpot");
        System.out.println("\n11. Betting options:");
        System.out.println("\nBetting options are unavailable at this time");
        if (allorNothingOption = true) {
            System.out.println("\n12. You also have been given the option to play all or nothing! Risk almost all your money for the chance of doubling your entire total!");
        }
        userInput2();
    }

    public void userInput() {
        System.out.println("\nWhat would you like to buy? Enter the number of your selected choice or press X to exit the shop.");
        Scanner in = new Scanner(System.in);
        buyingOption = in.nextLine();
        giveStuff();
        in.close();
    }

    public void userInput2() {
        System.out.println("\nAnything else? Enter the number of your selected choice or press X to exit the shop.");
        Scanner in = new Scanner(System.in);
        buyingOption = in.nextLine();
        if (buyingOption.equals("1") && timesBoughtGiantWheel > 0) {
            System.out.println(buyingLimit);
            userInput2();
            in.close();
        } else if (buyingOption.equals("2") && timesBoughtChanceWheel > 0) {
            System.out.println(buyingLimit);
            userInput2();
            in.close();
        } else {
            giveStuff();
            in.close();
        }
    }

    public void giveStuff() {
        if (buyingOption.equals("1")) {
            System.out.println("\nYou have bought 1 spin of the Giant Casinopoly wheel for $1K!");
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                displayBuyingOptions2();
                in.close();
            } else {
                giantWheel.giantwheel();
                timesBoughtGiantWheel = timesBoughtGiantWheel + 1;
                displayBuyingOptions2();
                in.close();
            }
        } else if (buyingOption.equals("2")) {
            System.out.println("\nYou have bought 1 spin of the Chance wheel for $1K!");
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                displayBuyingOptions2();
                in.close();
            } else {
                chanceWheel.chancesOfWheel();
                timesBoughtChanceWheel = timesBoughtChanceWheel + 1;
                displayBuyingOptions2();
                in.close();
            }
        } else if (buyingOption.equals("3")) {
            System.out.println("You have bought a 50% chance of winning a one-time use get out of jail for free card for $2.5K!");
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                displayBuyingOptions2();
                in.close();
            } else {
                getoutofJail = rnd.nextInt(1,100);
                if (getoutofJail >= 1 && getoutofJail <= 50) {
                    System.out.println("Congratulations, you won the get out of jail for free card! It will be added to your inventory.");
                    //add it to their inventory
                    displayBuyingOptions2();
                    in.close();
                } else if (getoutofJail >= 51 && getoutofJail <= 100) {
                    System.out.println("Sorry, you didn't win a get out of jail for free card. Better luck next time!");
                    displayBuyingOptions2();
                    in.close();
                }
            }
        } else if (buyingOption.equals("4")) {
            System.out.println("You have bought a one-time use re-roll powerup for $5K!");
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                displayBuyingOptions2();
                in.close();
            } else {
                System.out.println("The re-roll powerup will be added to your inventory.");
                //add it to their inventory
                displayBuyingOptions2();
                in.close();
            }
        } else if (buyingOption.equals("5")) {
            System.out.println("You have bought a one-time use advance spaces powerup for $3.5K!");
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                displayBuyingOptions2();
                in.close();
            } else {
                System.out.println("The advance spaces powerup will be added to your inventory.");
                //add it to their inventory
                displayBuyingOptions2();
                in.close();
            }
        } else if (buyingOption.equals("6")) {
            System.out.println("You have bought a one-time use refuse rent powerup for $5K!");
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                displayBuyingOptions2();
                in.close();
            } else {
                System.out.println("The refuse rent powerup will be added to your inventory.");
                //add it to their inventory
                displayBuyingOptions2();
                in.close();
            }
        } else if (buyingOption.equals("7")) {
            System.out.println("You have bought a one-time use reverse rent powerup for $10K!");
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                displayBuyingOptions2();
                in.close();
            } else {
                System.out.println("The reverse rent powerup will be added to your inventory.");
                //add it to their inventory
                displayBuyingOptions2();
                in.close();
            }
        } else if (buyingOption.equals("8")) {
            System.out.println("You have bought a one-time use re-spin wheel powerup for $10K!");
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                displayBuyingOptions2();
                in.close();
            } else {
                System.out.println("The re-spin wheel powerup will be added to your inventory.");
                //add it to their inventory
                displayBuyingOptions2();
                in.close();
            }
        } else if (buyingOption.equals("9")) {
            System.out.println("You have bought a one-time use re-spin wheel powerup for $10K!");
            System.out.println(confirm);
            Scanner in = new Scanner(System.in);
            confirmChoice = in.nextLine();
            if (confirmChoice.equals("n") || confirmChoice.equals("N")) {
                System.out.println(withdraw);
                displayBuyingOptions2();
                in.close();
            } else {
                System.out.println("The re-spin wheel powerup will be added to your inventory.");
                //add it to their inventory
                displayBuyingOptions2();
                in.close();
            }
        }
    }
}