package src;

// Game File
import game.blackJack;
import game.cardGame;
import game.slots;

// Player Data File
import src.ai;
import src.player;
import src.Inventory;
import src.buyingObjects;

// Main Code Of The Game Goes Here
public class main {
    public static void main(String[] args) {

        blackJack.instructions();
        blackJack.dealerPickingCards();
        blackJack.playerWager();
        blackJack.playerPickingCards();

        slots.slotMachine();
        
        cardGame.allMethods();

    }
}