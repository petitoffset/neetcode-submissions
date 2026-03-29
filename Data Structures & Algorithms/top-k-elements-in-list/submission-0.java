class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> array[] = new List[nums.length + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = new ArrayList<Integer>();
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            array[entry.getValue()].add(entry.getKey());
        }
        int count = 0;
        int[] res = new int[k];
        for (int i = array.length - 1; i >= 0; i--) {
            if (!array[i].isEmpty()) {
                if (count == k) break; 
                for (Integer num : array[i]) {
                    res[count] = num;
                    count++;
                    if (count == k) break; 
                }
            }
        }
        return res;
        
    }
}
