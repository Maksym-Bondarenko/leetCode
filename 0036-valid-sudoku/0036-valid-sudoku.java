class Solution {
    public boolean isValidSudoku(char[][] board) {
//         // Idea 1: (simulation problem with HashSet for values-remembering)
//         // check all rows, columns and 3x3-squares wether they have duplicated values via HS
//         // go 3-times through matrix with 1 HS
//         // Time: O(n), Space: O(n) -> time 3*n, space 1*n
        
//         Set<Character> uniqueValues = new HashSet<>();
//         int height = board.length;
//         int length = board[0].length;
        
//         // iterate through all rows
//         for(int row = 0; row < height; row++) {
//             uniqueValues.clear();   // emptry HS after each row
//             for(int col = 0; col < length; col++) {
//                 if(board[row][col] != '.') {
//                     // if HS already has current value -> return false
//                     if(uniqueValues.contains(board[row][col]))
//                         return false;
//                     else
//                         uniqueValues.add(board[row][col]);
//                 }
//             }
//         }
        
//         // iterate through all columns
//         for(int col = 0; col < length; col++) {
//             uniqueValues.clear();   // emptry HS after each col
//             for(int row = 0; row < length; row++) {
//                 if(board[row][col] != '.') {
//                     if(uniqueValues.contains(board[row][col]))
//                         return false;
//                     else
//                         uniqueValues.add(board[row][col]);
//                 }
//             }
//         }
            
//         // iterate through all 3x3-squares
//         // [0,0] [0,1] [0,2]  [0,3] [0,4] [0,5]  [0,6] [0,7] [0,8]
//         // [1,0] [1,1] [1,2]  [1,3] [1,4] [1,5]  [1,6] [1,7] [1,8]
//         // [2,0] [2,1] [2,2]  [2,3] [2,4] [2,5]  [2,6] [2,7] [2,8]
//         //
//         // [3,0] [3,1] [3,2]  ...
//         // [4,0] [4,1] [4,2]  ...
//         // [5,0] [5,1] [5,2]  ...
//         //
//         // ...
//         int boxRow = 0;
//         int boxCol = 0;
        
//         // Use % for horizontal traversal.
//         // Because % increments by 1 for each j : 0%3 = 0 , 1%3 = 1, 2%3 = 2.
//         // Use / for vertical traversal.
//         // Because / increments by 1 after every 3 j: 0/3 = 0; 1/3 = 0; 2/3 =0; 3/3 = 1.
        
//         for(int row = 0; row < height; row++) {
//             uniqueValues.clear();
//             for(int col = 0; col < length; col++) {
//                 boxRow = 3 * (row / 3);
//                 boxCol = 3 * (row % 3);
//                 if(board[boxRow + col / 3][boxCol + col % 3] != '.') {
//                     if(uniqueValues.contains(board[boxRow + col / 3][boxCol + col % 3]))
//                         return false;
//                     else
//                         uniqueValues.add(board[boxRow + col / 3][boxCol + col % 3]);
//                 }
//             }
//         }
        
//         // no invalid inputs were found
//         return true;
        
        // // Idea 2: (same as Idea 1, but) go through matrix only ones, filling up 3 HS
        // // (1 for rows, 1 for columns, 1 for 3x3-squares)
        // // Time: O(n), Space: O(n) -> time 1*n, space 3*n

        // HashSet<Character> rows = new HashSet<Character>();
        // HashSet<Character> columns = new HashSet<Character>();
        // HashSet<Character> cube = new HashSet<Character>();
        
        // for(int i = 0; i < 9; i++) {
        //     // clear HSs
        //     rows.clear();
        //     columns.clear();
        //     cube.clear();
            
        //     for (int j = 0; j < 9; j++) {
        //         if(board[i][j] != '.' && !rows.add(board[i][j]))    // [i,j] <=> [row, col]
        //             return false;
        //         if(board[j][i] != '.' && !columns.add(board[j][i])) // [j,i] <=> [col, row]
        //             return false;
        //         // Use % for horizontal traversal.
        //         // Because % increments by 1 for each j : 0%3 = 0 , 1%3 = 1, 2%3 = 2.
        //         // Use / for vertical traversal.
        //         // Because / increments by 1 after every 3 j: 0/3 = 0; 1/3 = 0; 2/3 =0; 3/3 = 1.
        //         int RowIndex = 3 * (i / 3);
        //         int ColIndex = 3 * (i % 3);
        //         if(board[RowIndex + j/3][ColIndex + j%3] != '.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
        //             return false;
        //     }
        // }
        
        // return true;

        // Idea 3: (HashSet with values coded in Strings) collect the set of things we see, encoded as strings. For example:
        // '4' in row 7 is encoded as "(4)7".
        // '4' in column 7 is encoded as "7(4)".
        // '4' in the top-right block is encoded as "0(4)2".
        // return false if we ever fail to add something because it was already added (i.e., seen before).

        Set seen = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                if (number != '.') {
                    if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in column " + j) ||
                        !seen.add(number + " in block " + i/3 + "-" + j/3))
                    return false;
                }
            }
        }
        return true;
    }
}