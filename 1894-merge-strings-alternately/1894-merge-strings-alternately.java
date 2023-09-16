class Solution {
    public String mergeAlternately(String word1, String word2) {
        // arrays
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        char[] merged = new char[w1.length + w2.length];

        // pointers
        int p1 = 0;
        int p2 = 0;
        int m = 0;

        // while both words are not ended
        while(p1 < w1.length && p2 < w2.length) {
            merged[m] = w1[p1++];
            m++;
            merged[m] = w2[p2++];
            m++;
        }

        // if one of words ended
        if(p1 == w1.length) {
            // fill rest with word2
            while(m < merged.length)
                merged[m++] = w2[p2++];
        } else {
            // fill rest with word1
            while(m < merged.length)
                merged[m++] = w1[p1++];
        }

        return new String(merged);
    }
}