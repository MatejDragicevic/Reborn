class Solution {
    public boolean isHappy(int n) {
        Set<Integer> sums = new HashSet<Integer>();
        while(n!=1)
        {
            if(!sums.add(n)) return false;
            int[] digits = new int[10];
            while(n > 0)
            {
                digits[n%10]++;
                n /= 10;
            }
            for(int i = 1; i<digits.length;i++)
            {
                while(digits[i]>0)
                {
                    digits[i]--;
                    n += i*i;
                }
            }
        }
        return true;
    }
    
    public boolean isHappyFaster(int n) {
        Set<Integer> sums = new HashSet<Integer>();
        while(n!=1)
        {
            if(!sums.add(n)) return false;
            int[] digits = new int[10];
            int swap = 0;
            while(n > 0)
            {
                int digit = n%10;
                swap += digit*digit;
                n /= 10;
            }
            n = swap;
        }
        return true;
    }
}