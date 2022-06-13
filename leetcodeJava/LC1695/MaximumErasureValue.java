class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        int sumTemp = 0;
        int sumMax = 0;
        for(int left=0, right=0; right < nums.length; right++)
        {
            if(elements.contains(nums[right]))
            {
                while(left < right)
                {
                    sumTemp -= nums[left];
                    elements.remove(nums[left++]);
                    if(nums[left-1] == nums[right])
                    {
                        break;
                    }
                }
            }
            sumTemp += nums[right];
            sumMax = Math.max(sumMax, sumTemp);
            elements.add(nums[right]);
        }
        return sumMax;
    }
}