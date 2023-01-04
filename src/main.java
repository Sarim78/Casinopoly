package src;

// Game File
import game.blackJack;
import game.cardGame;
import game.chanceWheel;
import game.slots;
import game.Roulette;
import game.gameBoard;

// Player Data File
import src.ai;
import src.player;
import src.player2;
import src.Inventory;
import src.buyingObjects;

// Main Code Of The Game Goes Here
public class main {
    public static void main(String[] args) {

        blackJack.blackJack();

        slots.slotMachine();
        
        cardGame.cardgame();

        Roulette.roulette();

        gameBoard.dice();

        chanceWheel.chancesOfWheel();
    }
}