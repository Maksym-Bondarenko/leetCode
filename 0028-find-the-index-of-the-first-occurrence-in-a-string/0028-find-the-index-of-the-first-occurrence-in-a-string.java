class Solution {
    public int strStr(String haystack, String needle) {
        // Idea: (two-pointer approach)
        // one pointer for haystack and one for needle
        // iterate the word if chars are equal. If reached end of needle -> return true
        // if did not reach end of needle (letter were unequal)
        // -> start from beginning of needle and next char (of previously checked start)
        //    of haystack (<=> haystack-index minus needle-index)
        
        int hLen = haystack.length();
        int nLen = needle.length();
        int hIndex = 0; // pointer for haystack
        int nIndex = 0; // pointer for needle

        for(hIndex = 0; hIndex < hLen; hIndex++) {
            // as long as the characters are equal, increment needleIndex
            if(haystack.charAt(hIndex) == needle.charAt(nIndex)) {
                nIndex++;
            }
            else{
                // start from the next index of previously started word
                hIndex -= nIndex;
                // needle should start from index 0
                nIndex = 0;
            }
            // check if needleIndex reached needle length
            if(nIndex == nLen){
                // return the first index <=> endOfWord minus lengthOfWord
                // (as 'nIndex' = 'nLen')
                return hIndex - nLen + 1;
            }
        }
        
        return -1;
    }
}