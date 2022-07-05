class NumArray {
    int[] A;
    public NumArray(int[] nums) {
        int[] A = new int[nums.length];
        for(int i = 0; i<nums.length;i++)
            A[i] = nums[i];
        for(int i=1;i<nums.length;i++)
            A[i] += A[i-1];
        this.A = A;
    }
    
    public int sumRange(int left, int right) {
        return left==0 ? A[right] : A[right]-A[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */