class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, Comparator. comparing(String::length));
        Set<String> res = new HashSet<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    res.add(words[i]);
                    break;
                } 
            }
        }
        return new ArrayList(res);
    }
}