class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        PriorityQueue<Integer> sides = new PriorityQueue<>();
        int max = 0;
        int current = 0;
        for(int i = 0; i<nums.length; i++)
        {
            if(sides.size()>2)
            {
                current -= sides.remove();
            }
            if(current>nums[i])
            {
                max = Math.max(max,current+nums[i]);
            }
            current += nums[i];
            sides.add(nums[i]);
        }
        return max;
    }
    
    public int largestPerimeterEasy(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for(int i = 2; i<nums.length;i++)
        {
            if(nums[i] < nums[i-1]+nums[i-2])
            {
                max = nums[i]+nums[i-1]+nums[i-2];
            }
        }
        return max;
    }
}