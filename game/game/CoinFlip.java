// package game;

// import java.util.Scanner;
// import java.lang.Math;

// /**
//  * Coin Flip
//  * @author Tyrell
//  */

// public class CoinFlip {
//     public void coin() {
//         Scanner input = new Scanner(System.in);
//         int money = 10;
//         double flip = Math.random();
//         String heads = "heads";
//         String tails = "tails";
//         int bet = input.nextInt();
    
//         while(bet < 0 || bet > money){
//             if(true){
//                 System.out.println("How much do you want to bet?");
//                 input.next();
//             }
//         }
    
//         System.out.println("Guess if the coin will be heads or tails.");
//         String guess = input.next();
    
//         String coin;
//         if (flip <0.5) coin = heads;
//         else coin = tails;
    
//         if(guess == coin){
//             int correct = money + bet;
//             System.out.println("The flip was"+ coin);
//             System.out.println("You win" + bet);
//             System.out.println("");
//             }
//     }
// }