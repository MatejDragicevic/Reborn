import java.util.Arrays;

class KWeakestRows {

    public static int leftOnes(int[] array) {
        int low = 0;
        int high = array.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == 1)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[] rowValue = new int[rows];
        int j = 0;

        for (int i = 0; i < rows; i++) {
            j = leftOnes(mat[i]);
            rowValue[i] = j * rows + i;
        }

        Arrays.sort(rowValue);
        for (int i = 0; i < k; i++) {
            rowValue[i] = rowValue[i] % rows;
        }

        return Arrays.copyOfRange(rowValue, 0, k);
    }
}
