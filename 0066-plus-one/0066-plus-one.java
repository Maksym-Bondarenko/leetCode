class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // add 1 to left digit
            digits[i] = 0;
        }
        // if reached here, all digits are 0 (every step - 'overflow')
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;

        // Alternative:
        // int overflow = 1;

        // for(int i = digits.length - 1; i >= 0; i--) {
        //     // if(digits[i] == 9) {
        //     //     overflow = true;
        //     //     digits[i] = 0;
        //     // } else {
        //     //     digits[i]++;
        //     //     overflow = false;
        //     //     break;
        //     // }
        //     // OR alternative:
        //     int value = digits[i] + overflow;
        //     overflow = value / 10;
        //     digits[i] = value % 10;
        // }

        // // if all digits were '9' -> array with +1 element
        // if(overflow > 0) {
        //     int[] newDigits = new int[digits.length + 1];
        //     newDigits[0] = 1;
        //     return newDigits;
        // } else
        //     return digits;
    }
}