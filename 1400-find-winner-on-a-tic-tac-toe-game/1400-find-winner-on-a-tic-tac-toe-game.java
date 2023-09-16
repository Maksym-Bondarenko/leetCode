class Solution {
    public String tictactoe(int[][] moves) {
        // Tic-Tac-Toe Matrix:
        // Rows (3)
        // [0,0] [0,1] [0,2]    => r = 0
        // [1,0] [1,1] [1,2]    => r = 1
        // [2,0] [2,1] [2,2]    => r = 2
        // Colums (3)
        // [0,0] [1,0] [2,0]    => c = 0
        // [0,1] [1,1] [2,1]    => c = 1
        // [0,2] [1,2] [2,2]    => c = 2
        // Diagonals (2)
        // [0,0] [1,1] [2,2]    => r = c
        // [0,2] [1,1] [2,0]    => r + c = n

        int n = 3;                  // size of Tic-Tac-Toe field
        int[] rows = new int[n];    // sum of moves for each row
        int[] cols = new int[n];    // sum of moves for each col
        int diag1 = 0;              // sum of moves for main diagonal
        int diag2 = 0;              // sum of moves for secondary diagonal
        int numMoves = moves.length;

        for(int i = 0; i < numMoves; i++) {
            int value = i % 2 == 0 ? 1 : -1;  // '1' for A, '-1' for B
            int row = moves[i][0];            // first element is row
            int col = moves[i][1];            // second element is col
            // add values of moves to the row/cols
            rows[row] += value;
            cols[col] += value;
            // add values of moves to the diagonals
            if(row == col)
                diag1 += value;
            if(row + col == n - 1)
                diag2 += value;
            // check winner (cols/rows/diagonals)
            if(rows[row] == n || cols[col] == n || diag1 == n || diag2 == n)
                return "A";
            if(rows[row] == 0-n || cols[col] == 0-n || diag1 == 0-n || diag2 == 0-n)
                return "B";
        }

        // if no winners -> check on draw/pending
        return numMoves == 9 ? "Draw" : "Pending";
    }
}