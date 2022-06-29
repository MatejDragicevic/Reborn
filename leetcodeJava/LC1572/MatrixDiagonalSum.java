class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;
        for(int i = 0; i<n; i++)
        {
            int antidiag = (i!=n-i-1) ? mat[i][n-i-1] : 0;
            sum += mat[i][i] + antidiag;
        }
        return sum;
    }
}