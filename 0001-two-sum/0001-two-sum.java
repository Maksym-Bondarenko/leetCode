class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Idea 1: (brute-force) for every element in array (beginning from the first one) go through the resy of array and check if the sum of two elements is equal to target
        // Time: O(n^2), Space: O(1)
        
        // Idea 2: (Hash-Map in one-pass) go through array and save elements in HM (key = number, value = index_in_array)
        // before adding to HM check if current target - number makes up existing in HM key
        // Time: O(n), Space: O(n)
        
        Map<Integer, Integer> occurrences = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int numberToFind = target - nums[i];    // number that by adding to nums[i] equal to target (complement)
            if(occurrences.containsKey(numberToFind))
                return new int[]{occurrences.get(numberToFind), i};
            else
                occurrences.put(nums[i], i);        // put element and its index into HM
        }
        
        // error-case (not-found): SHOULD NOT REACH HERE DUE TO TASK CONSTRAINTS
        return new int[]{};
    }
}