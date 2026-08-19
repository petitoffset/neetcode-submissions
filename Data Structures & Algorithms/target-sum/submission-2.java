class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int min = 0;
        int max = 0;
        for (int num : nums) {
            min -= num;
            max += num;
        }
        int N = nums.length;
        int M = max - min;
        int[][] dp = new int[N][M + 1];

        if (target - nums[N - 1] >= min && target - nums[N - 1] <= max) {
            dp[N - 1][target - nums[N - 1] - min] = 1;
        }
        if (target + nums[N - 1] >= min && target + nums[N - 1] <= max) {
            dp[N - 1][target + nums[N - 1] - min] += 1;
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int s = 0; s <= M; s++) {
                if (s - nums[i] >= 0) {
                    dp[i][s] += dp[i + 1][s - nums[i]];
                }
                if (s + nums[i] <= M) {
                    dp[i][s] += dp[i + 1][s + nums[i]];
                }
            }
        }
        return dp[0][-min];        
    }
}
