class Solution {
    boolean[][] fromA;
    boolean[][] fromP;
    List<List<Integer>> res;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        res = new ArrayList<>();
        int ROWS = heights.length;
        int COLS = heights[0].length;
        boolean[][] visitedA = new boolean[ROWS][COLS];
        boolean[][] visitedP = new boolean[ROWS][COLS];
        fromA = new boolean[ROWS][COLS];
        fromP = new boolean[ROWS][COLS];

        
        for (int c = 0; c < COLS; c++) {
            dfs(heights, 0, c, visitedP, fromP);
        }  
        for (int r = 0; r < ROWS; r++) {
            dfs(heights, r, 0, visitedP, fromP);
        } 
        for (int c = 0; c < COLS; c++) {
            dfs(heights, ROWS - 1, c, visitedA, fromA);
        }  
        for (int r = 0; r < ROWS; r++) {
            dfs(heights, r, COLS - 1, visitedA, fromA);
        } 
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (fromA[r][c] == true && fromP[r][c] == true)
                    res. add(List.of(r, c));
            }
        }
        return res;
    }

    void dfs(int[][] heights, int r, int c, boolean[][] visited, boolean[][] reach) {
        if (visited[r][c]) return;
        int ROWS = heights.length, COLS = heights[0].length;
        visited[r][c] = true;
        reach[r][c] = true;

        int val = heights[r][c];
        if (c + 1 < COLS && heights[r][c+1] >= val) {
            dfs(heights, r, c + 1, visited, reach);
        }
        if (r + 1 < ROWS && heights[r+1][c] >= val) {
            dfs(heights, r + 1, c, visited, reach);
        }
        if (c - 1 >= 0 && heights[r][c-1] >= val) {
            dfs(heights, r, c - 1, visited, reach);
        }
        if (r - 1 >= 0 && heights[r-1][c] >= val) {
            dfs(heights, r - 1, c, visited, reach);
        }
    }
}