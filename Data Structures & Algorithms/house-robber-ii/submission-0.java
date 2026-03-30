class Solution {
    public int rob(int[] nums) {
        return Math.max(nums[0] + dfs(2, nums, nums.length - 2, new HashMap<>()), dfs(1, nums, nums.length - 1, new HashMap<>()));        
    }

    public int dfs(int i, int[] nums, int limit, HashMap<Integer, Integer> cache) {
        if (i > limit) {
            return 0;
        }

        if (cache.get(i) != null) {
            return cache.get(i);
        }

        cache.put(i, Math.max(nums[i] + dfs(i + 2, nums, limit, cache), dfs(i + 1, nums, limit, cache)));
        return cache.get(i);
    }
}
