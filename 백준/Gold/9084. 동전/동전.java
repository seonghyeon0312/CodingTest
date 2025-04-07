import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n-- > 0){
            int k = sc.nextInt();
            int[] coins = new int[k];

            for(int i=0;i<k;i++){
                coins[i] = sc.nextInt();
            }

            int target = sc.nextInt();
            int[] dp = new int[target+1];
            dp[0]=1;

            for(int coin : coins){
                for(int i=coin;i<=target;i++){
                    dp[i]+=dp[i-coin];
                }
            }
            System.out.println(dp[target]);
        }
    }
}