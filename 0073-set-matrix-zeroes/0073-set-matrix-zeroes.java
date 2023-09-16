class Solution {
    public void setZeroes(int[][] matrix) {
        // Space: O(m*n) -> just make a copy of the matrix, travers the original one and change the new one

        // Space: O(m+n) -> bool-arrays for columns and rows to save wether they should be set to 0 or not
        
        // Constant Space -> use firs (0) row and col of a matrix to store the values (instead of additional bool-arrays)
        // *trick: we need additional variable for the (0,0), otherwise it will appear twice => additional steps for the first row/col

        int width = matrix[0].length;
        int height = matrix.length;
//        boolean[] setColToZero = new boolean[width];
//        boolean[] setRowToZero = new boolean[height];
//        // initially all rows/cols are 0 (no changes)
//        for(boolean val : setRowToZero)
//            val = false;
//        for(boolean val : setColToZero)
//            val = false;
        boolean firstRow = false;
        boolean firstCol = false;

        // travers the original matrix and fill-up bool-areas if the row/col needs to be = 0
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(matrix[i][j] == 0) {
                    // set 0-th row/col of matrix = 0
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    // mark additionally first row/col
                    if(i == 0) firstRow = true;
                    if(j == 0) firstCol = true;
                }

//                // mark corresponding rows/cols-variables if cell is 0
//                if(matrix[i][j] == 0) {
//                    setRowToZero[i] = true;
//                    setColToZero[j] = true;
//                }
            }
        }

        // change the initial matrix according to the values in bool-variables
        for(int i = 1; i < height; i++) {
            for(int j = 1; j < width; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;

//                // set cell = 0 if its row/cal is in marked so in bool-vars
//                if(setRowToZero[i] || setColToZero[j])
//                    matrix[i][j] = 0;
            }
        }

        // set to 0 (if needed) first row/col
        if(firstRow) {
            for(int j = 0; j < width; j++)
                matrix[0][j] = 0;
        }
        if(firstCol) {
            for(int i = 0; i < height; i++)
                matrix[i][0] = 0;
        }
    }
}