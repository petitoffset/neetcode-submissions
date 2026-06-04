class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> tmp = new HashSet<>();
        // check rows
        for (int i = 0; i < 9; i++) {
            tmp.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !tmp.add(board[i][j])) {
                    return false;
                }
            }
        }
        // check columns
        for (int j = 0; j < 9; j++) {
            tmp.clear();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.' && !tmp.add(board[i][j])) {
                    return false;
                }
            }
        }
        //check squares
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tmp.clear();
                for (int x = 3 * i; x < 3 * i + 3; x++) {
                    for (int y = 3 * j; y < 3 * j + 3; y++) {
                        if (board[x][y] != '.' && !tmp.add(board[x][y])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;        
    }
}
