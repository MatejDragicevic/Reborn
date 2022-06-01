# The K Weakest Rows in a Matrix LC 1337

[code](KWeakestRows.java)
- [LC1337 The K Weakest Rows in a Matrix](https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/)
> You are given an ``m x n`` binary matrix ``mat`` of ``1``'s (representing soldiers) and ``0``'s (representing civilians). The soldiers are positioned **in front** of the civilians. That is, all the ``1``'s will appear to the **left** of all the ``0``'s in each row.

> A row ``i`` is weaker than a row ``j`` if one of the following is true:
> - The number of soldiers in row ``i`` is less than the number of soldiers in row ``j``.
> - Both rows have the same number of soldiers and ``i < j``.

> Return the indices of the ``k`` ***weakest*** rows in the matrix ordered from weakest to strongest.

**Example 1**:
```
Input: mat = 
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]], 
k = 3
Output: [2,0,3]
Explanation: 
The number of soldiers in each row is: 
- Row 0: 2 
- Row 1: 4 
- Row 2: 1 
- Row 3: 2 
- Row 4: 5 
The rows ordered from weakest to strongest are [2,0,3,1,4].
```
**Example 2**:
```
Input: mat = 
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]], 
k = 2
Output: [0,2]
Explanation: 
The number of soldiers in each row is: 
- Row 0: 1 
- Row 1: 4 
- Row 2: 1 
- Row 3: 1 
The rows ordered from weakest to strongest are [0,2,3,1].
```

**Constaints**:
> m == mat.length

> n == mat[i].length

> 2 <= n, m <= 100

> 1 <= k <= m

> matrix[ i ][ j ] is either 0 or 1.

---

# Solution

To tackle the problem we first have to figure out how many soldiers / `1`'s are in each row. For this BinSearch is used. After that the problem of the row with a smaller number(index) can be addressed. So the number of soldiers is heavier, but the index decieds between rows with the same amount of soldiers.
We can solve this problem by using a row length as a basis, and the index should be added to make comparison between rows with same amount of soldiers possible. For example:
- the rows `value` will be ``j * rows + i``
- each row has only one soldier
    - this gives us the rows values of ``[5, 6, 7, 8, 9]``
    - the list of weakest rows is ``[0, 1, 2]``
- the rows have the following amount of soldiers ``[2, 4, 1, 2, 5]``
    - this gives us the rows values of ``[10, 21, 7, 13, 29]``
    - the list of weakest rows is ``[2, 0, 3]``

The only problem that needs to be solved here is how to get the index of the row in question? Simple! Modulo operation:
- ``rowIndex = rowValue % rowLength``

---
## Binary search

Half the count, if you encounter a soldier, look for the upper part. Else take the lower part.
low / mid / high (pos)
- 0 / 2 / 5 (0) -> 0 / 2 / 2 -> 0 / 1 / 1 -> 1 / 0 / 1 -> 1
- 0 / 2 / 5 (1) -> 0 / 2 / 2 -> 2 / 1 / 2 -> 2
- 0 / 2 / 5 (2) -> 3 / 2 / 5 -> 3 / 4 / 4 -> 3 / 3 / 3 -> 3
- 0 / 2 / 5 (3) -> 3 / 2 / 5 -> 3 / 4 / 4 -> 4 / 3 / 4 -> 4
- 0 / 2 / 5 (4) -> 3 / 2 / 5 -> 5 / 4 / 5 -> 5

It might be confusing why we have the position ``i`` but the result of ``i+1``. The position is not the same as the number of soldiers.
```
// log m
// m = cols = mat[0].length
public static int binSearchLeftOnes(int[] soldierRows) {
    int low = 0;
    int high = soldierRows.length;
    
    while (low < high) {
        int mid = low + (high - low) / 2;
        
        if(soldierRows[mid] == 1)
            low = mid + 1;
        else
            high = mid;
    }
    return low;
}
```
---
## Complete code

gather the row values, sort them, return the index of the first k
```
public static int[] kWeakestRows(int[][] mat, int k) {
    int rows = mat.length;
    int cols = mat[0].length;
    
    int[] rowValue = new int[rows];
    int j = 0;
    
    // for and Bin Search
    // n * log m
    for(int i = 0; i<rows; i++){
        j = binSearchLeftOnes (mat[i]);
        rowValue[i] = j * rows + i;
    }
    
    // n * log n
    Arrays.sort(rowValue);

    for(int i = 0; i<k; i++) {
        rowValue[i] = rowValue[i] % rows;
    }
    
    return Arrays.copyOfRange(rowValue, 0, k);
}
```