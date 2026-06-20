class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int L = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int r = 0; r < L; r++) {
            while (deque.size() != 0 && nums[deque.peekLast()] < nums[r]) {
                deque.removeLast();
            }
            deque.add(r);
            if (deque.peekFirst() < r - k + 1) {
                deque.removeFirst();
            }
            if (r >= k - 1) {
                res.add(nums[deque.peekFirst()]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();         
    }
}
