class Solution {
    public boolean validPalindrome(String s) {
        // Idea: (two-pointers + help-function)
        // use two-pointers approach as for standard problem (moving to the middle from different directions)
        // if letters are non-equivalent -> check if the rest (2 possibilities: without left OR without right char) is a palindrome
        // NOTICE! "caba" -> by removing 'c' (0-index), will be a valid palindrome
        //         "caba" -> by removing 'a' (3-index), will NOT be a valid palindrome

        int start = 0;
        int end = s.length() - 1;

        while(start < end) {
            // check for at most 1 deletion
            if(s.charAt(start) != s.charAt(end))
                return (isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1));  // check both possibilities (if remove left or right character)
            // move pointers
            start++;
            end--;
        }
        // if it was 0 deletions
        return true;
    }

    // help-function, returns if the given range of string is a palindrome
    private boolean isPalindrome(String s, int start, int end) {
        while(start < end)
            if(s.charAt(start++) != s.charAt(end--)) return false;
        return true;
    }
}