class Solution {
    public void rotate(int[][] matrix) {
        // // Idea 1: (matrix-copy) make a new matrix the same size of original one.
        // // copy first row of original matrix as last column of new matrix; second row as last-1 column etc.
        // // Time: O(n), Size: O(n*m) -> save whole matrix separately
        
        // int size = matrix.length;
        // int[][] rotatedMatrix = new int[size][size];
        
        // // first row -> to last column ([0][0] -> [0][n], [0][1] -> [1][n], ..., [0][n] -> [n][n])
        // // second row -> to last-1 column ([1][0] -> [0][n-1], [1][1] -> [1][n-1], ..., [1][n] -> [n][n-1])
        // // ...
        // // last row -> to first column ([n][0] -> [0][0], [n][1] -> [1][0], ..., [n][n] -> [n][0])
        // for(int matrRow = 0; matrRow < size; matrRow++) {
        //     for(int matrCol = 0; matrCol < size; matrCol++) {
        //         rotatedMatrix[matrCol][size - 1 - matrRow] = matrix[matrRow][matrCol];
        //     }
        // }
        
        // // copy rotated matrix to original
        // for(int i = 0; i < size; i++) {
        //     for(int j = 0; j < size; j++)
        //         matrix[i][j] = rotatedMatrix[i][j];
        // }
        
        // Idea 2: (saving only row/col + snake-walkthrough) iterate the original matrix in snake-clockerwise.
        // put second element (row or column) in buffer, owerwrite it by the first element (column or row),
        // use buffer for the next iteration. Move into the center after 4 iterations (circle).
        // Time: O(n), Size: O(|row|) -> save only row/column separately
        
        // // DOES NOT WORK FOR ARRAYS OF SIZE > 6
        // // Idea 3: (math, one number at a time) mount first number to the right place,
        // // by putting overwritted element before in the buffer.
        // // Continue doing so from next element.
        // // If returned to the beginning (after 4 movements) -> step to next element untill all n*n are rotated.
        // // Time: O(n), Size: O(1) -> save only one number separately

        // // corner-cases
        // if(matrix == null || matrix.length <= 1)
        //     return;
        
        // int size = matrix.length;
        // int processedElementsCount = 0; // how many numbers of matrix were rotated (set to the right rotated position)
        // int originRow = 0;
        // int originCol = 0;
        // int buffer;                     // saving the number before overwriting it
        // int tmp;
        // // to controll 'moving' pointers after each 4-elements-rotations
        // int start = 0;
        // int end = size - 1;

        // // iterate untill each element is on the right (rotated) position
        // while(processedElementsCount < size * size - 1) {
        //     // set first element to overwrite (rotate)
        //     buffer = matrix[originRow][originCol];

        //     // process a single 'circle' (move 4 elements clockerwise) => 'processedElementsCount' will be added 4-times
        //     for(int i = 0; i < 4; i++) {
        //         int newRow = originCol;
        //         int newCol = size - 1 - originRow;

        //         tmp = matrix[newRow][newCol];       // save to buffer number that will be owerwritten
        //         matrix[newRow][newCol] = buffer;    // overwrite with new rotated element
        //         buffer = tmp;
                
        //         // update row/col-indexes
        //         originRow = newRow;
        //         originCol = newCol;

        //         // increment counter
        //         processedElementsCount++;
        //     }
        //     // now we returned to the start-point before 4-rotations
        //     // need move to the right (if it is not the last element in the row)
        //     if(originCol < end - 1) {
        //         originCol++;    // move 1 step right (col)
        //     } else {
        //         // move 1 step down () row and to the beginning (col)
        //         originRow++;
        //         originCol = ++start;
        //     }
        // }

        // Smart idea: clockerwise -> first reverse up to down, then swap the symmetry (reverse left to right)
        /*
         * clockwise rotate
         * first reverse up to down, then swap the symmetry 
         * 1 2 3     7 8 9     7 4 1
         * 4 5 6  => 4 5 6  => 8 5 2
         * 7 8 9     1 2 3     9 6 3
        */

        int start = 0;
        int end = matrix.length - 1;

        // flip the matrix horizontally
        while(start < end) {
            // swap first and last elements
            int[] temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;
            // move pointers closer
            start++;
            end--;
        }

        // transpose matrix
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i + 1; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // // Equivalent: firstly transpose the matrix and then flip it symmetrically
        // for(int i = 0; i<matrix.length; i++){
        //     for(int j = i; j<matrix[0].length; j++){
        //         int temp = 0;
        //         temp = matrix[i][j];
        //         matrix[i][j] = matrix[j][i];
        //         matrix[j][i] = temp;
        //     }
        // }
        // for(int i =0 ; i<matrix.length; i++){
        //     for(int j = 0; j<matrix.length/2; j++){
        //         int temp = 0;
        //         temp = matrix[i][j];
        //         matrix[i][j] = matrix[i][matrix.length-1-j];
        //         matrix[i][matrix.length-1-j] = temp;
        //     }
        // }
    }
}