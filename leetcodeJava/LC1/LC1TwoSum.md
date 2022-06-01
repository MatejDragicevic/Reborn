# Two sum LC 1

the most popular LC question
- [LC1 Two Sum](https://leetcode.com/problems/two-sum/)
> Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. You may assume that each input would have exactly one solution, and you may not use the same element twice. You can return the answer in any order.

example 1:
```
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
```
example 2:
```
Input: nums = [3,2,4], target = 6
Output: [1,2]
```
example 3:
```
Input: nums = [3,3], target = 6
Output: [0,1]
```

# solutions
The problem can be solved by looping through nums and sum up two elements to get the given target. You have to make sure not to hit the same target twice, that is why ```j = i + 1```.
This also means that the complement has to be equal to ```target - otherElement```.
That is why we can loop just once(instead of loop in a loop) to reduce time complexity. However, this requires space in form of a hashmap.

## Brute Force

the worst time complexity with the best space complexity
```
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
```

## HashTable passing twice

reduced time complexits compared to brute force, but increases space compexity
```
// time O(n) -> for where n = nums.length
// space O(n) -> hashmap of n entries

public static int[] twoSumTwoPassHashTable(int[] nums, int target) {

    Map<Integer, Integer> mapNums = new HashMap<>();

    // fill the map
    for (int i = 0; i < nums.length; i++) {
        mapNums.put(nums[i], i);
    }

    // check if diff exists
    for (int i = 0; i < nums.length; i++) {
        int diff = target - nums[i];
        if (mapNums.containsKey(diff) && mapNums.get(diff) != i) {
            return new int[] { mapNums.get(diff), i };
        }
    }

    return new int[] { 0, 0 };
}
```

## Hashtable passing once

looping just once for filling the map and finding the complement
```
// time O(n)
// space O(n)

public static int[] twoSumOnePassHashTable(int[] nums, int target) {

    Map<Integer, Integer> mapNums = new HashMap<>();

    // fill the map
    // find complement among the current elements of the map
    for (int i = 0; i < nums.length; i++) {
        int diff = target - nums[i];
        if (mapNums.containsKey(diff)) {
            return new int[] { mapNums.get(diff), i };
        }
        mapNums.put(nums[i], i);
    }
    return new int[] { 0, 0 };
}
```