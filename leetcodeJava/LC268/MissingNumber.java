import java.util.HashMap;

class MissingNumber {
    public int missingNumberHashMap(int[] nums) {
        // available number, index in nums
        HashMap<Integer, Integer> availableNumbers = new HashMap<Integer,Integer>();
        int i;
        for(i = 0;i<nums.length;i++) {
            availableNumbers.put(nums[i],i);
        }
        for(i = 0;i<nums.length;i++) {
            if(availableNumbers.containsKey(i)==false) {
                return i;
            }
        }
        return i;
    }
}