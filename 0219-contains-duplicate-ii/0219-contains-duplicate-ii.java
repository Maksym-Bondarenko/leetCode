class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // // Idea 1: (HashMap): when iterating through the array remember in HM value and its position.
        // // For each number check if this value is in HM and if abs(i-j) <= k.
        // // If value is not in HM -> add it there. If constraint with k does not work -> update value and its position in HM with current one.

        // Map<Integer, Integer> occurrences = new HashMap<>();

        // for(int i = 0; i < nums.length; i++) {
        //     if(occurrences.containsKey(nums[i])) {
        //         // check k constraint
        //         if(i - occurrences.get(nums[i]) <= k)
        //             return true;
        //     }

        //     occurrences.put(nums[i], i);
        // }

        // return false;

        // Idea 2: (Sliding Window + HashSet) use 2 pointers for the beginning and end of acceptable window (abs(i-j)<=k).
        // Add values in HS as iterating acceptable 'window'. If no values are equal -> remove from HS first value and increment both pointer.

        Set<Integer> duplicates = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            // start removing first element of window from HS beginning from k-iteration
            if(i > k)
                duplicates.remove(nums[i - k - 1]);
            if(duplicates.contains(nums[i]))
                return true;
            else
                duplicates.add(nums[i]);
            // OR:
            // if(!set.add(nums[i]))
            //     return true;
        }

        return false;
    }
}