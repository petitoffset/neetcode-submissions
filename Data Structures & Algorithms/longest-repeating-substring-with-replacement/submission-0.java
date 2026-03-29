class Solution {
    public int characterReplacement(String s, int k) {
        int[] f = new int[26];
        char[] str = s.toCharArray();
        int l = 0;
        int maxFreq = 0;
        int res = 0;
        for (int r = 0; r < str.length; r++) {
            f[str[r] - 'A']++;
            maxFreq = Math.max(maxFreq, f[str[r] - 'A']);
            if ((r - l + 1 - maxFreq) > k) {
                while ((r - l + 1 - maxFreq) > k) {
                    l++;
                    f[str[l-1] - 'A']--;                }
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
        
    }
}
