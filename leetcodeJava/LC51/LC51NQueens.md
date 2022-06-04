# N-Queens LC 51

[code](NQueens.java)
- [LC51 N-Queens](https://leetcode.com/problems/n-queens/)

> The **n-queens** puzzle is the problem of placing ``n`` queens on an ``n x n`` chessboard such that no two queens attack each other.

Given an integer ``n``, return all distinct solutions to the ***n-queens puzzle***. You may return the answer in **any order**.

Each solution contains a distinct board configuration of the n-queens' placement, where ``'Q'`` and ``'.'`` both indicate a queen and an empty space, respectively.

**Example1**:

![screenshot](https://assets.leetcode.com/uploads/2020/11/13/queens.jpg)

```
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
```

**Example2**:

```
Input: n = 1
Output: [["Q"]]
```

**Constaints**:
> 1 <= n <= 9

---

# Solutions

Asides to creating a matrix in the class, there are ways to sum the elements on each of these positions. The obvious one is brute force summing from the lower to the upper position for rows and columns. Other solutions use caching to precalculate the sums and subtract the sums at lower positioned entries.

---
## Brute Force

Simply loop through ``(row1, col1)`` to ``(row2, col2)`` and sum everything
- ``O(R*C)`` time complexity - looping through R and C
- ``O(1)`` numMatrix is not a copy of the original matrix
```
class NumMatrixBruteForce {
    int[][] numMatrix;
    public NumMatrix(int[][] matrix) {
        numMatrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1;i<=row2;i++)
        {
            for(int j = col1;j<=col2;j++)
            {
                sum += this.numMatrix[i][j];
            }
            
        }
        return sum;
    }
}
```

---
