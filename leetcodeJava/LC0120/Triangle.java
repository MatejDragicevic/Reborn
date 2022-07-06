class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] pathWays = new int[n+1][n+1];
        
        for(int row=n-1; row>=0; row--)
            for(int path=0; path<=row; path++)
            {
                int triangleValuePath = triangle.get(row).get(path);
                int maxValueBelow = Math.min(pathWays[row+1][path], pathWays[row+1][path+1]);
                pathWays[row][path] = triangleValuePath + maxValueBelow;
            }
        return pathWays[0][0];
    }
}