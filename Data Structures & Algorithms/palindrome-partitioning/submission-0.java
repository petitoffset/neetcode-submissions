class Solution {
    List<List<String>> res;
    List<String> cur;
    String s;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        cur = new ArrayList<>();
        this.s = s;
        backtracking(0);
        return res;        
    }

    private void backtracking(int i) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPali(s, i, j)) {
                cur.add(s.substring(i, j + 1));
                backtracking(j + 1);
                cur.removeLast();
            }
        }
    }

    private boolean isPali(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;

    }
}
