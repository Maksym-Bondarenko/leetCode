class Solution {
    public boolean isRobotBounded(String instructions) {
        // Idea: simulate the movements of a robot max 4-times
        // (if still not returned to (0,0) at the last move -> false)

        // variables for the simulation
        int x = 0;
        int y = 0;
        // 0 -> north
        // 1 -> east
        // 2 -> south
        // 3 -> east
        int direction = 0;
        // mod 4
        // 'R' -> +1
        // 'L' -> -1

        // fo through all instructions 4-times (maximum)
        for(int i = 0; i < 4; i++) {
            for(char move : instructions.toCharArray()) {
                // simulate the movements
                switch(move) {
                    case 'G':
                        // change x-y according to the current facing
                        switch(direction) {
                            case 0:
                                // go north
                                y++;
                                break;
                            case 1:
                                // go east
                                x++;
                                break;
                            case 2:
                                // go south
                                y--;
                                break;
                            case 3:
                                // go west
                                x--;
                                break;
                        }
                        break;
                    case 'L':
                        // change facing 90 degrees to the left
                        direction = (direction + 3) % 4;
                        break;
                    case 'R':
                        // change facing 90 degrees to the right
                        direction = (direction + 1) % 4;
                        break;
                    default:
                        break;
                }
            }
            // check if returned back (made a circle)
            // if not -> do loop max 4-times
            if(x == 0 && y == 0)
                return true;
        }

        // if still did not returned to the (0,0) -> not a circle
        return false;
    }
}