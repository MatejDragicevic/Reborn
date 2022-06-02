# Transpose Matrix LC 867

[code](TransposeMatrix.java)
- [LC867 The K Weakest Rows in a Matrix](https://leetcode.com/problems/transpose-matrix/)
> Given a 2D integer array ``matrix``, return the ***transpose*** of ``matrix``.

![alt text](https://assets.leetcode.com/uploads/2021/02/10/hint_transpose.png)

>The ***transpose*** of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.

**Example 1**:
```
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
```
**Example 2**:
```
Input: matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]
```

**Constaints**:
> m == matrix.length

> n == matrix[i].length

> 1 <= m, n <= 1000

> 1 <= m * n <= 10^5

> -10^9 <= matrix[i][j] <= 10^9

---

# Solution

The solution is pretty straight forward. To transpose a matrix you have to create a new matrix with rows equals to the colums of the input matrix and with columns equal to the rows of the input matrix. Then you have to loop through the input matrix doing the following:
- ``outputMatrix[col][row] = matrix[row][col]``

---
## Transpose

If R are the rows and C are the colums of the input matrix, the solution will be:
- ``O(R*C)`` time complexity - looping through R and C
- ``O(R*C)`` space complexity - generating a new matrix C * R
```
public int[][] transpose(int[][] matrix) {
    int rowLenght = matrix[0].length;
    int colLenght = matrix.length;
    int[][] result = new int[rowLenght][colLenght];
    for(int row = 0; row < colLenght; row++)
    {
        for(int col = 0; col < rowLenght; col++)
        {
            result[col][row] = matrix[row][col];
        }
    }
    return result;
}
```