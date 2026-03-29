class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int a = 0; a < nums.length; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue; 
            }

            if (nums[a] > 0) {
                break; 
            }

            int left = a + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[a] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(List.of(nums[a], nums[left], nums[right]));
                    left++; 
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
        
    }
}
