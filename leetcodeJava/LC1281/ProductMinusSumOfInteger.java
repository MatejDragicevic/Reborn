class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while(n>0)
        {
            int elem = n%10;
            sum += elem;
            product *= elem;
            n /= 10;
        }
        return product - sum;
    }
}