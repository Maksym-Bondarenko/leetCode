class Solution {
    public boolean isAnagram(String s, String t) {
        /*
        // with HashMap

        // error-case
        if(s.length() != t.length())
            return false;

        // fill-up HashMap with count-letters from s
        HashMap<Character, Integer> lettersCount = new HashMap<>();
        for(char ch : s.toCharArray()) {
            Integer amount = lettersCount.get(ch);
            lettersCount.put(ch, amount != null ? amount + 1 : 1);
        }

        // go through t, eliminating countLertters from HM
        for(char ch : t.toCharArray()) {
            Integer currentLetterCount = lettersCount.get(ch);
            if(currentLetterCount == null || currentLetterCount == 0) {
                // if no such letter from t in HM (or if count < 0) -> return false
                return false;
            } else {
                // decrese counter in HM
                lettersCount.put(ch, currentLetterCount - 1);
            }
        }

        return true;
        */

        // with array
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}