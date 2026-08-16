class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder b = new StringBuilder();
        int minL = Math.min(word1.length(), word2.length());
        for (int i = 0; i < minL; i++) {
            b.append(word1.charAt(i));
            b.append(word2.charAt(i));
        }
        b.append(word1.substring(minL));
        b.append(word2.substring(minL));
        return b.toString();
    }
}