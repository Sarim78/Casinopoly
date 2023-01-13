package src;

// Game Package File
import game.blackJack;
import game.cardGame;
import game.chanceWheel;
import game.slots;
import game.Roulette;
import game.allorNothing;
import game.gameBoard;
import game.penaltyWheel;
import game.wheelMethods;

// Main Code Of The Game Goes Here
public class casinopolyMain {

    public static void main(String[] args) {

        allorNothing allorNothing = new allorNothing();
        allorNothing.allOrNothing();
/** 
        blackJack blackJack = new blackJack();
        blackJack.blackjack();
        
        slots slots = new slots();
        slots.slotMachine();
        
        cardGame cardGame = new cardGame();
        cardGame.cardgame();

        Roulette Roulette = new Roulette();
        Roulette.roulette();

        gameBoard gameBoard = new gameBoard();
        gameBoard.dice();

        chanceWheel chanceWheel = new chanceWheel();
        chanceWheel.chancesOfWheel();

        penaltyWheel penaltyWheel = new penaltyWheel();
        penaltyWheel.wheelOfPenalty();

        wheelMethods wheelMethods = new wheelMethods();
        wheelMethods.advanceToNearestGame();
        /* */
    }
}