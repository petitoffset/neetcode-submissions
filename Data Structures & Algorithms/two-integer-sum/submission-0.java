class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                result[0] = Math.min(i, map.get(need));
                result[1] = Math.max(i, map.get(need));
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
        
    }
}
