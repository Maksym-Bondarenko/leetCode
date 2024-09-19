class Solution {
    public int longestOnes(int[] nums, int k) {
        // Idea: {Time: O(N)} sliding-window approach
        // move window of potentially maximum number of consecutive ones
        // if there is a '0' and k is still 'available' -> flip it
        // if no k is 'available' => move window

        int flips = k;              // how many flips are left
        int maxConsecutiveOnes = 0; // result
        int left = 0;               // start index of window
        int right = 0;              // end index of window

        while(right < nums.length) {
            // if no flips are left and there is 0 at right window corner
            // => move left window-corner until next 0
            while(right < nums.length && k < 1 && nums[right] == 0) {
                if(nums[left] == 0)
                    k++;
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, right - left);
                left++;
            }

            // if right windiow-corner is on the 0 and some flips are left
            // => flip 0 to 1
            if(right < nums.length && k > 0 && nums[right] == 0)
                k--;
            right++;
        }

        return Math.max(maxConsecutiveOnes, right - left);
    }
}