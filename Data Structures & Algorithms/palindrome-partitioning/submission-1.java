class Solution {
    List<List<String>> res;
    List<String> cur;
    String s;
    boolean[][] pal;
    public List<List<String>> partition(String s) {
        this.res = new ArrayList<>();
        this.cur = new ArrayList<>();
        this.s = s;
        this.pal = new boolean[s.length()][s.length()];
        buildPalindromeTable();
        backtracking(0);
        return res;        
    }

    private void backtracking(int i) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (pal[i][j]) {
                cur.add(s.substring(i, j + 1));
                backtracking(j + 1);
                cur.removeLast();
            }
        }
    }

    private void buildPalindromeTable() {
        for (int l = s.length() - 1; l >= 0; l--) {
            for (int r = l; r < s.length(); r++) {
                pal[l][r] =
                    s.charAt(l) == s.charAt(r)
                    && (r - l <= 2 || pal[l + 1][r - 1]);
            }
        }
    }
}
