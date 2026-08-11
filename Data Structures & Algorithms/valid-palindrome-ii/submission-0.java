class Solution {
    public boolean validPalindrome(String s) {
        int[] res1 = isPalindrome(s);
        if (res1[0] == 1) {
            return true;
        }
        int l = res1[1];
        int r = res1[2];
        int[] res2 = isPalindrome(s.substring(l + 1, r + 1));
        if (res2[0] == 1) {
            return true;
        }
        int[] res3 = isPalindrome(s.substring(l, r));
        if (res3[0] == 1) {
            return true;
        }
        return false;    
    }

    private int[] isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return new int[]{0, l, r};
            }
            l++;
            r--;
        }
        return new int[]{1, 0, 0};
    }
}