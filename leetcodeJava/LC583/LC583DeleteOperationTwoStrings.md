# Delete Operation for Two Strings 583

Given two strings ``word1`` and ``word2``, return the minimum number of **steps** required to make ``word1`` and ``word2`` the same.

In one **step**, you can delete exactly one character in either string.

**Example 1:**
```
Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
```

**Example 2:**
```
Input: word1 = "leetcode", word2 = "etco"
Output: 4
```

**Constaints**:
> 1 <= word1.length, word2.length <= 500

> ``word1`` and ``word2`` consist of only lowercase English letters.

> -10^9 <= target <= 10^9

> Only one valid answer exists

---

# Solutions


---
## Longest Common Subsequence

the worst time complexity with the best space complexity
```
// time O(2^max(m,n))
// space O(m+n)


public class Solution {
    public int minDistance(String s1, String s2) {
        return s1.length() + s2.length() - 2 * lcs(s1, s2, s1.length(), s2.length());
    }
    public int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return 1 + lcs(s1, s2, m - 1, n - 1);
        else
            return Math.max(lcs(s1, s2, m, n - 1), lcs(s1, s2, m - 1, n));
    }
}

```
---
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
---