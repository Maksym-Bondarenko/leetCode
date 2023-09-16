class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // Idea: add letter-by-letter as prefix of s
        // and check if the rest can be made out of it

        for(int i = 1; i <= s.length() / 2; i++) {
            String prefix = s.substring(0, i);
            if(this.canBeMadeWithPrefix(s, prefix))
                return true;
        }

        // not found
        return false;
    }

    // returns true if the word can be made out of prefix (repeatedly constructed) 
    private boolean canBeMadeWithPrefix(String word, String prefix) {
        if(prefix.length() > word.length() / 2)
            return false;
        
        // check if word can be build prefix-by-prefix
        int occurrances = word.length() / prefix.length();
        String repeatedWord = "";
        for(int i = 0; i < occurrances; i++)
            repeatedWord += prefix;
        return repeatedWord.equals(word);
    }
}