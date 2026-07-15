class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area = Math.max(area, dfs(grid, i, j));
                }
            }
        }
        return area;        
    }

    public int dfs(int[][] grid, int r, int c) {
        int ROWS = grid.length; int COLS = grid[0].length;

        if (Math.min(r, c) < 0 || r >= ROWS || c >= COLS || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;
        int count = 1;
        count += dfs(grid, r + 1, c);
        count += dfs(grid, r, c + 1);
        count += dfs(grid, r - 1, c);
        count += dfs(grid, r, c - 1);
        return count;
    }
}
