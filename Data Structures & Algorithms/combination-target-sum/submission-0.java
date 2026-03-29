class Solution {
    int[] candidates;
    int target;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        res = new ArrayList<>();
        dfs(0, new ArrayList<>(), 0);
        return res;        
    }

    public void dfs(int i, List<Integer> cur, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (i >= candidates.length || sum > target) {
            return;
        }

        cur.add(candidates[i]);
        dfs(i, cur, sum + candidates[i]);
        cur.removeLast();
        dfs(i + 1, cur, sum);
    }
}
