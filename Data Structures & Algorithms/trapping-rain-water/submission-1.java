class Solution {
    public int trap(int[] height) {
        int L = 0;
        int R = height.length - 1;
        int maxL = height[L];
        int maxR = height[R];
        int res = 0;
        while (L < R) {
            if (maxL <= maxR) {
                L++;
                int tmp = maxL - height[L];
                res += tmp >= 0 ? tmp : 0;
                maxL = Math.max(maxL, height[L]);
            } else {
                R--;
                int tmp = maxR - height[R];
                res += tmp >= 0 ? tmp : 0;
                maxR = Math.max(maxR, height[R]);
            }
        }
        return res;
    }
}
