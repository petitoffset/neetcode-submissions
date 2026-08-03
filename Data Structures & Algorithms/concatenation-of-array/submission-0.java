class Solution {
    public int[] getConcatenation(int[] nums) {
        int l = nums.length;
        int[] nums2 = new int[l * 2];
        for (int i = 0; i < l; i++) {
            nums2[i] = nums[i];
            nums2[i + l] = nums[i];
        }
        return nums2;
        
    }
}