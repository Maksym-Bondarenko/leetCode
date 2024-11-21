class Solution {
    public boolean canJump(int[] nums) {
        // Idea: start from the back: from last element step backwards until reached the first element, given the intermediate steps

        int goalIndex = nums.length - 1;

        for (int i = goalIndex - 1; i >= 0; i--) {
            if (nums[i] + i >= goalIndex)
                goalIndex = i;
        }

        return goalIndex == 0;
    }
}