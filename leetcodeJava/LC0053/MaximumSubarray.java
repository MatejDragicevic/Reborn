class MaximumSubarray {
    public int maxSubArrayKadane(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i<nums.length;i++)
        {
            sum +=nums[i];
            max = Math.max(max,sum);
            if(sum<0) sum = 0;
        }
        return max;
    }
    public int maxSubArrayDivideConquer(int[] nums) {
        return maxSub(nums, 0, nums.length-1);
    }
    public int maxSub(int[] nums, int left, int right)
    {
        if(left>right) return Integer.MIN_VALUE;
        int mid = (left+right)/2;
        int sum = 0;
        int leftSum = 0;
        for(int i = mid-1; i>=left; i--)
        {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        sum = 0;
        int rightSum = 0;
        for(int i = mid+1; i<=right;i++)
        {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        int leftSub = maxSub(nums, left, mid-1);
        int rightSub = maxSub(nums, mid+1, right);
        int bestSub = Math.max(leftSub, rightSub);
        return Math.max(bestSub, leftSum + nums[mid] + rightSum);
    }
}