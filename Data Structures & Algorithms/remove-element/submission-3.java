class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            while (l < r && nums[l] != val) {
                l++;
            }

            while (l < r && nums[r] == val) {
                r--;
            }

            if (l == r) {
                return nums[l] == val ? l : l + 1;
            }

            int tmp = nums[r];
            nums[r] = nums[l];
            nums[l] = tmp;

            l++;
            r--;
        }

        return nums[l] == val ? l : l + 1;
    }
}