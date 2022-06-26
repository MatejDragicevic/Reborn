class Solution {
    public int arraySign(int[] nums) {
        int result = 1;
        for(int i=0;i<nums.length; i++)
        {
            int x = nums[i];
            if(x==0) return 0;
            if(x<0) result *=-1;
        }
        return result;
    }
}