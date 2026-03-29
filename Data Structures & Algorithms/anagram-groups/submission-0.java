class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            int[] freq = new int[26];
            for (int i = 0; i < word.length(); i++) {
                freq[word.charAt(i) - 'a']++;
            }
            String freqStr = Arrays.toString(freq);
            map.putIfAbsent(freqStr, new ArrayList<>());
            map.get(freqStr).add(word);
        }
        List<List<String>> result = new ArrayList<>();
        return new ArrayList<>(map.values());
        
    }
}
