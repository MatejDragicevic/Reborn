class Solution {
    public int divide(int dividend, int divisor) {
        // can't deal with that
        boolean divisionWithZero = divisor == 0;
        boolean minValueDividedWithNegativeOne = dividend==Integer.MIN_VALUE&&divisor==-1;
        if(divisionWithZero || minValueDividedWithNegativeOne) return Integer.MAX_VALUE;

        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);
        int quotient = 0;
        // division in bits
        while(longDividend >= longDivisor){
            long divisorShiftLeft = longDivisor;
            long multiplicationBit = 1;
            while(longDividend >= divisorShiftLeft<<1){
                divisorShiftLeft <<= 1;
                multiplicationBit <<= 1;
            }
            longDividend -= divisorShiftLeft;
            quotient += multiplicationBit;
        }
        boolean oneNegativOnePositiv = (dividend < 0) ^ (divisor < 0);
        return oneNegativOnePositiv ? -quotient : quotient;
    }
}