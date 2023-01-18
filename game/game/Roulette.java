package game;
import java.util.Scanner;
import java.util.Random;
import src.player;
import src.player2;

/**
 * Roulette
 * @author adil
 */

public class Roulette {

    //Creating Objects

    Random rnd = new Random();

    player player = new player();

    player2 player2 = new player2();

    //Creating Variables
    
    int dealerFirstPick;

    int dealerSecondPick;

    int dealerThirdPick;

    int dealerFourthPick;

    int dealerFifthPick;

    int playerPick;

    int playerPick2;

    int playerPick3;

    int playerPick4;

    int playerPick5;

    int playerWinAmount;

    double wager1;

    double wager2;

    double wager3;
    
    double wager4;

    double wager5;

    int maxBet = 4000;

    int minBet = 200;

    double moneyEarnedMax;

    double moneyEarnedMin;

    double moneyLostMax;

    double moneyLostMin;

    double moneyEarned1;

    double moneyEarned2;

    double moneyEarned3;

    double moneyEarned4;

    double moneyEarned5;

    double moneyLost1;

    double moneyLost2;

    double moneyLost3;

    double moneyLost4;

    double moneyLost5;

    double playerEarnings;

    double totalMoneyWon;

    double totalMoneyLost;

    double totalWager;

    double playerNetEarnings;

    String instruction;

    //Creating Methods

    public void player1EarningLosingMoneyRoulette() {
        // Player 1 earning money
        player.playersMoney = player.playersMoney + totalMoneyWon;

        // Player 1 losing money
        player.playersMoney = player.playersMoney - totalMoneyLost;
    }

    public void instructions() {
        System.out.println("\nWelcome to roulette! Enter w for instrcutions, anything else to continue");
        Scanner in = new Scanner(System.in);
        instruction = in.nextLine();
        if (instruction.equals("W") || instruction.equals("w")) {
            System.out.println("\nHere's how to play.");
            System.out.println("\nThe dealer picks 5 numbers, from 1 to 20. You have 5 chances to correctly guess the numbers.");
            System.out.println("\nBefore you guess a number, you will wager a value from 400 to 4000 dollars.");
            System.out.println("\nFor every correct guess, you could win as much as 3 times your wager! But with every incorrect guess, you lose a percentage of what you wagered.");
            dealerPickingNumbers();
            playerWager1();
            in.close();
        } else {
            dealerPickingNumbers();
            playerWager1();
            in.close();
        }
    }

    public void dealerPickingNumbers() {
        dealerFirstPick = rnd.nextInt(1,20);
        dealerSecondPick = rnd.nextInt(1,20);
            while (dealerSecondPick == dealerFirstPick) {
                dealerSecondPick = rnd.nextInt(1,20);
            }
        dealerThirdPick = rnd.nextInt(1,20);
            while (dealerThirdPick == dealerFirstPick || dealerThirdPick == dealerSecondPick) {
                dealerThirdPick = rnd.nextInt(1,20);
            }
        dealerFourthPick = rnd.nextInt(1,20);
            while (dealerFourthPick == dealerFirstPick || dealerFourthPick == dealerSecondPick || dealerFourthPick == dealerThirdPick) {
                dealerFourthPick = rnd.nextInt(1,20);
            }
        dealerFifthPick = rnd.nextInt(1,20);
            while (dealerFifthPick == dealerFirstPick || dealerFifthPick == dealerSecondPick || dealerFifthPick == dealerThirdPick || dealerFifthPick == dealerFourthPick) {
                dealerFifthPick = rnd.nextInt(1,20);
            }
    }

    public void playerWager1() {
        try {
            System.out.println("\nHow much money would you like to wager? (please bet from 400 to 4K)");
            Scanner in = new Scanner(System.in);
            wager1 = in.nextDouble();
            if (wager1 > maxBet) {
                System.out.println("\nYou cannot go over the max bet of $4K! Please enter a value between 1000 and 20000.");
                playerWager1();
            }
            else if (wager1 < minBet) {
                System.out.println("\nYou cannot go under the max bet of $400! Please enter a value between 1000 and 20000.");
                playerWager1();
            }
            else {
                System.out.println("\nYou have wagered " + String.format("$%.2f", wager1).replace("$0.", "$.") + "!");
                playerPickingNumbers1();
                in.close();
            }
        } catch (Exception e) {
            System.out.println("\nInvalid input! Please try again.");
            playerWager1();
        }
    }

    public void playerPickingNumbers1() {
        try {
            System.out.println("\nPick a number from 1 to 20: ");
            Scanner in = new Scanner(System.in);
            playerPick = in.nextInt();
            if (playerPick > 20 || playerPick < 1) {
                System.out.println("\nYou must pick a number from 1 to 20! Please try again.");
                playerPickingNumbers1();
            }
            else if (playerPick == dealerFirstPick || playerPick == dealerSecondPick || playerPick == dealerThirdPick || playerPick == dealerFourthPick || playerPick == dealerFifthPick) {
                System.out.println("\nThere is a match! You have 4 guesses left.");
                moneyEarnedMin = wager1*2.7;
                moneyEarnedMax = wager1*3;
                moneyEarned1 = rnd.nextDouble(moneyEarnedMin, moneyEarnedMax);
                totalMoneyWon = totalMoneyWon + moneyEarned1;
                playerWinAmount = playerWinAmount + 1;
                System.out.println("\nMoney won: " + String.format("$%.2f", moneyEarned1).replace("$0.", "$."));
                playerWager2();
                in.close();
            }
            else if (playerPick != dealerFirstPick || playerPick != dealerSecondPick || playerPick != dealerThirdPick || playerPick != dealerFourthPick || playerPick != dealerFifthPick) {
                System.out.println("\nThere is no match! You have 4 guesses left. ");
                moneyLostMin = 0;
                moneyLostMax = wager1*0.3;
                moneyLost1 = rnd.nextDouble(moneyLostMin, moneyLostMax);
                totalMoneyLost = totalMoneyLost + moneyLost1;
                System.out.println("\nMoney lost: " + String.format("$%.2f", moneyLost1).replace("$0.", "$."));
                playerWager2();
                in.close();
            }
        } catch (Exception e) {
            System.out.println("\nInvalid input! Please try again.");
            playerPickingNumbers1();
        }
    }

    public void playerWager2() {
        try {
            System.out.println("\nHow much money would you like to wager? (please bet from 400 to 4K)");
            Scanner in = new Scanner(System.in);
            wager2 = in.nextDouble();
            if (wager2 > maxBet) {
                System.out.println("\nYou cannot go over the max bet of $4K! Please enter a value between 1000 and 20000.");
                playerWager2();
            }
            else if (wager2 < minBet) {
                System.out.println("\nYou cannot go under the max bet of $400! Please enter a value between 1000 and 20000.");
                playerWager2();
            }
            else {
                System.out.println("\nYou have wagered " + String.format("$%.2f", wager2).replace("$0.", "$.") + "!");
                playerPickingNumbers2();
                in.close();
            }
        } catch (Exception e) {
            System.out.println("\nInvalid input! Please try again.");
            playerWager2();
        }
    }

    public void playerPickingNumbers2() {
        try {
            System.out.println("\nPick a number from 1 to 20: ");
            Scanner in = new Scanner(System.in);
            playerPick2 = in.nextInt();
            if (playerPick2 > 20 || playerPick2 < 1) {
                System.out.println("\nYou must pick a number from 1 to 20! Please try again.");
                playerPickingNumbers2();
            }
            else if (playerPick2 == playerPick) {
                System.out.println("\nYou already guessed this! Please guess a different number.");
                playerPickingNumbers2();
            }
            else if (playerPick2 == dealerFirstPick || playerPick2 == dealerSecondPick || playerPick2 == dealerThirdPick || playerPick2 == dealerFourthPick || playerPick2 == dealerFifthPick) {
                System.out.println("\nThere is a match! You have 3 guesses left.");
                moneyEarnedMin = wager2*2.7;
                moneyEarnedMax = wager2*3;
                moneyEarned2 = rnd.nextDouble(moneyEarnedMin, moneyEarnedMax);
                totalMoneyWon = totalMoneyWon + moneyEarned2;
                System.out.println("\nMoney won: " + String.format("$%.2f", moneyEarned2).replace("$0.", "$."));
                playerWinAmount = playerWinAmount + 1;
                playerWager3();
                in.close();
            }
            else if (playerPick2 != dealerFirstPick || playerPick2 != dealerSecondPick || playerPick2 != dealerThirdPick || playerPick2 != dealerFourthPick || playerPick2 != dealerFifthPick) {
                System.out.println("\nThere is no match! You have 3 guesses left. ");
                moneyLostMin = 0;
                moneyLostMax = wager2*0.3;
                moneyLost2 = rnd.nextDouble(moneyLostMin, moneyLostMax);
                totalMoneyLost = totalMoneyLost + moneyLost2;
                System.out.println("\nMoney lost: " + String.format("$%.2f", moneyLost2).replace("$0.", "$."));
                playerWager3();
                in.close();
            }
        } catch (Exception e) {
            System.out.println("\nInvalid input! Please try again.");
            playerPickingNumbers2();
        }
    }

    public void playerWager3() {
        try {
            System.out.println("\nHow much money would you like to wager? (please bet from 400 to 4K)");
            Scanner in = new Scanner(System.in);
            wager3 = in.nextDouble();
            if (wager3 > maxBet) {
                System.out.println("\nYou cannot go over the max bet of $4K! Please enter a value between 1000 and 20000.");
                playerWager3();
            }
            else if (wager3 < minBet) {
                System.out.println("\nYou cannot go under the max bet of $400! Please enter a value between 1000 and 20000.");
                playerWager3();
            }
            else {
                System.out.println("\nYou have wagered " + String.format("$%.2f", wager3).replace("$0.", "$.") + "!");
                playerPickingNumbers3();
                in.close();
            }
        } catch (Exception e) {
            System.out.println("\nInvalid input! Please try again.");
            playerWager3();
        }
    }

    public void playerPickingNumbers3() {
        try {
            System.out.println("\nPick a number from 1 to 20: ");
            Scanner in = new Scanner(System.in);
            playerPick3 = in.nextInt();
            if (playerPick3 > 20 || playerPick3 < 1) {
                System.out.println("\nYou must pick a number from 1 to 20! Please try again.");
                playerPickingNumbers3();
            }
            else if (playerPick3 == playerPick || playerPick3 == playerPick2) {
                System.out.println("\nYou already guessed this! Please guess a different number.");
                playerPickingNumbers3();
            }
            else if (playerPick3 == dealerFirstPick || playerPick3 == dealerSecondPick || playerPick3 == dealerThirdPick || playerPick3 == dealerFourthPick || playerPick3 == dealerFifthPick) {
                System.out.println("\nThere is a match! You have 2 guesses left.");
                moneyEarnedMin = wager3*2.7;
                moneyEarnedMax = wager3*3;
                moneyEarned3 = rnd.nextDouble(moneyEarnedMin, moneyEarnedMax);
                totalMoneyWon = totalMoneyWon + moneyEarned3;
                System.out.println("\nMoney won: " + String.format("$%.2f", moneyEarned3).replace("$0.", "$."));
                playerWinAmount = playerWinAmount + 1;
                playerWager4();
                in.close();
            }
            else if (playerPick3 != dealerFirstPick || playerPick3 != dealerSecondPick || playerPick3 != dealerThirdPick || playerPick3 != dealerFourthPick || playerPick3 != dealerFifthPick) {
                System.out.println("\nThere is no match! You have 2 guesses left. ");
                moneyLostMin = 0;
                moneyLostMax = wager3*0.3;
                moneyLost3 = rnd.nextDouble(moneyLostMin, moneyLostMax);
                totalMoneyLost = totalMoneyLost + moneyLost3;
                System.out.println("\nMoney lost: " + String.format("$%.2f", moneyLost3).replace("$0.", "$."));
                playerWager4();
                in.close();
            }
        } catch (Exception e) {
            System.out.println("\nInvalid input! Please try again.");
            playerPickingNumbers3();
        }
    }

    public void playerWager4() {
        try {
            System.out.println("\nHow much money would you like to wager? (please bet from 400 to 4K)");
            Scanner in = new Scanner(System.in);
            wager4 = in.nextDouble();
            if (wager4 > maxBet) {
                System.out.println("\nYou cannot go over the max bet of $4K! Please enter a value between 1000 and 20000.");
                playerWager4();
            }
            else if (wager4 < minBet) {
                System.out.println("\nYou cannot go under the max bet of $400! Please enter a value between 1000 and 20000.");
                playerWager4();
            }
            else {
                System.out.println("\nYou have wagered " + String.format("$%.2f", wager4).replace("$0.", "$.") + "!");
                playerPickingNumbers4();
                in.close();
            }
        } catch (Exception e) {
            System.out.println("\nInvalid input! Please try again.");
            playerWager4();
        }
    }

    public void playerPickingNumbers4() {
        try {
            System.out.println("\nPick a number from 1 to 20: ");
            Scanner in = new Scanner(System.in);
            playerPick4 = in.nextInt();
            if (playerPick4 > 20 || playerPick4 < 1) {
                System.out.println("\nYou must pick a number from 1 to 20! Please try again.");
                playerPickingNumbers4();
            }
            else if (playerPick4 == playerPick || playerPick4 == playerPick2 || playerPick4 == playerPick3) {
                System.out.println("\nYou already guessed this! Please guess a different number.");
                playerPickingNumbers4();
            }
            else if (playerPick4 == dealerFirstPick || playerPick4 == dealerSecondPick || playerPick4 == dealerThirdPick || playerPick4 == dealerFourthPick || playerPick4 == dealerFifthPick) {
                System.out.println("\nThere is a match! You have 1 guess left.");
                moneyEarnedMin = wager4*2.7;
                moneyEarnedMax = wager4*3;
                moneyEarned4 = rnd.nextDouble(moneyEarnedMin, moneyEarnedMax);
                totalMoneyWon = totalMoneyWon + moneyEarned4;
                System.out.println("\nMoney won: " + String.format("$%.2f", moneyEarned4).replace("$0.", "$."));
                playerWinAmount = playerWinAmount + 1;
                playerWager5();
                in.close();
            }
            else if (playerPick4 != dealerFirstPick || playerPick4 != dealerSecondPick || playerPick4 != dealerThirdPick || playerPick4 != dealerFourthPick || playerPick4 != dealerFifthPick) {
                System.out.println("\nThere is no match! You have 1 guess left. ");
                moneyLostMin = 0;
                moneyLostMax = wager4*0.3;
                moneyLost4 = rnd.nextDouble(moneyLostMin, moneyLostMax);
                totalMoneyLost = totalMoneyLost + moneyLost4;
                System.out.println("\nMoney lost: " + String.format("$%.2f", moneyLost4).replace("$0.", "$."));
                playerWager5();
                in.close();
            }
        } catch (Exception e) {
            System.out.println("\nInvalid input! Please try again.");
            playerPickingNumbers4();
        }
    }

    public void playerWager5() {
        try {
            System.out.println("\nHow much money would you like to wager? (please bet from 400 to 4K)");
            Scanner in = new Scanner(System.in);
            wager5 = in.nextDouble();
            if (wager5 > maxBet) {
                System.out.println("\nYou cannot go over the max bet of $4K! Please enter a value between 1000 and 20000.");
                playerWager5();
            }
            else if (wager5 < minBet) {
                System.out.println("\nYou cannot go under the max bet of $400! Please enter a value between 1000 and 20000.");
                playerWager5();
            }
            else {
                System.out.println("\nYou have wagered " + String.format("$%.2f", wager5).replace("$0.", "$.") + "!");
                playerPickingNumbers5();
                in.close();
            }
        } catch (Exception e) {
            System.out.println("\nInvalid input! Please try again.");
            playerWager5();
        }
    }

    public void playerPickingNumbers5() {
        try {
            System.out.println("\n This is your last guess! Pick a number from 1 to 20: ");
            Scanner in = new Scanner(System.in);
            playerPick5 = in.nextInt();
            if (playerPick5 > 20 || playerPick5 < 1) {
                System.out.println("\nYou must pick a number from 1 to 20! Please try again.");
                playerPickingNumbers5();
            }
            else if (playerPick5 == playerPick || playerPick5 == playerPick2 || playerPick5 == playerPick3 || playerPick5 == playerPick4) {
                System.out.println("\nYou already guessed this! Please guess a different number.");
                playerPickingNumbers5();
            }
            else if (playerPick5 == dealerFirstPick || playerPick5 == dealerSecondPick || playerPick5 == dealerThirdPick || playerPick5 == dealerFourthPick || playerPick5 == dealerFifthPick) {
                System.out.println("\nThere is a match!");
                moneyEarnedMin = wager5*2.7;
                moneyEarnedMax = wager5*3;
                moneyEarned5 = rnd.nextDouble(moneyEarnedMin, moneyEarnedMax);
                totalMoneyWon = totalMoneyWon + moneyEarned5;
                System.out.println("\nMoney won: " + String.format("$%.2f", moneyEarned5).replace("$0.", "$."));
                playerWinAmount = playerWinAmount + 1;
                finalDisplay();
                in.close();
            }
            else if (playerPick5 != dealerFirstPick || playerPick5 != dealerSecondPick || playerPick5 != dealerThirdPick || playerPick5 != dealerFourthPick || playerPick5 != dealerFifthPick) {
                System.out.println("\nThere is no match!");
                moneyLostMin = 0;
                moneyLostMax = wager5*0.3;
                moneyLost5 = rnd.nextDouble(moneyLostMin, moneyLostMax);
                totalMoneyLost = totalMoneyLost + moneyLost5;
                System.out.println("\nMoney lost: " + String.format("$%.2f", moneyLost5).replace("$0.", "$."));
                finalDisplay();
                in.close();
            }
        } catch (Exception e) {
            System.out.println("\nInvalid input! Please try again.");
            playerPickingNumbers5();
        }
    }

    public void finalDisplay() {
        System.out.println("\nTotal times won: " + playerWinAmount);
        totalWager = wager1 + wager2 + wager3 + wager4 + wager5;
        System.out.println("\nTotal money wagered: " + String.format("$%.2f", totalWager).replace("$0.", "$."));
        playerEarnings = totalMoneyWon - totalMoneyLost;
        playerNetEarnings = totalWager + playerEarnings;
        totalMoneyWon = playerNetEarnings - totalWager;
        totalMoneyLost = totalWager - playerNetEarnings;
        if (playerEarnings >= 0) {
            System.out.println("\nYou won " + String.format("$%.2f", totalMoneyWon).replace("$0.", "$.") + "!");
            System.out.println(String.format("$%.2f", playerNetEarnings).replace("$0.", "$.") + " will be added to your total.");
        }
        else if (playerEarnings < 0) {
            System.out.println("\nYou lost " + String.format("$%.2f", totalMoneyLost).replace("$0.", "$.") + "!");
            System.out.println(String.format("$%.2f", playerNetEarnings).replace("$0.", "$.") + " will be added to your total.");
        }
    }

    public void roulette() {
        instructions();
    }

}
