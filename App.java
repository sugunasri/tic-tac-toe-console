import java.util.*;
import player.Player;
import board.Board;
import game.Game;

public class App{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the size of the board: ");
        Board b = new Board(scn.nextInt(),'-');
        Player p1 = new Player();
        Player p2 = new Player();
        Game g1 = new Game(new Player[]{p1,p2}, b);
        g1.play();
        scn.close();
    }
}