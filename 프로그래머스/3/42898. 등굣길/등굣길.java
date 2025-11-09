import java.io.*;
import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        
        boolean[][] blocked = new boolean[n + 1][m + 1];
        for (int[] p : puddles) {
            int x = p[0];
            int y = p[1];
            if (1 <= y && y <= n && 1 <= x && x <= m) {
                blocked[y][x] = true;
            }
        }

        int[][] dp = new int[n + 1][m + 1];
        if (!blocked[1][1]) dp[1][1] = 1;  

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                if (r == 1 && c == 1) continue;
                if (blocked[r][c]) {
                    dp[r][c] = 0;
                } else {
                    int fromUp = dp[r - 1][c];
                    int fromLeft = dp[r][c - 1];
                    dp[r][c] = (int)(((long)fromUp + fromLeft) % MOD);
                }
            }
        }
        return dp[n][m];
    }
}