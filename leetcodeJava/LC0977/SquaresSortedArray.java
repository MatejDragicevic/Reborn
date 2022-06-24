class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0; i<nums.length;i++)
        {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
    public int[] sortedSquaresTwoPointers(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] sorted = new int[nums.length];
        for(int i = nums.length - 1; i>=0; i--)
        {
            if(nums[left]*nums[left] > nums[right]*nums[right])
            {
                sorted[i] = nums[left]*nums[left++];
            }
            else
            {
                sorted[i] = nums[right]*nums[right--];
            }
        }
        return sorted;
    }
}