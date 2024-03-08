package board;

public class Board {
    public int size;
    public char matrix[][];

    public Board(int size, char defaultc) {
        this.size = size;
        matrix = new char [size][size];

        for(int i=0;i<size;i++) {
            for(int j=0;j<size; j++) {
                matrix[i][j] = defaultc;
            }
        }
    }

    public void setconfig(char ch){
        int n = this.size;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                this.matrix[i][j] = ch;
            }
        }        
    }

    public void getconfig(){
        int n = this.size;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(this.matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
