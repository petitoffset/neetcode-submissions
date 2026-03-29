class Solution {
    public String minWindow(String s, String t) {
        Set<Character> tchars = new HashSet<>();
        int[] tfreq = new int[58];
        for (char c : t.toCharArray()) {
            tchars.add(c);
            tfreq[c - 'A']++;
        }
        int tuni = tchars.size();

        int bestL = 0;
        int bestR = s.length();
        int[] wfreq = new int[58]; 
        int wuni = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            // moving right pointer and expanding window
            wfreq[s.charAt(r) - 'A']++;
            if (wfreq[s.charAt(r) - 'A'] == tfreq[s.charAt(r) - 'A']) {
                wuni++;
            }
            // if valid, moving left pointer and narrowing window until non-valid
            if (wuni == tuni) {
                while (wuni == tuni) {
                    if ((r - l) < (bestR - bestL)) {
                        bestL = l;
                        bestR = r;
                    }
                    l++;
                    wfreq[s.charAt(l - 1) - 'A']--;
                    if (wfreq[s.charAt(l - 1) - 'A'] < tfreq[s.charAt(l - 1) - 'A']) {
                        wuni--;
                    }
                }
            }
        }
        if (bestR >= s.length()) return "";
        return s.substring(bestL, bestR + 1);
    }
        
}

