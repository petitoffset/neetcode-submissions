class Solution {
    int count;

    public int numIslands(char[][] grid) {
        boolean found = false;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int r, int c) {
        int ROWS = grid.length, COLS = grid[0].length;

        if (Math.min(r, c) < 0 || r == ROWS || c == COLS ||
                grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';

        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
        return;
    }
}
