package game;

// Importing Libraries 
import java.util.Random;
import java.util.Scanner;

import src.player;

/**
 * start space
 * @author adil
 */

public class startAndGo {

    // Creating Objects 
    Random rnd = new Random();

    Scanner in = new Scanner(System.in);

    player player = new player();

    // Creating Variables

    String landingMoney = ("\nYou have landed on GO! Collect another $2000"); //they get 2000 for landing on go

    String passGO = ("\nYou passed GO, collect $2000!"); //and also 2000 if they cross go

    // Creating Methods 

    public void start() {
        System.out.println(landingMoney);
        src.player.gameEarnings = src.player.gameEarnings + 2000; //if they land on go, they get the 2K for crossing and another 2K for landing
        player.bankAccount();
    }
    
    public void passGo() {
        System.out.println(passGO);
        src.player.gameEarnings = src.player.gameEarnings + 2000; //adding money to bank account
        player.bankAccount();
    }
}