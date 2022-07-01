class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n<2) return 0;
        int mid = nums[n/2];
        int count = 0; 
        for(int i = 0; i<n; i++)
        {
            count += Math.abs(nums[i]-mid);
        }
        return count;
    }
    
    // quick select version
    public int minMoves2QSelect(int[] nums) {
        int n = nums.length;
        int mid = qSelect(nums, 0, n-1, n/2);
        int operations = 0;
        for(int elem : nums)
            operations += Math.abs(mid-elem);
        
        return operations;
    }
    
    private int qSelect(int[] nums, int left, int right, int k)
    {
        if(left == right) return nums[left];
        
        int pIndex = new Random().nextInt(right-left+1) + left;
        pIndex = partition(nums, left, right, pIndex);
        
        if      (pIndex == k) return nums[k];
        else if (pIndex < k) return qSelect(nums, pIndex+1, right, k);
        
        return qSelect(nums, left, pIndex-1, k);
    }
    
    private int partition(int[] nums, int left, int right, int pIndex)
    {
        int pivot = nums[pIndex];
        swap(nums, pIndex, right);
        pIndex = left;
        for(int i=left; i<=right; i++)
            if(nums[i] <= pivot) swap(nums, i, pIndex++);
        
        return pIndex-1;
    }
    
    private void swap(int[] nums, int x, int y)
    {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}