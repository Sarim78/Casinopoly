package Game;

import Src.blackJack;
import Src.slots;

public class Main {
    public static void main(String[] args) {
        
        System.out.println(blackJack.dealerPickingCards());
        
        slots game = new slots();
        game.slotMachine();
    }
}