class Solution {
    public int calPoints(String[] operations) {
        List<String> stack = new ArrayList<>();
        for (String s : operations) {
            if (s.equals("+")) {
                int a = Integer.valueOf(stack.get(stack.size() - 1));
                int b = Integer.valueOf(stack.get(stack.size() - 2));
                stack.add(String.valueOf(a + b));
                continue;
            }
            if (s.equals("D")) {
                int a = Integer.valueOf(stack.get(stack.size() - 1));
                stack.add(String.valueOf(2 * a));
                continue;
            }
            if (s.equals("C")) {
                stack.removeLast();
                continue;
            }
            stack.add(s);
        }
        return stack.stream().mapToInt(Integer::valueOf).sum();
    }
}