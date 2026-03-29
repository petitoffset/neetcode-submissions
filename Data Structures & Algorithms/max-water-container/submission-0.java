class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxS = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                maxS = Math.max(maxS, (right - left) * height[left]);
                left++;
            } else {
                maxS = Math.max(maxS, (right - left) * height[right]);
                right--;
            }
        }
        return maxS;
        
    }
}
