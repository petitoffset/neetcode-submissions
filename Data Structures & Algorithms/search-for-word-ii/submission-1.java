class Solution {
    char[][] board;
    Trie list;
    List<String> res;
    public List<String> findWords(char[][] board, String[] words) {
        list = new Trie();
        for (String w : words) {
            list.insert(w);
        }
        this.board = board;
        res = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(i, j, list.getRoot(), visited);
            }
        }
        return res; 
    }

    private void search(int i, int j, TrieNode root, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        if (!root.children.containsKey(board[i][j])) {
            return;
        }
        root = root.children.get(board[i][j]);
        visited[i][j] = true;
        if (root.endOfWord) {
            res.add(root.word);
            root.endOfWord = false;
        }
        search(i + 1, j, root, visited);
        search(i, j + 1, root, visited);
        search(i - 1, j, root, visited);
        search(i, j - 1, root, visited);
        visited[i][j] = false;
    }

}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();        
    }

    public TrieNode getRoot() {
        return root;
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.endOfWord = true; 
        cur.word = word;
    }
}

    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean endOfWord = false;
        String word;
    }
