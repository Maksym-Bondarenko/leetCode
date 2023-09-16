class Solution {
    public char findTheDifference(String s, String t) {
        /*
        // Idea:
        // go through original array and save it to HashMap
        // go through new array, eliminating elements from HashMap
        // if some elements is not in HM -> we found it

        HashMap<Character, Integer> countLetters = new HashMap<>();

        // add all elements from s to HashMap (letter, #_of_occurrences)
        for(int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            Integer count = countLetters.get(curChar);
            countLetters.put(curChar, (count != null) ? (count + 1) : 1);
        }

        // go through t and remove #_of_occurrences from HashMap
        for(int i = 0; i < t.length(); i++) {
            // if no such letter (or # is 0) -> we found it
            char curChar = t.charAt(i);
            if(countLetters.get(curChar) != null && countLetters.get(curChar) != 0) {
                // remove occurrance of char from HM
                countLetters.put(curChar, countLetters.get(curChar) - 1);
            } else {
                return curChar;
            }
        }

        // error-case
        return ' ';
        */

        // Optimal solution: (XOR)
        char c = 0;
        for(char cs : s.toCharArray())
            c ^= cs;
        for(char ct : t.toCharArray())
            c ^= ct;
        return c;
    }
}