class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Idea: {Time: O(N)}
        // use HM to keep track of numbers and their occurrences (key = number, value = #_of_occurrences);
        // iterate through HM-values and check for duplicates

        Map<Integer, Integer> occurrences = new HashMap<>();

        // fill out HM with numbers and their occurrences
        for(int number : arr) {
            occurrences.put(
                number,                                 // key
                occurrences.getOrDefault(number, 0) + 1 // value
            );
        }

        // check HM-values set for duplicates using HS
        Set<Integer> uniqueOccurrences = new HashSet<>();

        for(int num : occurrences.values()) {
            if(!uniqueOccurrences.add(num))
                return false;
        }

        return true;
    }
}