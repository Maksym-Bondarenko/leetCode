class Solution {
    public int diagonalSum(int[][] mat) {
        // odd size: substract a central element
        // (so it will not be counted twice from both diagonals)
        // even size: simple add all elements from both diagonals

        int sum = 0;
        int size = mat.length;

        // add elements from the main diagonal
        for(int i = 0, j = 0; i < size; i++, j++)
            sum += mat[i][j];
        // add elements from the secondary diagonal
        for(int i = 0, j = size - 1; i < size; i++, j--)
            sum += mat[i][j];

        // substract central element if matrix is odd-sized
        return size % 2 == 0 ? sum : sum - mat[size/2][size/2];
    }
}