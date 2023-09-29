class Solution {
    public int reverse(int x) {
        // Idea 1: transform to String and reverse String.
        // Then reverse back to Integer (paying attention to possible owerflow)

        // Idea 2: (use long) perform operations with long, but do a check on overflow of Integer.MAX_VALUE or Integer.MIN_VALUE
        
        // // Idea 4: (Math: %, /) in loop take modulo (for last digit) of number, divide by ten (remove last digit)
        // // multiplicate result by ten (move number to the left), add last digit again (last number)
        
        // int reversedX = 0;
        
        // // the sign of x does not matter, as it is in Integer and will go along the steps in same way => 'x != 0' and not 'x > 0'
        // while(x != 0) {
        //     int digit = x % 10; // take last digit of original number

        //     // create new potential result,
        //     // check if by reverting it (remove last digit) will be equal to original result
        //     int potentialResult = reversedX * 10 + digit;
            
        //     // check for overflow
        //     if((potentialResult - digit) / 10 != reversedX)
        //         return 0;
            
        //     // set potentialResult as true
        //     reversedX = potentialResult;
            
        //     x /= 10;    // remove last digit from original number

        // }
        
        // return reversedX;

        // Idea 4: (as Idea 4, but another overflow-check)
        int ans = 0;
        while(x != 0) {
            if (ans > Integer.MAX_VALUE / 10 || ans < Integer.MIN_VALUE / 10)   // there is less space than one period till overflow -> for any x-digit (0-9) will cause an overflow
                return 0;
            ans = ans * 10 + (x % 10);
            x /= 10;
        }
        return ans;
    }
}