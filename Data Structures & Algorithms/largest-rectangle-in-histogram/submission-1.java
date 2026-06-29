class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>(); // [index, height]
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] popped = stack.pop();
                maxArea = Math.max(maxArea, (i - popped[0]) * popped[1]);
                start = popped[0];
            }
            stack.push(new int[]{start, heights[i]});
        }
        while (!stack.isEmpty()) {
            int[] popped = stack.pop();
            maxArea = Math.max(maxArea, (heights.length - popped[0]) * popped[1]);
            }
        return maxArea;    
    }
}
