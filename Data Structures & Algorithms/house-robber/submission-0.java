class Solution {
    public int rob(int[] nums) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        return dfs(0, nums, cache);        
    }

    public int dfs(int i, int[] nums, HashMap<Integer, Integer> cache) {
        if (i > nums.length - 1) {
            return 0;
        }

        if (cache.get(i) != null) {
            return cache.get(i);
        }

        cache.put(i, Math.max(nums[i] + dfs(i + 2, nums, cache), dfs(i + 1, nums, cache)));
        return cache.get(i);
    }
}
