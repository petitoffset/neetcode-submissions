class Solution {
    public int[] replaceElements(int[] arr) {
        int L = arr.length;
        int max = arr[L - 1];
        arr[L - 1] = -1;
        for (int i = L - 2; i >= 0; i--) {
            int oldMax = max;
            if (arr[i] > max) {
                max = arr[i];
            }
            arr[i] = oldMax;
        }
        return arr;        
    }
}