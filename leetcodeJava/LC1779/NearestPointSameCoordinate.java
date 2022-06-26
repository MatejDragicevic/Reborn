class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i<points.length;i++)
        {
            int dist = Math.abs(x-points[i][0]) + Math.abs(y-points[i][1]);
            boolean valid = (x == points[i][0] || y == points[i][1]);
            if(dist<min && valid)
            {
                index = i;
                min = dist;
            }
        }
        return index;
    }
}