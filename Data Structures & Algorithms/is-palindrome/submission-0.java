class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                builder.append(Character.toLowerCase(c));
            }
        }
        String str = builder.toString(); 
        if (str.length() == 0) return true;

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
        
    }
}
