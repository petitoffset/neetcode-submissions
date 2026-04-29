class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int cache[] = new int[s.length() + 1];
        Arrays.fill(cache, -1);
        return memoization(s, 0, wordDict, cache);        
    }

    public boolean memoization(String word, int cur, List<String> wordDict, int[] cache) {
        if (cur > word.length()) {
            return false;
        }

        if (cur == word.length()) {
            return true;
        }

        if (cache[cur] != -1) {
            return cache[cur] != 0;
        }

        for (String w : wordDict) {
            if (word.startsWith(w, cur)) { 
                boolean branch = memoization(word, cur + w.length(), wordDict, cache); 
                if (branch) {
                    cache[cur] = 1;
                    return true;
                }
            }
        }
        cache[cur] = 0;
        return false;
    }
}
