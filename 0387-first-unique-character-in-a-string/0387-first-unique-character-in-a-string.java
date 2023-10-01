class Solution {
    public int firstUniqChar(String s) {
        // // Idea 1: (Hash-Map) use HM to remember char (=key) and its position (=value),
        // // if second+ char arrives set value to -1.
        // // Iterate through values and pick the smallest one
        // // Runtim: 24ms (54.76%), Memory: 44.2mb (43.11%)
        
        // Map<Character, Integer> positionOfChar = new HashMap<>();
        
        // // fill-up the HM
        // for(int i = 0; i < s.length(); i++) {
        //     char current = s.charAt(i);
        //     // if key is already in HM -> set value to -1
        //     if(positionOfChar.containsKey(current))
        //         positionOfChar.put(current, -1);
        //     else
        //         positionOfChar.put(current, i);
        // }
        
        // // iterate through array (keys) and return (if exists) first value of HM where value != -1
        // for(char current : s.toCharArray()) {
        //     if(positionOfChar.get(current) != -1)
        //         return positionOfChar.get(current);
        // }
        
        // // no unique chars
        // return -1;
        
        // // Idea 2: (alternative HM with occurrences) fill the hashMap with occurrences of all letters
        // // return first element where occurrence = 1
        // // Runtime: 27ms (36.62%), Memory: 43.72mb (92.16%)
        
        // Map<Character, Integer> numberOfChars = new HashMap<>();
        // Integer occurrences = 0;

        // // fill the hashMap with occurrences of all letters
        // for(char i : s.toCharArray())
        //     numberOfChars.put(i, numberOfChars.getOrDefault(i, 0) + 1);
        
        // // return first element with value (occurrences) = 1
        // for(int i = 0; i < s.length(); i++) {
        //     occurrences = numberOfChars.get(s.charAt(i));
        //     if(occurrences == 1)
        //         return i;
        // }
        // return -1;
        
        // Idea 3: (array of fixed length for letters) use an array and not HM (better cache-locality, faster, less space-consumption)
        int[] charCounter = new int[26];

        // each element of array will represent #_of_occurrences of letter under its index
        for(char i : s.toCharArray())
            charCounter[i - 'a']++;
        
        // find first letter with #_of_occurrences = 1
        for(int i = 0; i < s.length(); i++)
            if(charCounter[s.charAt(i) - 'a'] == 1)
                return i;

        return -1;
    }
}