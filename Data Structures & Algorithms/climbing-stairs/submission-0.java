class Solution {
    public int climbStairs(int n) {
        return count(n);        
    }

    public int count(int rest) {
        if (rest == 1) return 1;
        if (rest == 2) return 2;

        return count(rest - 1) + count(rest - 2);
    }
}
