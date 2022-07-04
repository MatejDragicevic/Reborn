class Solution {
    public int climbStairs(int n) {
        if(n<4) return n;
        int a = 2;
        int b = 3;
        int sum = 0;
        int i = 3;
        while(i<n)
        {
            sum=a+b;
            a=b;
            b=sum;
            i++;
        }
        return sum;
    }
}