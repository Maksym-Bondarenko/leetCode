class Solution {
    public int removeDuplicates(int[] nums) {
        // Idea: two-pointers approach with additional flag for second element

        int uniquePointer = 0;
        int duplicatesCounter = 0;

        for(int i = 0; i < nums.length; i++) {
            // set duplicatesCounter to 0 for every new number
            if(nums[i] != nums[uniquePointer])
                duplicatesCounter = 0;

            // allow 2 duplicates via 'duplicatesCounter'
            if(nums[i] != nums[uniquePointer] || duplicatesCounter == 1)
                nums[++uniquePointer] = nums[i];
            
            duplicatesCounter++;
        }

        // [1,1,1,2,2,3]
        // [1,1,2], i=3, uP=1, d=3

        return uniquePointer + 1;
    }

    // // Alternative:
    // public int removeDuplicates(int[] nums) {
    //     int i = 0;
    //     for (int n : nums)
    //         if (i < 2 || n > nums[i-2])
    //             nums[i++] = n;
    //     return i;
    // }
}