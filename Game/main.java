package Game;

import Src.blackJack;
import Src.slots;
import Src.cardGame;

public class main {
    public static void main(String[] args) {

        blackJack.instructions();
        blackJack.dealerPickingCards();
        blackJack.playerWager();
        blackJack.playerPickingCards();

        slots.slotMachine();

        cardGame.HiLo();

    }
}