package src;

// Game Package File
import game.blackJack;
import game.cardGame;
import game.chanceWheel;
import game.slots;
import game.Roulette;
import game.gameBoard;
import game.penaltyWheel;
// Main Code Of The Game Goes Here
public class main {
    public static void main(String[] args) {

        blackJack.blackJack();

        slots.slotMachine();
        
        cardGame.cardgame();

        Roulette.roulette();

        gameBoard.dice();

        chanceWheel.chancesOfWheel();

        penaltyWheel.wheelOfPenalty();
    }
}