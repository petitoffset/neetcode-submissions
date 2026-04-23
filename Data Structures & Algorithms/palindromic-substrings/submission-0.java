class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
            l = i;
            r = l + 1;
            while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
        }
        return count;        
    }
}
