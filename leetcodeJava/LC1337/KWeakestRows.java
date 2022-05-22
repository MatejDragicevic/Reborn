import java.util.Arrays;

// time O(n log n)
// space O(n)
class Solution {
    
    // log m
    // m = cols = mat[0].length
    public static int binSearchLeftOnes(int[] soldierRows) {
        int low = 0;
        int high = soldierRows.length;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if(soldierRows[mid] == 1)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
    
    public static int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        int[] rowValue = new int[rows];
        int j = 0;
        
        // for * BinSearch
        // n * log m
        for(int i = 0; i<rows; i++){
            j = binSearchLeftOnes (mat[i]);
            rowValue[i] = j * rows + i;
        }
        
        // n * log n
        Arrays.sort(rowValue);

        for(int i = 0; i<k; i++) {
            rowValue[i] = rowValue[i] % rows;
        }
        
        return Arrays.copyOfRange(rowValue, 0, k);
    }
    
}