class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            int sum = 0;
            while (n > 0) {
                int rest = n % 10;
                n = n / 10;
                sum += rest * rest;
            }
            System.out.println(sum);
            n = sum;
        }
        return n == 1;        
    }
}
