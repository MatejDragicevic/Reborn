class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int leftsum = 0;
        for(int elem : nums) sum += elem;
        for(int i = 0; i < nums.length; i++)
        {
            if(leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}