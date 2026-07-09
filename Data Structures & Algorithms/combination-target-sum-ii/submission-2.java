class Solution {
    int[] candidates;
    int target;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        res = new ArrayList<>();
        Arrays.sort(candidates);
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

        // add current
        cur.add(candidates[i]);
        dfs(i + 1, cur, sum + candidates[i]);
        cur.removeLast();

        // skip current and all its duplicates
        int next = i + 1;
        while (next < candidates.length && candidates[next] == candidates[i]) {
            next++;
        }

        dfs(next, cur, sum);
    }
}

