class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char stacked = stack.pop();
                if (!(c == ']' && stacked == '[' || c == ')' && stacked == '(' || c == '}' && stacked == '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
        
    }
}
