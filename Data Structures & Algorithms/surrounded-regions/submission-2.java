class Solution {
    int ROWS, COLS;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            if (board[r][0] == 'O') {
                dfs(r, 0, board);
            }
            if (board[r][COLS - 1] == 'O') {
                dfs(r, COLS - 1, board);
            } 
        }
        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == 'O') {
                dfs(0, c, board);
            }
            if (board[ROWS - 1][c] == 'O') {
                dfs(ROWS - 1, c, board);
            } 
        }
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'Y') {
                    board[r][c] = 'O';
                }
            }
        }         
    }

    public void dfs(int r, int c, char[][] board) {
        if (Math.min(r, c) < 0 || r >= ROWS || c >= COLS || board[r][c] == 'Y' || board[r][c] == 'X') {
            return;
        }
        board[r][c] = 'Y';
        for (int d = 0; d < 4; d++) {
            int newr = r + directions[d][0];
            int newc = c + directions[d][1];
            dfs(newr, newc, board);
        }
        return;        
    }
}
