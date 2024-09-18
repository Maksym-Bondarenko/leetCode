class Solution {
    public int largestAltitude(int[] gain) {
        // Idea: {Time: O(N)} create a new array (n+1 sized) of altitudes by iteratively adding to previous value corresponding value from 'gain'-array. Then, find the maximum in the new array.

        int[] altitudes = new int[gain.length + 1];
        altitudes[0] = 0;   // by default (start from 0)
        int highestAltitude = 0;    // could be 0, because it is a start-value

        for(int i = 1; i < altitudes.length; i++) {
            altitudes[i] = altitudes[i-1] + gain[i-1];
            highestAltitude = Math.max(highestAltitude, altitudes[i]);
        }

        return highestAltitude;
    }
}