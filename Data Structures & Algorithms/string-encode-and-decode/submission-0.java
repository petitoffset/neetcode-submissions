class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String word : strs) {
            encoded.append(word.length()).append("_").append(word);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int index = 0;
        while(index < str.length()) {
            StringBuilder l = new StringBuilder();
            while(index < str.length() && str.charAt(index) != '_') {
                l.append(str.charAt(index));
                index++;
            }
            int len = Integer.parseInt(l.toString());
            decoded.add(str.substring(index + 1, index + 1 + len));
            index = index + 1 + len;
        }
        return decoded;

    }
}
 