class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int i=0; i<9;i++)
        {
            for(int j=0; j<9; j++)
            {
                char digit = board[i][j];
                if(digit != '.')
                {
                    boolean notInRows = seen.add(digit + " in row " + i);
                    boolean notInCols = seen.add(digit + " in column " + j);
                    boolean notInCube = seen.add(digit + " in cube " + i/3 + "-" + j/3);
                    if(!notInRows || !notInCols || !notInCube) return false;
                }
            }
        }
        return true;
    }
}