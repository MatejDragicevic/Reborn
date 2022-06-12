class Solution
{
    public int minOperations(int[] nums, int x)
    {
        int sumNums = 0;
        for (int elem : nums)
        {
            sumNums += elem;
        }

        int maxLength = -1;
        int tempSum = 0;
        for (int left = 0, right = 0; right < nums.length; right++)
        {
            tempSum += nums[right];

            while(left <= right && tempSum > sumNums -x)
            {
                tempSum -= nums[left++];
            }
            
            if(tempSum == sumNums - x)
            {
                maxLength = Math.max(maxLength, (right - left + 1) );
            }
        }

        if(maxLength != -1)
        {
            maxLength = nums.length - maxLength;
        }
        return maxLength;
    }
}