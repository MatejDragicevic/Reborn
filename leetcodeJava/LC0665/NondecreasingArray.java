class Solution {
    public boolean checkPossibility(int[] nums) {
        if(nums.length<3) return true;
        int count = 0;
        for(int i = 0; i<nums.length-1;i++)
        {
            if(nums[i]>nums[i+1])
            {
                if(i<1 || nums[i-1]<=nums[i+1])
                    nums[i]=nums[i+1];
                else
                    nums[i+1]=nums[i];
                count++;
                if(count>1) return false;
            }
        }
        return true;
    }
}