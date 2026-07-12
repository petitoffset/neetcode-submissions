class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtracking(n, n, new StringBuilder(), res);
        return res;        
    }

    private void backtracking(int open, int close, StringBuilder cur, List<String> res) {
        if (open == 0 && close == 0) {
            res.add(cur.toString());
            return;
        }
        
        if (open > 0) {
            cur.append("(");
            backtracking(open - 1, close, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (close > open) {
            cur.append(')');
            backtracking(open, close - 1, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}