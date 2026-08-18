class Solution {
    public int change(int amount, int[] coins) {
        int[][] cache = new int[coins.length][amount + 1];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                cache[i][j] = -1;
            }
        }
        int res = memoization(0, coins, amount, cache);
        return res;
    }

    public int memoization(int i, int[] coins, int amount, int[][] cache) {
        if (i == coins.length) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }

        if (cache[i][amount] != -1) {
            return cache[i][amount];
        }

        // skip coin i
        cache[i][amount] = memoization(i + 1, coins, amount, cache);

        // take coin i
        int newAmount = amount - coins[i];
        if (newAmount >= 0) {
            int n = memoization(i, coins, newAmount, cache);
            cache[i][amount] += n;
        }
        return cache[i][amount];
    }
}
