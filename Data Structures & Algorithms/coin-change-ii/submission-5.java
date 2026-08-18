class Solution {
    public int change(int amount, int[] coins) {
        int M = amount;
        int N = coins.length;
        int[] dp = new int[M + 1];
        dp[0] = 1;

        for (int i = N - 1; i >= 0; i--) {
            for (int a = coins[i]; a <= M; a++) {
                dp[a] += dp[a - coins[i]];
            }
        }
        return dp[M];    
    }
}
