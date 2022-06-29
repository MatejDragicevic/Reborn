class Solution {
    int[][] grid;
    boolean[][] visited;
    
    public int maxAreaOfIsland(int[][] grid)
    {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        int max = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                max = Math.max(max, area(i, j));
            }
        }
        return max;
    }
    
    public int area(int x, int y)
    {
        if (x < 0 || x >= grid.length |
            y < 0 || y >= grid[0].length ||
            visited[x][y] || grid[x][y] == 0)
        {
            return 0;            
        }
        
        visited[x][y] = true;
        
        return (1 +
                area(x+1, y) +
                area(x-1, y) +
                area(x, y-1) +
                area(x, y+1));
    }

    
}