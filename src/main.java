package src;

import game.blackJack;
import game.cardGame;
import game.slots;

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