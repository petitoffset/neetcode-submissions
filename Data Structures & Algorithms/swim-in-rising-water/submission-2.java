class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        boolean[][] visited = new boolean[N][N];


        Queue<int[]> minHeap = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int h1 = cur[0];
            int x1 = cur[1];
            int y1 = cur[2];

            if (x1 == N - 1 && y1 == N - 1) {
                return h1;
            }
            
            for (int[] dir : dirs) {
                int x2 = x1 + dir[0];
                int y2 = y1 + dir[1];
                if (Math.min(x2, y2) < 0 || x2 >= N || y2 >= N || visited[x2][y2]) {
                    continue;
                }
                minHeap.offer(new int[]{Math.max(h1, grid[x2][y2]), x2, y2});
                visited[x2][y2] = true;
            }
        }
        return -1;        
    }
}
