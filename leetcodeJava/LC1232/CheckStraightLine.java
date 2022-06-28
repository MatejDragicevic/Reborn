class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length <3) return true;
        int x = coordinates[1][0] - coordinates[0][0];
        boolean xZero = x==0;
        
        int y = coordinates[1][1] - coordinates[0][1];
        boolean yZero = y==0;
        for(int i = 2;i<coordinates.length;i++)
        {
            int tempX = coordinates[i][0] - coordinates[i-1][0];
            if(xZero && x!=tempX) return false;
            
            int tempY = coordinates[i][1] - coordinates[i-1][1];
            if(yZero && y!=tempY) return false;
            
            if(!xZero && !yZero && (tempX/x != tempY/y || x/tempX != y/tempY)) return false;
        }
        return true;
    }
}