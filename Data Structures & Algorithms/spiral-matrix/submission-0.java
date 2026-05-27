class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int L = 0;
        int R = matrix[0].length - 1;
        int T = 0;
        int B = matrix.length - 1;

        while (L <= R && T <= B) {
            System.out.println("L, R, T, B " + L + " " + R + " " + T + " " + B);
            for (int i = L; i <= R; i++) {
                res.add(matrix[T][i]);
            }
            if (T != B) {
                for (int j = T + 1; j <= B; j++) {
                    res.add(matrix[j][R]);
                }
                if (L != R) {
                    for (int k = R - 1; k >= L; k--) {
                        res.add(matrix[B][k]);
                    }
                    for (int m = B - 1; m >= T + 1; m--) {
                        res.add(matrix[m][L]);
                    }
                }
            }
            L++;
            R--; 
            T++;
            B--;           
        }
        return res;        
    }
}
