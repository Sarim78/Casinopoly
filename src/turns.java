package src;

public class turns {
    // Creating Objects
    
    player player = new player();

    player2 player2 = new player2();

    // Creating Variables

    public void playerTurn1() {
        System.out.println(player.name + ", it's your turn! What would you like to do?");
        System.out.println("\nPress (H) to view game instructions");
        System.out.println("\nPress (I) to view inventory");
        System.out.println("\nPress (M) to view your current money total");
        System.out.println("\nPress (S) to view what space you're currently on");
        System.out.println("\nPress (R) to roll and begin your turn!");
        playerTurn2();
    }

    public void playerTurn2() {
        System.out.println(player2.name + ", it's your turn! What would you like to do?");
        System.out.println("\nPress (H) to view game instructions");
        System.out.println("\nPress (I) to view inventory");
        System.out.println("\nPress (M) to view your current money total");
        System.out.println("\nPress (S) to view what space you're currently on");
        System.out.println("\nPress (R) to roll and begin your turn!");
        playerTurn1();
    }
}
