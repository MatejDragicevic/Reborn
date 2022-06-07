class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = m-1;
        int second = n-1;
        for(int i = m+n-1; i >= 0 && second >= 0; i--)
        {
            if(first >=0 && nums1[first] > nums2[second])
            {
                nums1[i] = nums1[first--];
            }
            else
            {
                nums1[i] = nums2[second--];
            }
        }
    }
}