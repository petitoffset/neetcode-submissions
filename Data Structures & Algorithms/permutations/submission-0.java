class Solution {
    List<List<Integer>> res;
    boolean[] taken;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        taken = new boolean[nums.length];
        this.nums = nums;

        dfs(0, new ArrayList<>());
        return res;        
    }

    private void dfs(int i, List<Integer> cur) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for (int k = 0; k < taken.length; k++) {
            if (!taken[k]) {
                cur.add(nums[k]);
                taken[k] = true;
                dfs(i + 1, cur);
                cur.removeLast();
                taken[k] = false;
            }
        }
    }
}
