class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fives++;
                continue;
            }
            if (bill == 10) {
                if (fives > 0) {
                    fives--;
                    tens++;
                    continue;
                } else {
                    return false;
                }
            }
            if (bill == 20) {
                if (tens > 0 && fives > 0) {
                    fives--;
                    tens--;
                    continue;
                }
                if (fives > 2) {
                    fives -= 3;
                    continue;
                }
                return false;
            }
        }
        return true;        
    }
}