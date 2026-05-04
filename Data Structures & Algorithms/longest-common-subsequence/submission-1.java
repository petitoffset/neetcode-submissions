class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int N = s1.length(), M = s2.length();
        int[] dp = new int[M + 1];

        for (int i = 0; i < N; i++) {
            int[] curRow = new int[M + 1];
            for (int j = 0; j < M; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    curRow[j+1] = 1 + dp[j];
                } else {
                    curRow[j+1] = Math.max(dp[j + 1], curRow[j]);
                }
            }
            dp = curRow;
        }
        return dp[M];
    }
}

