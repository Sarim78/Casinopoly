package game;

// Importing Libraries 
import java.util.Random;
import java.util.Scanner;

import src.player;

/**
 * start
 * @athuor adil
 */

public class startAndGo {

    // Creating Objects 
    Random rnd = new Random();

    Scanner in = new Scanner(System.in);

    player player = new player();

    // Creating Variables

    String landingMoney = ("\nYou have landed on GO! Collect $4000");

    String passGO = ("\nYou passed GO, collect $2000!");

    // Creating Methods 

    public void start() {
        System.out.println(landingMoney);
        player.gameEarnings = player.gameEarnings + 4000;
        player.bankAccount();
    }
    
    public void passGo() {
        System.out.println(passGO);
        player.gameEarnings = player.gameEarnings + 2000;
        player.bankAccount();
    }
}