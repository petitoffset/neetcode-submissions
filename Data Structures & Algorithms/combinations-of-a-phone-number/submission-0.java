class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> keys = new HashMap<>();
        keys.put('2', List.of('a', 'b', 'c'));
        keys.put('3', List.of('d', 'e', 'f'));
        keys.put('4', List.of('g', 'h', 'i'));
        keys.put('5', List.of('j', 'k', 'l'));
        keys.put('6', List.of('m', 'n', 'o'));
        keys.put('7', List.of('p', 'q', 'r', 's'));
        keys.put('8', List.of('t', 'u', 'v'));
        keys.put('9', List.of('w', 'x', 'y', 'z'));
        
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        backtracking(0, digits, res, new StringBuilder(), keys);
        return res;
    }

    private void backtracking(int i, String s, List<String> res, StringBuilder cur, Map<Character, List<Character>> keys) {
        if (i >= s.length()) {
            res.add(cur.toString());
            return;
        }
        for (int k = 0; k < keys.get(s.charAt(i)).size(); k++) {
            cur.append(keys.get(s.charAt(i)).get(k));
            backtracking(i + 1, s, res, cur, keys);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
