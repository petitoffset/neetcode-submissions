class Solution {
    public int INF;
    public int coinChange(int[] coins, int amount) {
        INF = amount + 1;
        int[][] cache = new int[coins.length][amount + 1];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                cache[i][j] = -1;
            }
        }
        int res = memoization(0, coins, amount, cache);
        return res > amount ? -1 : res;
    }

    public int memoization(int i, int[] coins, int amount, int[][] cache) {
        if (i == coins.length) {
            return INF;
        }
        if (amount == 0) {
            return 0;
        }

        if (cache[i][amount] != -1) {
            return cache[i][amount];
        }

        // skip coin i 
        cache[i][amount] = memoization(i + 1, coins, amount, cache);

        // take coin i 
        int newAmount = amount - coins[i];
        if (newAmount >= 0) {
            int n = 1 + memoization(i, coins, newAmount, cache);
            cache[i][amount] = Math.min(cache[i][amount], n);
        }
        return cache[i][amount];
    }
}
