class Solution {
    public String generateQueenRow(int index, int n)
    {
        String rowWithQueen = "";
        for(int i = 0; i<n;i++) {
            if(i==index) {
                rowWithQueen+="Q";
            }
            else
            {
                rowWithQueen +=".";
            }
        }
        return rowWithQueen;
    }
    public List<List<String>> solveNQueens(int n) {
        
    }
}