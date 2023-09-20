class Solution {
    public int removeDuplicates(int[] nums) {
        // Idea: two-pointers approach with one array-walkthrough.
        // One pointer is pointing to the place for unique element.
        // Second pointer is running through the array.
        // If numbers are non-equal -> move this number to the next position of uniquePointer.
        // (As array is sorted, duplicates can appear only nearby).
        
        int uniquePointer = 0;
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[uniquePointer] != nums[i])
                nums[++uniquePointer] = nums[i];
        }
        
        return uniquePointer + 1;
    }
}