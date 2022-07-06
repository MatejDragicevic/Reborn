class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        if(m==0 || n==0) return mat;
        int[][] updated = new int[m][n];
        
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
            {
                if(mat[i][j]==0) updated[i][j]=0;
                else
                {
                    int top         = (i>0) ? updated[i-1][j] : Integer.MAX_VALUE/2;
                    int left        = (j>0) ? updated[i][j-1] : Integer.MAX_VALUE/2;
                    updated[i][j]   = Math.min(top, left) + 1;
                }
            }
        
        for(int i=m-1; i>=0; i--)
            for(int j=n-1; j>=0; j--)
            {
                if(mat[i][j]==0) updated[i][j]=0;
                else
                {
                    int bot         = i<m-1 ? updated[i+1][j] : Integer.MAX_VALUE/2;
                    int right       = j<n-1 ? updated[i][j+1] : Integer.MAX_VALUE/2;
                    int temp        = Math.min(bot, right)+1;
                    updated[i][j]   = Math.min(updated[i][j],temp);
                }
            }
        
        return updated;
    }
}