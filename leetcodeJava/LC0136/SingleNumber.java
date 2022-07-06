class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int elem : nums)
        {
            result ^= elem;
        }
        return result;
    }
    class Solution {
        public int singleNumberSet(int[] nums) {
            Set<Integer> set = new HashSet<Integer>();
            for(int elem : nums)
            {
                if(!set.add(elem)) set.remove(elem);
            }
            return set.iterator().next();
        }
    }
}