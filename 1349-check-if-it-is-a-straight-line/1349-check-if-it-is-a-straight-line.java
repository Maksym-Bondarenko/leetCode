class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // Idea: 'create' a line from the first 2 points. If all other points are on this line -> is straight line
        // point is not on the same line if
        // difference in x-coordinates multiplicated by difference in y-coordinates is not same for any 2 out of 3 points !!!

        // edge-case
        if(coordinates.length <= 2)
            return true;

        int length = coordinates.length;
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        
        for(int i = 2; i < length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];

            // ! check if third point ([x,y]) is not on the same line as first two ([x1,y1] and [x2,y2]) !
            // alternative: ((y2 - y1) * (x - x2)) != ((x2 - x1) * (y - y2))
            if(((y2 - y1) * (x - x1)) != ((x2 - x1) * (y - y1)))
                return false;
        }

        return true;
    }
}