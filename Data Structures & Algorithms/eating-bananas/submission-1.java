class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        int l = 1;
        int r = max;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long hours = 0;
            for (int i = 0; i < piles.length; i++) {
                hours += (piles[i] + mid - 1) / mid;
                if (hours > h) {
                    break;
                }
            }
            if (hours > h) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;        
    }
}
