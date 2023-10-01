class Solution {
    public boolean isPalindrome(String s) {
        // Idea: (2-pointers approach)
        // one pointer from beginning moving torwards, another from end moving backwards.
        // skip numbers, spaces, reformat letters to lowcase
        // Time: O(n), Space: O(1)
        // Runtime: 3ms (73.63%), Memory: 41.4mb (99.1%)
        
        int start = 0;
        int end = s.length() - 1;
        
        while(start < end) {
            // skip non-alphabeticall characters from both sides
            while(!Character.isLetterOrDigit(s.charAt(start)) && start < end)
                start++;
            while(!Character.isLetterOrDigit(s.charAt(end)) && start < end)
                end--;
            
            // check alphabetical characters (case independent)
            if(start > end || Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
                return false;
            
            start++;
            end--;
        }
        
        return true;
    }
}