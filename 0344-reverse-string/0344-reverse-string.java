class Solution {
    public void reverseString(char[] s) {
        // // Idea 1: Iterativ (two-pointers) go from both sides of array and swap elements on each step
        
        // int length = s.length;
        // int start = 0;
        // int end = length - 1;
        
        // while(start < end)
        //     swap(s, start++, end--);

        // Idea 2: Recursiv. Call function to swap first and last chars. Proceed recursively with the rest of array

        reverseRecursively(s, 0, s.length - 1);
    }

    // help-function for recursive call
    void reverseRecursively(char[] s, int start, int end) {
        // exit-case
        if(start >= end)
            return;

        // swap elements
        char tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;

        // recursive call
        reverseRecursively(s, start + 1, end - 1);
    }
    
    // // help-function that swaps input of array 's' on places 'start' and 'end'
    // private void swap(char[] s, int start, int end) {
    //     char tmp = s[start];
    //     s[start] = s[end];
    //     s[end] = tmp;
    // }
}