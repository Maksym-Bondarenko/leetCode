class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Idea: fix one number and do 2SUM-problem of the rest of array with inverse target
        // Sort array for faster 2SUM-problem (e.g. using 2-pointers approach)

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int freezed = 0; freezed < nums.length - 1; freezed++) {
            // to skip duplicates for 'freezed' value
            if (freezed > 0 && nums[freezed] == nums[freezed - 1])
                continue;
            
            int start = freezed + 1;
            int end = nums.length - 1;

            while (start < end) {
                int total = nums[freezed] + nums[start] + nums[end];

                if (total > 0)
                    end--;
                else if (total < 0)
                    start++;
                else {
                    res.add(Arrays.asList(nums[freezed], nums[start], nums[end]));
                    start++;

                    // to skip all duplicates for 'start' value
                    while (nums[start] == nums[start - 1] && start < end)
                        start++;
                }
            }
        }

        return res; 
    }
}