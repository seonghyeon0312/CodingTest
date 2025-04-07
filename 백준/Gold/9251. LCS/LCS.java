import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.next().split("");
        String[] str2 = sc.next().split("");

        int row = str1.length;
        int col = str2.length;

        int[][] dp = new int[row+1][col+1];

        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(str1[i-1].equals(str2[j-1])){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[row][col]);

    }
}