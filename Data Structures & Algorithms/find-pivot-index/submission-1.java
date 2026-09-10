class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int left = 0;
        int right = sum - nums[0];
        int pivot = 0;

        while (pivot < nums.length) {
            if (left == right) {
                return pivot;
            }

            left += nums[pivot];
            pivot++;

            if (pivot < nums.length) {
                right -= nums[pivot];
            }
        }

        return -1;
    }
}