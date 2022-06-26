class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int first = 0;
        int second = 0;
        while(first < nums1.length && second < nums2.length)
        {
            if(nums1[first] < nums2[second]) first++;
            else if(nums1[first] > nums2[second]) second++;
            else
            {
                list.add(nums1[first++]);
                second++;
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}