class Solution {
    public int change(int amount, int[] coins) {
        int M = amount;
        int N = coins.length;
        int[] prev = new int[M + 1];
        for (int a = 0; a <= M; a++) {
            prev[a] = a % coins[N - 1] == 0 ? 1 : 0; 
        }

        for (int i = N - 2; i >= 0; i--) {
            int[] cur = new int[M + 1];
            for (int a = 0; a <= M; a++) {
                int skip = prev[a];
                int include = 0;
                if (a - coins[i] >= 0) {
                    include = cur[a - coins[i]];
                }
                cur[a] = skip + include;
            }
            prev = cur;
        }
        return prev[M];    
    }
}
