class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Idea 1: (brute-force)
        // use loop to find in array needed element. Use another loop to find the end of target (next bigger number)
        // Time: O(n), Space: O(1)

        // Idea 2: (2-pointers)
        // increasing pointer from begginning and decreasing pointer from the end till target is found.
        // Time: O(n), Space: O(1)

        // edge-cases
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};

        int low = 0;
        int high = nums.length - 1;
        // find first occurance of target
        while(low < nums.length && target != nums[low])
            low++;
        // if it is no target
        if(low == nums.length)
            return new int[]{-1, -1};

        // find last occurance of target
        while(high >= 0 && target != nums[high])
            high--;
        // if it is no target
        if(high == -1)
            return new int[]{-1, -1};

        return new int[]{low, high};

        // Idea 3: (binary search)
        // Use binary search to find the first occurance of target in array.
        // Use BS again to find last ocurance of this number (index of bigger number minus 1) 
        // Time: O(logn), Space: O(1)
    }
}