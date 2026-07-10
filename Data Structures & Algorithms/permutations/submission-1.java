class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] taken = new boolean[nums.length];
        List<Integer> cur = new ArrayList<>();

        dfs(nums, taken, cur, res);
        return res;        
    }

    private void dfs(int[] nums, boolean[] taken, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() >= nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for (int k = 0; k < taken.length; k++) {
            if (!taken[k]) {
                cur.add(nums[k]);
                taken[k] = true;
                dfs(nums, taken, cur, res);
                cur.removeLast();
                taken[k] = false;
            }
        }
    }
}
