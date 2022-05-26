import java.util.Arrays;


class TwoSum {

    // time O(n*n)
    // space O(1)
    public static int[] twoSumBruteForce(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[] { 0, 0 };
    }

    // time O(n)
    // space O(n)
    public static int[] twoSumTwoPassHashTable(int[] nums, int target) {

        Map<Integer, Integer> mapNums = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            mapNums.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (mapNums.containsKey(diff) && mapNums.get(diff) != i) {
                return new int[] { mapNums.get(diff), i };
            }
        }

        return new int[] { 0, 0 };
    }

    // time O(n)
    // space O(n)
    public static int[] twoSumOnePassHashTable(int[] nums, int target) {

        Map<Integer, Integer> mapNums = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (mapNums.containsKey(diff)) {
                return new int[] { mapNums.get(diff), i };
            }
            mapNums.put(nums[i], i);
        }
        return new int[] { 0, 0 };
    }
}