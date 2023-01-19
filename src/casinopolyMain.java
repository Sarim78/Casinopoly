package src;

// Game Package File
import game.allorNothing;
import game.blackJack;
import game.cardGame;
import game.casinopolyShop;
import game.chanceWheel;
import game.gameBoard;
import game.giantWheel;
import game.jackpotWheel;
import game.penaltyWheel;
import game.Roulette;
import game.slots;
import game.startAndGo;
import game.wheelMethods;
import game.casinopolyShop2;
import game.giantWheel2;
import game.jail;

// Main Code Of The Game Goes Here
public class casinopolyMain {
    public static void main(String[] args) {

        casinopolyShop casinopolyShop = new casinopolyShop();
        // casinopolyShop.casinopolyshop();

        blackJack blackJack = new blackJack();
        // blackJack.blackjack();
        
        slots slots = new slots();
        // slots.instructions();
        
        cardGame cardGame = new cardGame();
        // cardGame.instructions();

        Roulette Roulette = new Roulette();
       // Roulette.roulette();

        gameBoard gameBoard = new gameBoard();
        //gameBoard.dice();

        chanceWheel chanceWheel = new chanceWheel();
        // chanceWheel.chancewheel();

        penaltyWheel penaltyWheel = new penaltyWheel();
        // penaltyWheel.wheelOfPenalty();

        wheelMethods wheelMethods = new wheelMethods();
        // wheelMethods.advanceStart();

        player player = new player();
        // System.out.println(player.totalSpace);

        giantWheel giantWheel = new giantWheel();
        // giantWheel.giantwheel();

        allorNothing allorNothing = new allorNothing();
        // allorNothing.allOrNothing();

        jackpotWheel jackpotWheel = new jackpotWheel();
        // jackpotWheel.jackpotwheel();

        startAndGo startAndGo = new startAndGo();
        // startAndGo.start();

        jail jail = new jail();
        jail.grettingUserToJail();

        turns turns = new turns();
        turns.gameMenu();

        giantWheel2 giantWheel2 = new giantWheel2();

        casinopolyShop2 casinopolyShop2 = new casinopolyShop2();
    }
}