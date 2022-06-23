class containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> duplicates = new HashSet<>();
        for(int elem : nums)
        {
            if(!duplicates.add(elem)) return true;
        }
        return false;
    }
}