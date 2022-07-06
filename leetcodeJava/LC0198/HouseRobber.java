class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        int prev = 0;
        int mid = 0;
        for(int next : nums)
        {
            int sum = prev + next;
            int temp = mid;
            mid = Math.max(sum, mid);
            prev = temp;
        }
        return mid;
    }
}