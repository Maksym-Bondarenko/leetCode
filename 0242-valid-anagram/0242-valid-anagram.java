class Solution {
    public boolean isAnagram(String s, String t) {
        // Idea 1: (sorting) sort both of strings alphabetically.
        // Iterate through strings and check if all letters are mathcing (equal)
        // Time: O(nlogn), Space: O(1)
        
        // // Idea 2: (Hash-Map) use HM <key, value> = <character, #_of_occurrences_in_word> (frequency)
        // // fill HM with letters from s. Iterate through t, decrementing values of HM.
        // // if no such key in HM OR value = 0 -> return false
        
        // // corner-cases
        // if(s.length() != t.length())
        //     return false;
        
        // Map<Character, Integer> letterCount = new HashMap<>();
        
        // // fill-up the HM with letterCount of s
        // for(char letter : s.toCharArray())
        //     letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
        
        // // check for same letterCount of t
        // for(char letter : t.toCharArray()) {
        //     Integer numOfOcurrences = letterCount.get(letter);
            
        //     if(numOfOcurrences == null || numOfOcurrences <= 0)
        //         return false;
        //     else
        //         letterCount.put(letter, numOfOcurrences - 1);
        // }
        
        // return true;

        // Idea 3: (array instead of HM) as Idea 2, use array instead of HM (because we have only lowercase English letters)

        // corner-cases
        if(s.length() != t.length())
            return false;

        int[] letterCount = new int[26];

        // increment frequences of all letters
        for(char letter : s.toCharArray())
            letterCount[letter - 'a']++;

        // check frequences
        for(char letter : t.toCharArray()) {
            if(letterCount[letter - 'a'] <= 0)
                return false;
            else
                letterCount[letter - 'a']--;
        }

        return true;
    }
}