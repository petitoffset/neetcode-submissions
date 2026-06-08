class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0; 
        int r = m - 1;
        int line = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][n - 1]) {
                line = mid;
                break;
            } else if (target > matrix[mid][0]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (line == -1) {
            return false;
        }
        
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == matrix[line][mid]) {
                return true;
            } else if (target > matrix[line][mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;        
    }
}
