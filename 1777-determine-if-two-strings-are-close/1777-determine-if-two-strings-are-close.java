class Solution {
    public boolean closeStrings(String word1, String word2) {
        // Idea: {Time: O(N * log N)} HashMap
        // (swapping letters = soring string by chars)
        // Use HM for tracking occurrences of each letter

        // illiminate words of not same size
        if(word1.length() != word2.length())
            return false;

        // fill two HMs with letter-occurrences from both words
        // sum of values in each HM must be the same ( <=> letter-count)
        // for each value in first HM must be corresponding value in the second HM

        Map<Character, Integer> occurrences1 = new HashMap<>();
        Map<Character, Integer> occurrences2 = new HashMap<>();

        for(int i = 0; i < word1.length(); i++) {
            // for word1
            occurrences1.put(
                word1.charAt(i),
                occurrences1.getOrDefault(word1.charAt(i), 0) + 1
            );

            // for word2
            occurrences2.put(
                word2.charAt(i),
                occurrences2.getOrDefault(word2.charAt(i), 0) + 1
            );
        }

        // check the HMs sizes (<=> amount of different letters, must be the same)
        if(occurrences1.size() != occurrences2.size())
            return false;

        // to check occurrences (values of HM <=> all letters-ammount from HMs must be the same)
        List<Integer> occurrList1 = new ArrayList(word1.length());
        List<Integer> occurrList2 = new ArrayList(word1.length());

        // to check letters (keys of HM <=> letters must exist in both words)
        Set<Character> lettersSet1 = new HashSet();
        Set<Character> lettersSet2 = new HashSet();

        for(Map.Entry<Character, Integer> entry : occurrences1.entrySet()) {
            lettersSet1.add(entry.getKey());
            occurrList1.add(entry.getValue());
        }
        for(Map.Entry<Character, Integer> entry : occurrences2.entrySet()) {
            lettersSet2.add(entry.getKey());
            occurrList2.add(entry.getValue());
        }

        Collections.sort(occurrList1);
        Collections.sort(occurrList2);
        
        // both, lists and sets must be same
        return (lettersSet1.equals(lettersSet2) && occurrList1.equals(occurrList2));
    }
}