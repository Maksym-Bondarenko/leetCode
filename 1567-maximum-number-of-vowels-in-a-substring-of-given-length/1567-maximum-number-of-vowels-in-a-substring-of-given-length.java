class Solution {
    public int maxVowels(String s, int k) {
        // Idea: {Time: O(N)} use sliding window to iterate through the array
        // check for vowels e.g. using HS
        // no corner-cases, according to the task

        int currentVowels = 0;
        int maxVowels = 0;

        // calculate for the first window of size k
        for(int i = 0; i < k; i++) {
            if(isVowel(s.charAt(i)))
                currentVowels++;
        }

        maxVowels = currentVowels;

        // iterate through the String with window-size = k
        for(int left = 0, right = k; right < s.length(); left++, right++) {
            // move window one step to the left and update vowels-count
            if(isVowel(s.charAt(left)))
                currentVowels--;
            if(isVowel(s.charAt(right)))
                currentVowels++;

            // update max-counter, if needed
            maxVowels = Math.max(maxVowels, currentVowels);
        }

        return maxVowels;
    }

    // help-functions retern wether given letter is a vowel
    private boolean isVowel(char letter) {
        return
            letter == 'a' ||
            letter == 'e' ||
            letter == 'i' ||
            letter == 'o' ||
            letter == 'u';
    }
}