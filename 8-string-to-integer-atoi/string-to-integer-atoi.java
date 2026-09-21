class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();

        // Step 1: skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i == n) {
            return 0;
        }

        // Step 2: check for sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        // Step 3: read digits, building result, checking overflow as we go
        int result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Overflow check BEFORE multiplying
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}

        

