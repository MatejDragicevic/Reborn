class Solution {
    public void moveZeroes(int[] nums) {
        for(int i = 0,j=1;i<nums.length-1;i++)
        {
            if(nums[i]==0)
            {
                j=i+1;
                while(nums[j]==0)
                {
                    j++;
                    if(j==nums.length) return;
                }
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
    }
}