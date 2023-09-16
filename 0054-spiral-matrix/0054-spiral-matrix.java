class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();
        int xSize = matrix.length;
        int ySize = matrix[0].length;
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int columnBegin = 0;
        int columnEnd = matrix[0].length - 1;
        
        while(result.size() < xSize * ySize) {
            // go right
            for(int i = columnBegin; i <= columnEnd && result.size() < xSize * ySize; i++)
                result.add(matrix[rowBegin][i]);
            rowBegin++;     // increment, so this row will NOT be visited again
            
            // go down
            for(int i = rowBegin; i <= rowEnd && result.size() < xSize * ySize; i++)
                result.add(matrix[i][columnEnd]);
            columnEnd--;    // decrement, so this column will NOT be visited again
            
            // go left
            for(int i = columnEnd; i >= columnBegin && result.size() < xSize * ySize; i--)
                result.add(matrix[rowEnd][i]);
            rowEnd--;       // decrement, so this row will NOT be visited again
            
            // go up
            for(int i = rowEnd; i >= rowBegin && result.size() < xSize * ySize; i--)
                result.add(matrix[i][columnBegin]);
            columnBegin++;  // increment, so this column will NOT be visited again
        }
        
        return result;
    }

    public List<Integer> spiralOrder_alt(int[][] matrix) {
        // go right: increment j
        // go down: increment i
        // go left: decrement j
        // go up: decrement i
        // to not cover already processed element: run it till (size-1)
        // stop-criteria: list is size of a matrix

        int width = matrix[0].length;   // x
        int height = matrix.length;     // y
        int size = height * width;      // matrix-size
        int border = 0;
        // coordinates (start: 0,0)
        int i = 0;
        int j = 0;
        List<Integer> spiralOrderList = new ArrayList<>();

        while(spiralOrderList.size() < size) {
            // go right
            while(j < width - border)
                spiralOrderList.add(matrix[i][j++]);
            if(spiralOrderList.size() == size)
                break;
            i++;    // step down (to not includer corner-elements twice)
            j--;    // step left (to not go outside of matrix)

            // go down
            while(i < height - border)
                spiralOrderList.add(matrix[i++][j]);
            if(spiralOrderList.size() == size)
                break;
            i--;    // step up (to not go outside of matrix)
            j--;    // step left (to not includer corner-elements twice)

            // go left
            while(j >= 0 + border)
                spiralOrderList.add(matrix[i][j--]);
            if(spiralOrderList.size() == size)
                break;
            i--;
            j++;

            // increment border (after each 3d round)
            border++;

            // go up
            while(i >= 0 + border)
                spiralOrderList.add(matrix[i--][j]);
            if(spiralOrderList.size() == size)
                break;
            i++;
            j++;
        }

        return spiralOrderList;
    }
}