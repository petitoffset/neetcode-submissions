class Solution {
    char[][] board;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        List<String> exist = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (String w : words) {
            reset(visited);
            boolean found = false;
            for (int i = 0; i < board.length; i++) {
                if (found) break;
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == w.charAt(0)) {
                        if (search(i, j, 0, w, visited)) {
                            exist.add(w);
                            found = true;
                            break;
                        }
                    }  
                }
            }
        }
        return exist; 
    }

    private void reset(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = false;
            }
        }
    }

    private boolean search(int i, int j, int k, String word, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(k))
            return false;
        if (k == word.length() - 1)
            return true;
        visited[i][j] = true;
        boolean found = search(i + 1, j, k + 1, word, visited) || search(i, j + 1, k + 1, word, visited) || search(i - 1, j, k + 1, word, visited) || search(i, j - 1, k + 1, word, visited);
        if (!found) {
            visited[i][j] = false;
        }
        return found;
    }
}
