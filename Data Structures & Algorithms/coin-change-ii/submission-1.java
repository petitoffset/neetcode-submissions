class Solution {
    public int change(int amount, int[] coins) {
        int M = amount;
        int N = coins.length;
        int[][] dp = new int[N][M + 1];
        for (int a = 0; a <= M; a++) {
            dp[N - 1][a] = a % coins[N - 1] == 0 ? 1 : 0; 
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int a = 0; a <= M; a++) {
                int skip = dp[i + 1][a];
                int include = 0;
                if (a - coins[i] >= 0) {
                    include = dp[i][a - coins[i]];
                }
                dp[i][a] = skip + include;
            }
        }
        return dp[0][M];    
    }
}
