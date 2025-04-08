import java.util.Scanner;

public class Main{
    static int n,k;
    static int[][] board;
    static int[] weight;
    static int[] values;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        board= new int[k+1][n+1];
        weight = new int[n+1];
        values=new int[n+1];

        for(int i=1;i<=n;i++){
            weight[i]=sc.nextInt();
            values[i]=sc.nextInt();
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++) {
                if(j-weight[i]>=0){
                    board[j][i]=Math.max(board[j][i-1],values[i]+board[j-weight[i]][i-1]);
                }else{
                    board[j][i]=board[j][i-1];
                }
            }
        }


        System.out.println(board[k][n]);
    }
}