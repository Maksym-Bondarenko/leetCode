import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public int singleNumber(int[] nums) {
        // Idea 1: (Sort) sort array an check where numbers are coming not as 3 duplicates, but as a single number

        // Idea 2: (HashMap) use HM to store number and amount of it's occurrences. Go through HM and return number with occurrences = 1

        Map<Integer, Integer> occurrences = new HashMap<>();

        // fill-up the HM
        for(int num : nums)
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        
        // return element of HM woth value = 1 (all other have value = 3)
        for(Entry<Integer, Integer> entry: occurrences.entrySet()) {
            if(entry.getValue() == 1)
                return entry.getKey();
        }

        // error (not found) case -> SHOULD NOT REACH
        return -1;

        // Idea 3: ()
    }
}