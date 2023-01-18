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
import game.umbrella;

// Main Code Of The Game Goes Here
public class casinopolyMain {
    public static void main(String[] args) {

        casinopolyShop casinopolyShop = new casinopolyShop();
        //casinopolyShop.casinopolyshop();

        blackJack blackJack = new blackJack();
        //blackJack.blackjack();
        
        slots slots = new slots();
        //slots.instructions();
        
        cardGame cardGame = new cardGame();
        //cardGame.instructions();

        Roulette Roulette = new Roulette();
        //Roulette.roulette();

        gameBoard gameBoard = new gameBoard();
        //gameBoard.dice();

        chanceWheel chanceWheel = new chanceWheel();
        //chanceWheel.chancewheel();

        penaltyWheel penaltyWheel = new penaltyWheel();
        //penaltyWheel.wheelOfPenalty();

        wheelMethods wheelMethods = new wheelMethods();
        //wheelMethods.advanceStart();

        player player = new player();
        //System.out.println(player.totalSpace);

        giantWheel giantWheel = new giantWheel();
        //giantWheel.giantwheel();

        allorNothing allorNothing = new allorNothing();
        //allorNothing.allOrNothing();

        jackpotWheel jackpotWheel = new jackpotWheel();
        //jackpotWheel.jackpotwheel();

        startAndGo startAndGo = new startAndGo();
        //startAndGo.start();

        turns turns = new turns();
        //turns.noNamefornow();
        //turns.playerTurn1();

        umbrella umbrella = new umbrella();
    }
}