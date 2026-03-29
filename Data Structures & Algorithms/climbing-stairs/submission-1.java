class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        return memoization(n, cache);      
    }

    public int memoization(int n, HashMap<Integer, Integer> cache) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (cache.get(n) != null) {
            return cache.get(n);
        }

        cache.put(n, memoization(n - 1, cache) + memoization(n - 2, cache));
        return cache.get(n);
    }
}
