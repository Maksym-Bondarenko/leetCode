class Solution {
    public void moveZeroes(int[] nums) {
/*
        // Idea: buuble-sort alike, in-place

        // edge-cases
        if(nums == null || nums.length <= 1)
            return;

        for(int leftInd = 0, rightInd = 1;
            rightInd <= nums.length - 1; ) {

            if(nums[leftInd] == 0 && nums[rightInd] != 0) {
                // swap places
                swap(nums, leftInd, rightInd);
                // move all pointers
                leftInd++;
                rightInd++;
            } else if(nums[leftInd] == 0 && nums[rightInd] == 0) {
                // move right index only
                rightInd++;
            } else {
                // (nums[leftInd] != 0)
                // move all pointers
                leftInd++;
                rightInd++;
            }
        }
*/

        // alternative
        // faster, overwritting, non-swapping
        if(nums == null || nums.length == 0)
            return;
        
        int nonZeroPointer = 0;
        
        for(int num : nums) {
            if(num != 0)
                nums[nonZeroPointer++] = num;
        }
        
        for(int zeros = nonZeroPointer; zeros < nums.length; zeros++) {
            nums[zeros] = 0;
        }
    }

/*
    // swap places the numbers of given indices in array in-place
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
*/
}