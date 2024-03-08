import java.util.*;

import board.Board;

public class App{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the size of the board: ");
        Board b = new Board(scn.nextInt(),'-');

        scn.close();
    }
}