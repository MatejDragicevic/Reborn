import java.util.Arrays;

class Solution {
    private List<List<String>> queensOnBoard;
    private int boardSize;

    public List<List<String>> solveNQueens(int n) {
        queensOnBoard = new ArrayList<>();
        boardSize = n;

        char[][] charBoard = new char[boardSize][boardSize];
        for(char[] boardRow: charBoard)
        {
            Arrays.fill(boardRow, '.');
        }
        
        int row, column, diagonal, antidiagonal;
        row = column = diagonal = antidiagonal = 0;
        backtrack(charBoard, row, column, diagonal, antidiagonal);

        return queensOnBoard;
    }

    private List<String> boardListFromChar(char[][] charBoard)
    {
        List<String> stringBoard = new ArrayList<>();
        for (char[] boardRow : charBoard)
        {
            stringBoard.add(new String(boardRow));
        }
        return stringBoard;
    }

    private void backtrack(char[][] charBoard, int row, int col, int diag, int antiDiag)
    {
        boolean allRowsFilled = (row == boardSize);
        if(allRowsFilled)
        {
            queensOnBoard.add(boardListFromChar(charBoard));
            return;
        }

        for (int currCol = 0; currCol < boardSize; currCol++)
        {
            int currDiag = row - currCol + boardSize;
            int currAntiDiag = row + currCol;

            boolean columnTaken = (col & (1 << currCol) ) != 0;
            boolean diagonalTaken = (diag & (1 << currDiag) ) != 0;
            boolean antiDiagonalTaken = (antiDiag & (1 << currAntiDiag) ) != 0;
            if(columnTaken || diagonalTaken || antiDiagonalTaken) continue;

            charBoard[row][currCol] = 'Q';
            col |= (1 << currCol);
            diag |= (1 << currDiag);
            antiDiag |= (1 << currAntiDiag);

            backtrack(charBoard, row+1, col, diag, antiDiag);

            charBoard[row][currCol] = '.';
            col ^= (1 << currCol);
            diag ^= (1 << currDiag);
            antiDiag ^= (1 << currAntiDiag);
        }
    }
}