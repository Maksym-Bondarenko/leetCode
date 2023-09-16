class Solution {
    public boolean judgeCircle(String moves) {
        // Idea: count(U) = count(D) && count(L) == count(R)

        int horizontal = 0;
        int vertical = 0;

        // fill hash-map with values (only vertical / horizontal)
        for(char ch : moves.toCharArray()) {
            switch(ch) {
                case 'U':
                    // increase vertical
                    vertical++;
                    break;
                case 'D':
                    // decrease vertical
                    vertical--;
                    break;
                case 'L':
                    // decrease horizontal
                    horizontal--;
                    break;
                case 'R':
                    // increase horizontal
                    horizontal++;
                    break;
            }
        }

        return horizontal == 0 && vertical == 0;
    }
}