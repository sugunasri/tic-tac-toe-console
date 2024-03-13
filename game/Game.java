package game;

import board.Board;

import java.util.Random;
import java.util.Scanner;
import player.Player;

public class Game{
    Player[] players;
    Board board;
    int turn;
    int moves;
    boolean over;
    String s1;
    String s2;

    public Game(Player[] players,Board board){
        Random random = new Random();
        this.turn = random.nextInt(2);
        this.players = players;
        this.board = board;
        this.moves = 0;
        this.over = false;

        StringBuilder t1 = new StringBuilder();
        StringBuilder t2 = new StringBuilder();

        for(int i =0;i<board.size;i++){
            t1.append(players[0].getSymbol());
            t2.append(players[1].getSymbol());
        }

        this.s1 = t1.toString();
        this.s2 = t2.toString();
    }

    public void printconfig(){
        int n = this.board.size;
        for(int i=0;i<n;i++){
            for (int j = 0; j < n; j++) {
                System.out.print(this.board.matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    // Get the position
    public int getindex(){
        Scanner scn = new Scanner(System.in);
        while(true){
            System.out.println("Player: "+players[turn].getName()+" give one place");
            int place = scn.nextInt();
            place -= 1;

            int n = this.board.size;

            int row = place/n;
            int col = place%n;

            if(row<0 || row>=n || col<0 || col>=n){
                System.out.println("Invalid position");
                continue;
            }

            if(this.board.matrix[row][col] != '-'){
                System.out.println("Position is already occupied");
                continue;
            }
            // scn.close();
            return place;

        }
    }

    //checking possiblities
    public boolean checkcombinations(){
        int n = this.board.size;
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(this.board.matrix[i][j]);
            }
            String pattern = sb.toString();
            if(pattern.equals(s1) || pattern.equals(s2)){
                return true;
            }
        }

        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(this.board.matrix[j][i]);
            }
            String pattern = sb.toString();
            if(pattern.equals(s1) || pattern.equals(s2)){
                return true;
            }
        }

        int i=0,j=0;
        StringBuilder sb = new StringBuilder();
        while (i<n){
            sb.append(this.board.matrix[i][j]);
            i++;j++;            
        }
        String pattern = sb.toString();
        if(pattern.equals(s1) || pattern.equals(s2)){
            return true;
        }
        i=0;j=n-1;
        sb = new StringBuilder();

        while(i<n){
            sb.append(this.board.matrix[i][j]);
            i++;j--;
        }
        pattern = sb.toString();
        if(pattern.equals(s1) || pattern.equals(s2)){
            return true;
        }

        return false;
    }

    public void play(){
        printconfig();
        int n = this.board.size;
        Scanner scn = new Scanner(System.in);
        while (!over) {
            int index = getindex();
            moves++;
            int row = index/n;
            int col = index%n;

            this.board.matrix[row][col] = players[turn].getSymbol();
            if (moves >= 2*n-1 && checkcombinations() == true) {
                over = true;
                printconfig();
                System.out.println("----GAME ENDS----");
                System.out.println("Winner is: " + players[turn].getName());
                System.out.println();


                System.out.print("Want to play one more game?(Y/N): ");
                char ch = scn.nextLine().charAt(0);

                
                if(Character.toLowerCase(ch) == 'y'){
                    Random random = new Random();
                    this.turn = random.nextInt(2);
                    this.moves = 0;
                    this.over = false;
                    this.board.setconfig('-');
                    play();
                }else{
                    return;
                }
                return;
            }
            if (moves >= n*n) {
                printconfig();
                System.out.println("----Game Draw----");
                
                System.out.print("Want to play one more game?(Y/N): ");
                char ch = scn.nextLine().charAt(0);

                if(Character.toLowerCase(ch) == 'y'){
                    Random random = new Random();
                    this.turn = random.nextInt(2);
                    this.moves = 0;
                    this.over = false;
                    this.board.setconfig('-');
                    play();
                }else{
                    return;
                }
            }

             

            turn  = (turn +1)%2;
            printconfig();
        }
    }
}