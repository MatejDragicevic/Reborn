class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m==0 || n==0) return 0;
        
        int fresh = 0;
        Deque<int[]> rotten = new LinkedList<>();
        
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
            {
                if      (grid[i][j]==2) rotten.add(new int[]{i, j});
                else if (grid[i][j]==1) fresh++;
            }
        
        // no fresh ones is instantly done
        if(fresh == 0) return 0;
        
        int minutes = 0;
        while(!rotten.isEmpty())
        {
            minutes++;
            int currentlyRotting = rotten.size();
            
            for(int i=0; i<currentlyRotting; i++)
            {
                int[] rottingOrange = rotten.poll();
                int[][] adjecentSides = {
                    {-1, 0}, {1, 0}, {0, -1}, {0, 1}
                };
                
                for(int[] side : adjecentSides)
                {
                    int row = rottingOrange[0] + side[0];
                    int col = rottingOrange[1] + side[1];
                    
                    if(!outOfBoundsOrEmptyOrRotten(row,col,grid))
                    {
                        rotten.add(new int[]{row, col});
                        grid[row][col] = 2;
                        fresh--;
                    }
                }
            }
        }
        // still fresh ones left means they can't be reached
        if(fresh > 0) return -1;
        
        //the last minute will add no further rotting oranges
        return minutes-1;
    }
    private boolean outOfBoundsOrEmptyOrRotten(int x, int y, int[][] grid)
    {
        return x < 0
            || y < 0
            || x >= grid.length
            || y >= grid[0].length
            || grid[x][y] == 0
            || grid[x][y] == 2;
    }
}