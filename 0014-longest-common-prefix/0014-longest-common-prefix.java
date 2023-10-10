class Solution {
    public String longestCommonPrefix(String[] strs) {
//         // Idea 1: loop through words in array. Check if i-th letter is same for all words. If true - add letter to the prefix. If false - return current prefix.
        
//         String longestPrefix = "";
//         char currentLetter;
//         // find shortest word (longest possible prefix)
//         int lengthOfShortest = Integer.MAX_VALUE;
//         int indexOfShortest = -1;
//         for(int i = 0; i < strs.length; i++) {
//             if(strs[i].length() == 0)
//                 return "";
//             if(strs[i].length() < lengthOfShortest) {
//                 lengthOfShortest = strs[i].length();
//                 indexOfShortest = i;
//             }
//         }
        
//         for(int i = 0; i < lengthOfShortest; i++) {
//             currentLetter = strs[indexOfShortest].charAt(i);
//             for(int j = 0; j < strs.length; j++) {
//                 if(strs[j].charAt(i) != currentLetter)
//                     return longestPrefix;
//             }
//             longestPrefix += currentLetter;
//         }
        
//         return longestPrefix;
        
        // Idea 2: (alternative, one array-walkthrough only, without words-boundaries)
        String prefix = "";
        int charIndex = 0;
        
        // since there are strict boundaries for words in 'strs' and length of each word,
        // we can use this loop (it HAS TO be end-of-word or distinguishing char before overflow)
        while(charIndex < strs[0].length()) {
            // since ALL words must have common prefix
            // -> we can just select first word as starting point
            char currentChar = strs[0].charAt(charIndex);
            
            // check all other words on additional char in common prefix
            for(int i = 1; i < strs.length; i++) {
                // exit if word has ended or chars are non-equal
                if(strs[i].length() <= charIndex || strs[i].charAt(charIndex) != currentChar)
                    return prefix;  // if some word has ended or distinguished char was found
            }
            
            // add common char to the prefix
            prefix += currentChar;
            charIndex++;
        }
        
        return prefix;  // if first word is a whole longestCommonPrefix
    }
}