class Solution {
    public int maxProduct(int[] nums) {
        int curMaxProd = nums[0];
        int curMinProd = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int a = nums[i];
            int b = curMinProd * nums[i];
            int c = curMaxProd * nums[i];
            curMinProd = Math.min(a, Math.min(b, c));
            curMaxProd = Math.max(a, Math.max(b, c));
            max = Math.max(curMaxProd, max);
        }
        return max; 
    }
}