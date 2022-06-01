# Missing Number LC 268

[code](MissingNumber.java)
- [LC268 Missing Number](https://leetcode.com/problems/missing-number/)
> Given an array `nums` containing `n` distinct numbers in the range `[0, n]`, return the only number in the range that is missing from the array.

**Example 1**:
```
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
```
**Example 2**:
```
Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
```
**Example 3**:
```
Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
```

**Constaints**:
> n == nums.length

> 1 <= n <= 10^4

> 0 <= nums[i] <= n

> All the numbers of nums are unique

---

# Solutions

The problem can be solved by putting all the numbers from the array `nums` in a hashmap to look which one is missing. A better way might be to take the sum of numbers from 1 to n and work from there back. The sum is as follows:
- ``1 + 2 + ... + n = n * (n + 1)``

That means that any missing number has to be:
- ``x = n * (n + 1) - (1 + 2 + ... + n) - x``
- x is the missing number from the array

Following are the solutions in code

---
## Brute Force

gathering all in hashmap and looking for which one is missing
```
// time O(n)
// space O(n)
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
```
---
## HashTable passing twice

summing all elements from 1 to n(rather 0 to n -1 and n on top) minus all elements in the array which leaves the missing one
```
// time O(n)
// space O(1)
public int missingNumberGausSmart(int[] nums) {
    int sum = nums.length;
    for(int i = 0; i<nums.length;i++) {
        sum += i - nums[i];
    }
    return sum;
}
```
---
## Hashtable passing once

using the gaus formula and taking away every item in the array which leaves the missing one
```
// time O(n)
// space O(n)

public int missingNumberGausDumb(int[] nums) {
    int sum = nums.length * (nums.length+1) / 2;
    for(int i = 0; i<nums.length; i++) {
        sum -= nums[i];
    }
    return sum;
}
```