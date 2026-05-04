class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int[][] cache = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            Arrays.fill(cache[i], -1);
        }

        return dfsHelper(s1, s2, 0, 0, cache);  
    }

    public static int dfsHelper(String s1, String s2, int i1, int i2, int[][] cache) {
        if (i1 == s1.length() || i2 == s2.length()) {
            return 0;
        }

        if (cache[i1][i2] != -1) {
            return cache[i1][i2];
        } 

        if (s1.charAt(i1) == s2.charAt(i2)) {
            cache[i1][i2] =  1 + dfsHelper(s1, s2, i1 + 1, i2 + 1, cache);
        } else {
            cache[i1][i2] =  Math.max(dfsHelper(s1, s2, i1 + 1, i2, cache), 
                             dfsHelper(s1, s2, i1, i2 + 1, cache));
        }
        return cache[i1][i2];
    }
}

