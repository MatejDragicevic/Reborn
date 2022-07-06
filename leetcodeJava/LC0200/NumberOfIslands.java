class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0; i<grid.length; i++)
            for(int j=0;j<grid[0].length; j++)
                if(grid[i][j]=='1' && !seen[i][j])
                {
                    helper(seen, grid, i, j);
                    count++;
                }
        return count;
    }
    private void helper(boolean[][] seen, char[][] grid, int i, int j)
    {
        if(outOfBounds(i,j,seen)
          || seen[i][j]==true
          || grid[i][j]=='0') return;
        seen[i][j] = true;
        helper(seen, grid, i-1, j);
        helper(seen, grid, i+1, j);
        helper(seen, grid, i, j-1);
        helper(seen, grid, i, j+1);
    }
    private boolean outOfBounds(int i, int j, boolean[][] seen)
    {
        int m = seen.length;
        int n = seen[0].length;
        if(i<0 || j<0 || i>=m || j>=n) return true;
        return false;
    }
}