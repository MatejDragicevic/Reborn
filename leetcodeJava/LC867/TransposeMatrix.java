class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int rowLenght = matrix[0].length;
        int colLenght = matrix.length;
        int[][] result = new int[rowLenght][colLenght];
        for(int row = 0; row < colLenght; row++)
        {
            for(int col = 0; col < rowLenght; col++)
            {
                result[col][row] = matrix[row][col];
            }
        }
        return result;
    }
}