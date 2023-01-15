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

        blackJack blackJack = new blackJack();
        blackJack.blackjack();
>>>>>>> a95ed53c86eef0e74c15d1c1609bd889bcc6371a
        
        // slots slots = new slots();
        // slots.instructions();
        
        cardGame cardGame = new cardGame();
        cardGame.instructions();

        // Roulette Roulette = new Roulette();
        // Roulette.roulette();

        // gameBoard gameBoard = new gameBoard();
        // gameBoard.dice();

        // chanceWheel chanceWheel = new chanceWheel();
        // chanceWheel.chancesOfWheel();

<<<<<<< HEAD
        // penaltyWheel penaltyWheel = new penaltyWheel();
        // penaltyWheel.wheelOfPenalty();
=======
        penaltyWheel penaltyWheel = new penaltyWheel();
        penaltyWheel.wheelOfPenalty();
    }
}