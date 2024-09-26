class Solution {
    public int tribonacci(int n) {
        // Idea: use (recursive or iterative) DP to iterate through all previous values of n

        // // recursively:
        // switch (n) {
        //     case 0: return 0;
        //     case 1: return 1;
        //     case 2: return 1;
        //     default: return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
        // }

        // iteratively:
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;

        for (int i = 3; i <= n; i++) {
            // calculate next var
            int t3 = t0 + t1 + t2;

            // update previous vars ("move" them right)
            t0 = t1;
            t1 = t2;
            t2 = t3;
        }

        return t2;
    }
}