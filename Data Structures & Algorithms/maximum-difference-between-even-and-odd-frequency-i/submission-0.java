class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Arrays.sort(freq);

        int odd = 0;
        int even = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0 && freq[i] % 2 == 0) {
                even = freq[i];
                break;
            }
        }

        for (int i = 25; i >= 0; i--) {
            if (freq[i] % 2 != 0) {
                odd = freq[i];
                break;
            }
        }

        return odd - even;
    }
}