class Solution {
    char[][] board;
    String word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(i, j, 0, visited)) return true;
                }
            }
        }
        return false;
    }

    private boolean search(int i, int j, int k, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(k))
            return false;
        if (k == word.length() - 1)
            return true;
        visited[i][j] = true;
        boolean found = search(i + 1, j, k + 1, visited) || search(i, j + 1, k + 1, visited) || search(i - 1, j, k + 1, visited) || search(i, j - 1, k + 1, visited);
        if (!found) {
            visited[i][j] = false;
        }
        return found;
    }
}
