# Range Sum Query 2D - Immutable LC 304

[code](ImmutableRangeSumQuery2D.java)
- [LC867 The K Weakest Rows in a Matrix](https://leetcode.com/problems/range-sum-query-2d-immutable/)

> Given a 2D matrix ``matrix``, handle multiple queries of the following type:
> - Calculate the **sum** of the elements of ``matrix`` inside the rectangle defined by its **upper left corner** ``(row1, col1)`` and **lower right corner** ``(row2, col2)``.

> Implement the NumMatrix class:
> - ``NumMatrix(int[][] matrix)`` Initializes the object with the integer matrix ``matrix``.
> - ``int sumRegion(int row1, int col1, int row2, int col2)`` Returns the **sum** of the elements of ``matrix`` inside the rectangle defined by its **upper left corner** ``(row1, col1)`` and **lower right corner** ``(row2, col2)``.

**Example**:

![screenshot](https://assets.leetcode.com/uploads/2021/03/14/sum-grid.jpg)
```
Input
["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
Output
[null, 8, 11, 12]

Explanation
NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
```

**Constaints**:
> m == matrix.length

> n == matrix[i].length

> 1 <= m, n <= 200

> -10^5 <= matrix[i][j] <= 10^5

> 0 <= row1 <= row2 < m

> 0 <= col1 <= col2 < n

> At most 10^4 calls will be made to sumRegion

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
## Cache Rows

When creating the numMatrix, we can add another column for the sum and subtract the start from the end to avoid looping through multiple variables. Let's assume we have the following matrix:
```
matrix:
row0	0	1	2	3	4
row1	5	6	7	8	9
row2	10	11	12	13	14
row3	15	16	17	18	19
row4	20	21	22	23	24
```
then the numMatrix would be:
```
numMatrix:
row0	0	0	1	3	6	10
row1	0	5	11	18	26	35
row2	0	10	21	33	46	60
row3	0	15	31	48	66	85
row4	0	20	41	63	86	110
```
Let's sum the first row:
- if we check the sum from the first row, it is:
    - ``0+1+2+3+4 = 10``

- let's use the sum algorithm for each position from 0 to 4:
    - ``sum += numMatrix[i][col2 + 1] - numMatrix[i][col1]``

- the sum for that row would be:
    - ``numMatrix[0][4 + 1] - numMatrix[0][0] = 10 - 0 = 10``

Let's do it for row2 from 1 to 3:
- if we check the sum from row2 1 to 3, it is:
    - ``11+12+13 = 36``

- let's use the sum algorithm for row2 1 to 3:
    - ``numMatrix[2][3 + 1] - numMatrix[2][1] = 46 - 10 = 36``

Time and space:
- ``O(R*C)`` time complexity - looping through R and C
- ``O(R*C)`` space complexity - generating a new matrix C * R
```
class NumMatrixCachingRows {
    int[][] numMatrix;
    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        numMatrix = new int [matrix.length][matrix[0].length +1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                numMatrix[i][j+1] = numMatrix[i][j] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1;i<=row2;i++)
        {
            sum += numMatrix[i][col2 + 1] - numMatrix[i][col1];            
        }
        return sum;
    }
}
```
---

## Cache Rows Spacial

We can look at the sum as addition and subtraction of areas of sums in relation to ``O(0,0)``. Se the following pictures:
The area from ``O`` to the ``(row2, col2)`` as ``OD``

![screenshot1](https://leetcode.com/static/images/courses/sum_od.png)

The area from ``O`` to the ``(row2, col1)`` as ``OB``

![screenshot2](https://leetcode.com/static/images/courses/sum_ob.png)

The area from ``O`` to the ``(row1, col2)`` as ``OC``

![screenshot3](https://leetcode.com/static/images/courses/sum_oc.png)

The area from ``O`` to the ``(row1, col1)`` as ``OA``

![screenshot4](https://leetcode.com/static/images/courses/sum_oa.png)

To get our required sum we need to take:
- ``sum[(row1,col1) -> (row2,col2)] = OD - OB - OC + OA``
- Notice that OA is part of both OB and OC so it has to be added again after subtracting both.

Here is the matrix to demonstrate the algorithm:
```
matrix:
row0	0	1	2	3	4
row1	5	6	7	8	9
row2	10	11	12	13	14
row3	15	16	17	18	19
row4	20	21	22	23	24
```
then the numMatrix would be generated as:
- ``numMatrix[i+1][j+1] = matrix[i][j] + numMatrix[i+1][j] + numMatrix[i][j+1] - numMatrix[i][j]``
- the ``(0,x)`` and ``(x,0)`` positions are all 0
```
numMatrix:
row1	0	1	3	6	10
row2	5	12	21	32	45
row3	15	33	54	78	105
row4	30	64	102	144	190
row5	50	105	165	230	300
```
Let's sum the first row:
- if we check the sum from the first row, it is:
    - ``0+1+2+3+4 = 10``

- let's use the sum algorithm for each position from 0 to 4:
    - ``sum += numMatrix[i][col2 + 1] - numMatrix[i][col1]``

- the sum for that row would be:
    - ``numMatrix[0][4 + 1] - numMatrix[0][0] = 10 - 0 = 10``

Let's do it for row2 from 1 to 3:
- if we check the sum from row2 1 to 3, it is:
    - ``11+12+13 = 36``

- let's use the sum algorithm for row2 1 to 3:
    - ``numMatrix[2][3 + 1] - numMatrix[2][1] = 46 - 10 = 36``

Time and space:
- ``O(R*C)`` time complexity - O(R) time per query and O(R*C) precomputation
- ``O(R*C)`` space complexity - generating a new matrix C * R
```
class NumMatrixCachingRows {
    int[][] numMatrix;
    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        numMatrix = new int [matrix.length][matrix[0].length +1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                numMatrix[i][j+1] = numMatrix[i][j] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1;i<=row2;i++)
        {
            sum += numMatrix[i][col2 + 1] - numMatrix[i][col1];            
        }
        return sum;
    }
}
```