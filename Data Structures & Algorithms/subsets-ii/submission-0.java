class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, new ArrayList<>(), nums, res);
        return res;  
    }

    public void dfs(int i, List<Integer> cur, int[] nums, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList(cur));
            return;
        }

        // add current
        cur.add(nums[i]);
        dfs(i + 1, cur, nums, res);
        cur.removeLast();

        // skip current and all its duplicates
        int next = i + 1;
        while (next < nums.length && nums[next] == nums[i]) {
            next++;
        }

        dfs(next, cur, nums, res);
    }


}
