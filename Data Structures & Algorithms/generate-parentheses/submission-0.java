class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtracking(n, n, new ArrayDeque<Character>(), new StringBuilder(), res);
        return res;        
    }

    private void backtracking(int open, int close, Deque<Character> stack, 
        StringBuilder cur, List<String> res) {
        if (open == 0 && close == 0) {
            if (stack.isEmpty()) {
                res.add(cur.toString());
            }
            return;
        }
        
        if (open > 0) {
            cur.append("(");
            stack.push('(');
            backtracking(open - 1, close, stack, cur, res);
            cur.deleteCharAt(cur.length() - 1);
            stack.pop();
        }

        if (close > 0) {
            if (!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
                cur.append(')');
                backtracking(open, close - 1, stack, cur, res);
                cur.deleteCharAt(cur.length() - 1);
                stack.push('(');
            }
        }
    }
}
