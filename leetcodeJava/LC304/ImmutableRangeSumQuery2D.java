class NumMatrixMySolution {
    int[][] numMatrix;
    int rows;
    int cols;
    public NumMatrix(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        numMatrix = new int[rows][cols];
        for(int i = 0;i<rows;i++)
        {
            for(int j = 0;j<cols;j++)
            {
                numMatrix[i][j] = matrix[i][j];
            }
        }
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

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */