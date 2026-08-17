class Solution {
    public int maxProfit(int[] prices) {
        // first column buy, second column sell
        int[][] cache = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(cache[i], -1);
        }

        return dfs(prices, 0, true, cache);        
    }

    public int dfs(int[] prices, int i, boolean buying, int[][] cache) {
        if (i > prices.length - 1) {
            return 0;
        }

        if (buying && cache[i][0] != -1) {
            return cache[i][0];
        }
        if (!buying && cache[i][1] != -1) {
            return cache[i][1];
        }

        int skip = dfs(prices, i + 1, buying, cache);
        if (buying) {
            int buy = dfs(prices, i + 1, false, cache) - prices[i];
            cache[i][0] = Math.max(skip, buy);
            return cache[i][0];
        } else {
            int sell = prices[i] + dfs(prices, i + 2, true, cache);
            cache[i][1] = Math.max(skip, sell);
            return cache[i][1];
        }
    }
}
