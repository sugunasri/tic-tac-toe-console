import java.util.*;
import player.Player;
import board.Board;
import game.Game;

public class App{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the size of the board: ");
        Board b = new Board(scn.nextInt(),'-');
        System.out.println("Enter the details of player 1:");
        Player player1 = new Player();
        System.out.println("Enter the details of player 2:");
        Player player2 = new Player();

        // Player p1 = new Player("suguna sri","9876543210",18,"kothapeta","sugna@mail.com",'X');
        // Player p2 = new Player("bhagavan","0123456789",22,"kothapeta","bhagavan@mail.com",'O');

        
        Game g1 = new Game(new Player[]{player1,player2}, b);
        g1.play();
        // scn.close();
    }
}