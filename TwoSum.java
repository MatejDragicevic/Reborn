class TwoSum {

    // O(n*n)
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    //if sorted nums
    // O(n)
    public int[] twoSumBetter(int[] nums, int target) {
        int left = 0;
        int right = a.length -1;
        while(left < right) {
            int tempSum = nums[left] + nums[right];
            if(tempSum == target)
                return new int[] {left, right};
            if(tempSum > target)
                right--;
            else
                left++;
        }
        return new int[] {-1,-1};
    }
}
