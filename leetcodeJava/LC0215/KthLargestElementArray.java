class KthLargestElementArray {
    // inline
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    
    // priority queue
    public int findKthLargestPriorityQuue(int[] nums, int k) {
        PriorityQueue<Integer> largestOnes = new PriorityQueue<>();
        for(int i = 0; i<nums.length;i++)
        {
            largestOnes.add(nums[i]);
            if(largestOnes.size() > k)
            {
                largestOnes.poll();
            }
        }
        return largestOnes.poll();
    }

    // quick select
    public int findKthLargestQuickSelect(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, nums.length-k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];
    
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        pivotIndex = partition(nums, left, right, pivotIndex);
    
        if (pivotIndex == k) return nums[k];
        else if (pivotIndex < k) return quickSelect(nums, pivotIndex+1, right, k);
        return quickSelect(nums, left, pivotIndex-1, k);
    }
    
    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        pivotIndex = left;
    
        for (int i=left; i<=right; i++) 
            if (nums[i] <= pivotValue) 
                swap(nums, i, pivotIndex++);
    
        return pivotIndex - 1;
    }
    
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}