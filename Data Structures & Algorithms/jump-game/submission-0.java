class Solution {
    public boolean canJump(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return memoization(nums, 0, cache);        
    }

    public boolean memoization(int[] nums, int i, int[] cache) {
        if (i >= nums.length - 1) {
            return true;
        }

        if (cache[i] != -1) {
            return cache[i] == 1;
        }

        cache[i] = 0;

        cache[i] = memoization(nums, i + nums[i], cache) ? 1 : 0;
        if (cache[i] == 1) {
            return true;
        }

        for (int j = nums[i] - 1; j > 0; j--) {
            cache[i] = memoization(nums, i + j, cache) ? 1 : 0;
            if (cache[i] == 1) {
                return true;
            }
        }

        return cache[i] == 1;
    }
}
