class RunningSumOf1DArray {
    public int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];
        int tempSum = 0;
        for(int i = 0; i<nums.length;i++) {
            tempSum += nums[i];
            sum[i] = tempSum;
        }
        return sum;
    }
    public int[] runningSumInputForOutput(int[] nums) {
        for(int i = 1; i<nums.length;i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}