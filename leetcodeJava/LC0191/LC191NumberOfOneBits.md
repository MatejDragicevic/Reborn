# Number of 1 Bits LC 191

[code](NumberOfOneBits.java)
- [LC191 Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/)
> Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the [Hamming weight](https://en.wikipedia.org/wiki/Hamming_weight)).

**Note:**
- Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned
- In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in **Example 3**, the input represents the signed integer. ``-3``.

**Example 1**:
```
Input: n = 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
```
**Example 2**:
```
Input: n = 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
```
**Example 3**:
```
Input: n = 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
```

**Constaints**:
> The input must be a binary string of length 32.

---

# Solutions

The number of one bits can be found a few ways. First would be to generate the string of bits and loop through the string comparing each character with ``'1'``. Java has an one liner to do the same in one line with ``Integer.bitCount(n)``. The last and most interesting answer is a patter first observed by Brian Kernighan [described here](https://stackoverflow.com/questions/12383002/please-explain-the-logic-behind-kernighans-bit-counting-algorithm).

---
## String comparison

"manual" solution
```
// time O(n)
// space O(1)

public int hammingWeight(int n) {
    String unsignedInt = Integer.toBinaryString(n);
    int count = 0;
    for(int i = 0; i<unsignedInt.length(); i++) {
        if(unsignedInt.charAt(i) == '1') {
            count++;
        }
    }
    return count;
}
```
---
## Java one liner

the built in method solves the problem
```
// time O(n)
// space O(1)

public int hammingWeightOneLine(int n) {
    return Integer.bitCount(n);
}
```
---
## Kernighan n & n-1 pattern

best time complexity with constant space
```
// time O(logn)
// space O(1)

public int hammingWeightBitWise(int n) {
    int count = 0;
    while(n!=0) {

        n &= n-1;
        count++;
    }
    return count;
}
```