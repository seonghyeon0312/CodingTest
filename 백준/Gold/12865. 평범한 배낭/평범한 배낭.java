import java.util.Scanner;

public class Main {
    static int n, k;
    static int[] weight;
    static int[] value;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        weight = new int[n + 1];
        value = new int[n + 1];
        dp = new int[k + 1]; // 무게가 최대 k인 경우까지

        for (int i = 1; i <= n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = k; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        System.out.println(dp[k]);
    }
}