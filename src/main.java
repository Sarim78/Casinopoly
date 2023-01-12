package src;

// Game Package File
import game.blackJack;
import game.cardGame;
import game.chanceWheel;
import game.slots;
import game.wheelMethods;
import game.Roulette;
import game.gameBoard;
import game.penaltyWheel;

// Main Code Of The Game Goes Here
public class main {
    public static void main(String[] args) {

        blackJack blackJack = new blackJack();
        blackJack.blackJack();

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
    }
}