class Solution {
    public int hIndex(int[] citations) {
        // Idea: kinda bucket-sort
        
        int n = citations.length;
        int[] citationBuckets = new int[1001];

        // increment each 'bucket' of citation-value
        // if some paper has more citations than size of array -> increment n-value
        // (H-index cannot be larger than n)
        for (int i = 0; i < n; i++) {
            if (citations[i] > n)
                citationBuckets[n]++;
            else
                citationBuckets[citations[i]]++;
        }

        // find largest index of citationBuckets where value >= its index
        // accumulate citations of larger indices and add them to lower!
        int accumulatedCitations = 0;
        for (int i = citationBuckets.length - 1; i >= 0; i--) {
            accumulatedCitations += citationBuckets[i];
            if (accumulatedCitations >= i)
                return i;
        }
        
        return 0;
    }
}