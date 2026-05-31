class Solution {
    public int hammingWeight(int n) {
        int ones = 0;
        while (n > 0) {
            int rest = n / 2;
            if (n % 2 == 1) {
                ones ++;
            }
            n = rest;
        }
        return ones;        
    }
}
