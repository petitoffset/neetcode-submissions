class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int leftMin = prices[0];
        int prof = 0;
        for (int i = 1; i < prices.length; i++) {
            int curProf = prices[i] - leftMin;
            prof = Math.max(prof, curProf);
            leftMin = Math.min(leftMin, prices[i]);
        }
        return prof;
        
    }
}
