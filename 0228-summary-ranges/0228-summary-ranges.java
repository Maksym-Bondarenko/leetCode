class Solution {
    public List<String> summaryRanges(int[] nums) {
        // Idea: sliding window (start-end of range)
        // with checking if next element is in same range (increment) or not
        // Time: O(n), Space: O(n)

        int start = 0;
        int end = 0;
        List<String> ranges = new ArrayList<>();

        while(start < nums.length) {
            // start with window: start = end
            // increase end of window for incrementing numbers
            while(end + 1 < nums.length && nums[end] + 1 == nums[end + 1])
                end++;
            // add current range (or single element) to the list
            ranges.add(
                start == end ?
                    "" + nums[start] :
                    "" + nums[start] + "->" + nums[end]
            );
            // move window-indices
            start = ++end;
        }

        return ranges;
    }
}