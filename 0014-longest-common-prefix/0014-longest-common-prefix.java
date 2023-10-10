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
        
//         // Idea 2: (alternative, one array-walkthrough only, without words-boundaries)
//         String prefix = "";
//         int charIndex = 0;
        
//         // since there are strict boundaries for words in 'strs' and length of each word,
//         // we can use this loop (it HAS TO be end-of-word or distinguishing char before overflow)
//         while(charIndex < strs[0].length()) {
//             // since ALL words must have common prefix
//             // -> we can just select first word as starting point
//             char currentChar = strs[0].charAt(charIndex);
            
//             // check all other words on additional char in common prefix
//             for(int i = 1; i < strs.length; i++) {
//                 // exit if word has ended or chars are non-equal
//                 if(strs[i].length() <= charIndex || strs[i].charAt(charIndex) != currentChar)
//                     return prefix;  // if some word has ended or distinguished char was found
//             }
            
//             // add common char to the prefix
//             prefix += currentChar;
//             charIndex++;
//         }
        
//         return prefix;  // if first word is a whole longestCommonPrefix
        
        // Idea 3: (sorting lexicographically)
        // 1. Initialize an empty string ans to store the common prefix.
        // 2. Sort the input list v lexicographically. This step is necessary because the common prefix should be common to all the strings, so we need to find the common prefix of the first and last string in the sorted list.
        // 3. Iterate through the characters of the first and last string in the sorted list, stopping at the length of the shorter string.
        // 4. If the current character of the first string is not equal to the current character of the last string, return the common prefix found so far.
        // 5. Otherwise, append the current character to the ans string.
        // 6. Return the ans string containing the longest common prefix.
        
        Arrays.sort(strs);
        String s1 = strs[0];               // first word
        String s2 = strs[strs.length - 1]; // last word
        int idx = 0;
        
        // first and last sorted words are having different lengths
        // all words inbetween have same prefix
        while(idx < s1.length() && idx < s2.length()) {
            if(s1.charAt(idx) == s2.charAt(idx))
                idx++;
            else
                break;  // stop, chars are non-equivalent
        }
        
        // does not matter from which (first or last) string take a substring
        return s1.substring(0, idx);

    }
}