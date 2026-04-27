class Solution {
public int INF;
    public int coinChange(int[] coins, int amount) {
        INF = amount + 1;
        int N = coins.length;
        int M = amount;
        int[][] dp = new int[N][M + 1];
        for (int i = 0; i < N; i++) {
            dp[i][0] = 0;
        }
        for (int a = 0; a <= M; a++) {
            if (a % coins[0] == 0) {
                dp[0][a] = a / coins[0];
            } else {
                dp[0][a] = INF;
            }
        }

        for (int i = 1; i < N; i++) {
            for (int a = 0; a <= M; a++) {
                int skip = dp[i - 1][a];
                int include = INF;
                if (a - coins[i] >= 0) {
                    include = 1 + dp[i][a - coins[i]];
                }
                dp[i][a] = Math.min(include, skip);
            }
        }
        int res = dp[N-1][M];
        return res > amount ? -1 : res;
    }
}
