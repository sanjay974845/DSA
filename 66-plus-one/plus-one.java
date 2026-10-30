class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;   // 9 + 1 = 10: write 0, carry left
        }

        // all digits were 9: need one extra leading digit
        int[] result = new int[digits.length + 1];
        result[0] = 1;       // the rest are already 0
        return result;
    }
}

        
    
