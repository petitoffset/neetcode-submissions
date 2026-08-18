class Solution {
    public int change(int amount, int[] coins) {
        int M = amount;
        int N = coins.length;
        int[] dp = new int[M + 1];
        for (int a = 0; a <= M; a++) {
            dp[a] = a % coins[N - 1] == 0 ? 1 : 0; 
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int a = 0; a <= M; a++) {
                int skip = dp[a];
                int include = 0;
                if (a - coins[i] >= 0) {
                    include = dp[a - coins[i]];
                }
                dp[a] = skip + include;
            }
        }
        return dp[M];    
    }
}
