class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();           
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.endOfWord = true;
        
    }
    
    public boolean search(String word) {
        return dfs(root, word, 0); 
    }

    public boolean dfs(TrieNode root, String word, int k) {
        if (k == word.length()) {
            if (root.endOfWord) return true;
            return false;
        }
        if (word.charAt(k) == '.') {
            for (char c : root.children.keySet()) {
                if (dfs(root.children.get(c), word, k + 1)) {
                    return true;
                }
            }
        } else {
            if (!root.children.containsKey(word.charAt(k))) {
                return false;
            }
            return dfs(root.children.get(word.charAt(k)), word, k + 1);
        }
        return false;
    }
}

public class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
}
