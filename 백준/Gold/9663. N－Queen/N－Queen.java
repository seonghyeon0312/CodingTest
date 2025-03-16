import java.util.*;

import static java.lang.Math.abs;

public class Main {

    static int N;
    static int count=0;
    static boolean[] column, diag1, diag2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N= sc.nextInt();
        column = new boolean[N];
        diag1 = new boolean[2*N-1];
        diag2 = new boolean[2*N-1];

        dfs(0);

        System.out.println(count);
    }

    public static void dfs(int row){
        if(row==N){
            count++;
            return;
        }

        for(int col=0;col<N;col++){
            if(!column[col] && !diag1[row+col] && !diag2[row-col+(N-1)]){
                column[col] = diag1[row+col] = diag2[row-col+(N-1)] = true;

                dfs(row+1);

                column[col] = diag1[row+col] = diag2[row-col+(N-1)] = false;
            }
        }
    }
}