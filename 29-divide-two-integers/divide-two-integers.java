class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long longDividend = dividend;
        long longDivisor = divisor;

        boolean negative = (longDividend < 0) != (longDivisor < 0);

        longDividend = Math.abs(longDividend);
        longDivisor = Math.abs(longDivisor);

        long quotient = 0;

        while (longDividend >= longDivisor) {
            long tempDivisor = longDivisor;
            long multiple = 1;

            while (longDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            longDividend -= tempDivisor;
            quotient += multiple;
        }

        if (negative) {
            quotient = -quotient;
        }

        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) quotient;
    }
}

      

