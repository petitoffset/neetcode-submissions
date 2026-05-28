class Solution {
    public void setZeroes(int[][] matrix) {
        int height = matrix.length - 1;
        int width = matrix[0].length - 1;
        boolean firstRow = false;
        boolean firstColumn = false;
        for (int r = 0; r <= height; r++) {
            if (matrix[r][0] == 0) {
                firstColumn = true;
            }
        }
        for (int c = 0; c <= width; c++) {
            if (matrix[0][c] == 0) {
                firstRow = true;
            }
        }

        for (int r = 1; r <= height; r++) {
            for (int c = 1; c <= width; c++) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    matrix[r][0] = 0;
                }
            }
        }
        
        for (int r = 1; r <= height; r++) {
            for (int c = 1; c <= width; c++) {
                if (matrix[0][c] == 0 || matrix[r][0] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if (firstColumn) {
            for (int r = 0; r <= height; r++) {
                    matrix[r][0] = 0;
            }
        }
        if (firstRow) {
            for (int c = 0; c <= width; c++) {
                    matrix[0][c] = 0;
            }
        }
    }
}
