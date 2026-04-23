class Solution {
    public char[] msg;
    public int numDecodings(String s) {
        msg = s.toCharArray();
        int l = s.length();
        if (msg[0] == '0') return 0;
        HashMap<Integer, Integer> cache = new HashMap<>();
        return memoization(l, cache);       
    }

    public int memoization(int cur, HashMap<Integer, Integer> cache) {
        if (cur == 0) return 1;
        if (cur == 1) {
            return 1;
        }

        if (cache.get(cur) != null) {
            return cache.get(cur);
        }

        if (!isOneCharOk(cur) && !isTwoCharsOk(cur)) {
            cache.put(cur, 0);            
        } else if (isOneCharOk(cur) && isTwoCharsOk(cur)) {
            cache.put(cur, memoization(cur - 1, cache) + memoization(cur - 2, cache));
        } else if (isOneCharOk(cur)) {
            cache.put(cur, memoization(cur - 1, cache));
        } else cache.put(cur, memoization(cur - 2, cache));

        return cache.get(cur);
    }

    private boolean isOneCharOk(int cur) {
        return msg[cur - 1] != '0';
    }

    private boolean isTwoCharsOk(int cur) {
        if (msg[cur - 2] == '1' || msg[cur - 2] == '2' && msg[cur - 1] >= '0' && msg[cur - 1] <= '6') {
            return true;
        }
        return false;
    }
}
