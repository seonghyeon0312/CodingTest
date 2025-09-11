import java.util.Scanner;

public class Main {
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        String[][] board = new String[N][M];
        sc.nextLine();
        for(int i=0;i<N;i++){
            String[] temp = sc.nextLine().split("");
            int j=0;
            for(String ch : temp){
                board[i][j++]=ch;
            }
        }

        int size = 8;
        int count = 100;
        for(int i=0;i<=N-size;i++){
            for(int j=0;j<=M-size;j++){
                count = Math.min(count, makeChessBoard(i,j,board));

            }
        }
        System.out.println(count);
    }

    private static int makeChessBoard(int x, int y, String[][] board){
        int count = 0;
        String[] firstLine = new String[8];
        String[] secondLine = new String[8];
        String start = board[x][y];

        if(start.equals("B")){
            for(int i=0;i<8;i++){
                if(i % 2 == 0){
                    firstLine[i]=start;
                    secondLine[i]="W";
                }else{
                    firstLine[i]="W";
                    secondLine[i]=start;
                }
            }
        }else{
            for(int i=0;i<8;i++){
                if(i % 2 == 0){
                    firstLine[i]=start;
                    secondLine[i]="B";
                }else{
                    firstLine[i]="B";
                    secondLine[i]=start;
                }
            }
        }

        for(int i=x;i<x+8;i++){
            if(i%2==0){
                for(int j=0;j<8;j++){
                    if(!board[i][j+y].equals(firstLine[j])) count++;
                }
            }else{
                for(int j=0;j<8;j++){
                    if(!board[i][j+y].equals(secondLine[j])) count++;
                }
            }
        }

        count = Math.min(count, 64-count);

        return count;
    }
}
