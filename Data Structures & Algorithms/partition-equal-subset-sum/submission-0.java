class Solution {
    public boolean canPartition(int[] nums) {
        int N = nums.length;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        if (nums[0] <= sum) {
            dp[nums[0]] = true;
        }

        for (int i = 1; i < N; i++) {
            for (int s = sum; s >= nums[i]; s--) {
                dp[s] |= dp[s - nums[i]];
            }
            if (dp[sum]) return true;
        }
        return dp[sum];  
    }
}
