class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Idea: sliding window {Time: O(N)}
        // no corner cases, according to task

        // create a window of first k elements and pre-calculate its sum
        double currentSum = 0, maxSum = 0;

        for(int i = 0; i < k; i++)
            currentSum += nums[i];

        maxSum = currentSum;

        for(int i = k; i < nums.length; i++) {
            // to calculate new sum: add next right number and substract last left
            currentSum += nums[i] - nums[i - k];

            // update max if needed
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum / k;
    }
}