class Solution {
    public int INF;
    public int coinChange(int[] coins, int amount) {
        INF = amount + 1;
        int res = dfs(0, coins, amount);
        return res > amount ? -1 : res;
    }

    public int dfs(int i, int[] coins, int amount) {
        if (i == coins.length) {
            return INF;
        }
        if (amount == 0) {
            return 0;
        }
        // skip coin i 
        int minNum = dfs(i + 1, coins, amount);

        // take coin i 
        int newAmount = amount - coins[i];
        if (newAmount >= 0) {
            int n = 1 + dfs(i, coins, newAmount);
            minNum = Math.min(minNum, n);
        }
        return minNum;
    }
}
