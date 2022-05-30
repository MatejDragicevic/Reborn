class Solution {
    public int divide(int dividend, int divisor) {
        boolean divisionWithZero = divisor == 0;
        boolean minValueDividedWithOne = dividend==Integer.MIN_VALUE&&divisor==-1;
        if(divisionWithZero || minValueDividedWithOne) return Integer.MAX_VALUE;
        int quotient = 0;
        boolean oneNegativOnePositiv = (dividend < 0) ^ (divisor < 0);
        int sign = oneNegativOnePositiv ? -1 : 1;
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);
        while(longDivisor <= longDividend){
            long temp = longDivisor;
            long multiplicator =1;
            while(longDividend >= temp<<1){
                temp <<= 1;
                multiplicator <<= 1;
            }
            longDividend -= temp;
            quotient += multiplicator;
        }
        return sign==1 ? quotient : -quotient;
    }
}