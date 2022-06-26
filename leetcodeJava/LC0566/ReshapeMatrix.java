class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if(r*c != m*n) return mat;
        int[][] reshaped = new int[r][c];
        for(int i = 0; i<r;i++)
        {
            for(int j = 0;j<c;j++)
            {
                int x = (i*c + j) / n;
                int y = (i*c + j) % n;
                reshaped[i][j] = mat[x][y];
            }
        }
        return reshaped;
    }
}