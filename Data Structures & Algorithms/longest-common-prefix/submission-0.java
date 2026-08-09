class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minL = strs[0].length();
        String minS = strs[0];
        for (String s : strs) {
            if (s.length() < minL) {
                minL = s.length();
                minS = s;
            }
        }
        for (int i = 0; i < minL; i++) {
            for (String s : strs) {
                if (!(s.charAt(i) == minS.charAt(i))) 
                    return minS.substring(0, i);
            }
        }
        return minS;
    }
}