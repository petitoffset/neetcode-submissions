class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1)
            return true;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            boolean different = false;

            int minL = Math.min(s1.length(), s2.length());
            for (int j = 0; j < minL; j++) {
                int c1 = map.get(s1.charAt(j));
                int c2 = map.get(s2.charAt(j));
                if (c1 < c2) {
                    different = true;
                    break;
                }
                if (c1 > c2) {
                    return false;
                }
            }
            if (!different && s1.length() > s2.length()) {
                return false;
            }
        }
        return true;
    }
}