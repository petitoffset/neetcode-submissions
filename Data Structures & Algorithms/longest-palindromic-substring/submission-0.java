class Solution {
    public String longestPalindrome(String s) {
        int length = 0;
        String substring = "";
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > length) {
                    length = r - l + 1;
                    substring = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
            l = i;
            r = l + 1;
            while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > length) {
                    length = r - l + 1;
                    substring = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }
        return substring;
        
    }
}
