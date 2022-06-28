class Solution {
    //failing
    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length*matrix[0].length - 1;
        return binarySearch(matrix, 0, length, target);
    }
    public boolean binarySearch(int[][] matrix, int min, int max, int target)
    {
        if(min>max) return false;
        int mid = (min+max)/2;
        int m = matrix[0].length;
        int i = mid / m;
        int j = mid % m;
        if(matrix[i][j] == target) return true;
        else if(matrix[i][j] > target) return binarySearch(matrix,mid+1,max,target);
        else if(matrix[i][j] < target) return binarySearch(matrix,min,mid-1,target);
        return false;
    }

    
    public boolean searchMatrixOptimal(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0) {
          if(matrix[i][j] == target)
            return true;
          else if(matrix[i][j] > target)
            j --;
          else if(matrix[i][j] < target)
            i ++;
        }
        return false;
      }
}