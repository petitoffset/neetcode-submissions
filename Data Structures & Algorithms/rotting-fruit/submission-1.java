class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int ROWS = grid.length, COLS = grid[0].length;
        boolean[][] visit = new boolean[ROWS][COLS];
        int fresh = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visit[i][j] = true;
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int minutes = 0;
        while (!queue.isEmpty()) {
            if (fresh == 0) break;
            int queueSize = queue.size();
            for (int k = 0; k < queueSize; k++) {
                int[] pair = queue.poll();
                int r = pair[0], c = pair[1];
                for (int d = 0; d < 4; d++) {
                    int newr = r + directions[d][0], newc = c + directions[d][1];
                    if (Math.min(newr, newc) < 0 || newr >= ROWS || newc >= COLS || 
                        visit[newr][newc] || grid[newr][newc] == 0) {
                            continue;
                        }
                    fresh--;
                    visit[newr][newc] = true;
                    queue.add(new int[]{newr, newc});
                }
            }
            minutes++;
        }
        if (fresh == 0) {
            return minutes;
        } else {
            return -1;
        }
    }
}
