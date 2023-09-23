class Solution {
    public void moveZeroes(int[] nums) {
        // Idea: (in-place two-pointers technique) use 2 pointers: 1 running through array and 1 for index of non-0 elements (place where put this element)
        // Time: O(n), Space: O(1)
        // Runtime: 1ms (100%), Memory: 44.9mb (83.6%)

        // edge-cases
        if (nums == null || nums.length <= 1)
            return;
        
        // phase 1: set all non-0 elements at the beginning of array
        int nonZeroIndex = 0;   // where to place a number != 0
        for(int cur = 0; cur < nums.length; cur++) {
            if(nums[cur] != 0)
                nums[nonZeroIndex++] = nums[cur];
        }
        
        // phase 2: fill the rest of array with 0
        // (now 'nonZeroIndex' is pointing to the place in array, from which should stay only 0s)
        while(nonZeroIndex < nums.length)
            nums[nonZeroIndex++] = 0;
    }
}