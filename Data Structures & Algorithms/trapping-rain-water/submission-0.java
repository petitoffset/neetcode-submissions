class Solution {
    public int trap(int[] height) {
        int size = height.length;
        int[] maxL = new int[size];
        int[] maxR = new int[size];
        maxL[0] = 0;
        maxR[size - 1] = 0;
        for (int i = 1; i < size; i++) {
            maxL[i] = Math.max(maxL[i - 1], height[i - 1]);
        }
        for (int i = size - 2; i >= 0; i--) {
            maxR[i] = Math.max(maxR[i + 1], height[i + 1]);
        }

        int res = 0;
        for (int i = 1; i < size - 1; i++) {
            int tmp = Math.min(maxL[i], maxR[i]) - height[i];
            res += tmp > 0 ? tmp : 0; 
        }
        return res;      
    }
}
