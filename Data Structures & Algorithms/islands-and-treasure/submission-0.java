class Solution {
    public void islandsAndTreasure(int[][] grid) {
        // Multi-source BFS

        int ROWS = grid.length;
        int COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int path = 1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int k = 0; k < queueSize; k++) {
                int[] pair = queue.poll();
                int r = pair[0], c = pair[1];
                for (int[] dir : directions) {
                    int newr = r + dir[0], newc = c + dir[1];
                    if (Math.min(newr, newc) < 0 || newr >= ROWS || newc >= COLS || 
                        visited[newr][newc] || grid[newr][newc] == -1) {
                            continue;
                        }
                    queue.add(new int[]{newr, newc});
                    visited[newr][newc] = true;
                    grid[newr][newc] = path;
                }
            }
            path++;
        } 
    }
}
