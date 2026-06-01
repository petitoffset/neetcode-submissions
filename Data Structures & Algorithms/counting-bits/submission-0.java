class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        if (n == 0) return res;
        res[1] = 1;
        if (n == 1) return res;
        int base = 1;
        while (base <= 1000) {
            base = base * 2;
            if (base > n) {
                break;
            }
            res[base] = 1;
            for (int i = base + 1; i < base * 2; i++) {
                if (i > n) break;
                res[i] = res[i - base] + 1;
            }
        }
        return res;        
    }
}
