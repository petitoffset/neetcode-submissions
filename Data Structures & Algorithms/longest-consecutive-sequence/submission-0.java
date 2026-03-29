class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : nums) {
            set.add(i);
        }

        int maxLength = 0;

        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                int curLength = 1;
                int next = i + 1;
                while(set.contains(next)) {
                    curLength++;
                    next += 1;
                }
                maxLength = Math.max(maxLength, curLength);
            }
        }
        return maxLength; 
        
    }
}
