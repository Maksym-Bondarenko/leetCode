class Solution {
    public int jump(int[] nums) {
        // Idea: create an array of "cheapest jumps", representing minimal cost to get to each index

        int[] jumpSteps = new int[nums.length];
        Arrays.fill(jumpSteps, Integer.MAX_VALUE);
        jumpSteps[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            // fill 'jumpSteps' for indices, where we can jump from current cell
            // if previously not reached: either with previously determined jumps or with + 1 jump from current cell
            for (int j = 0; j < nums[i]; j++) {
                int reachableCell = i + j + 1;
                if(reachableCell < jumpSteps.length)
                    jumpSteps[reachableCell] = Math.min(jumpSteps[reachableCell], jumpSteps[i] + 1);
            }
        }

        // return (cheapest) price for the last element
        return jumpSteps[nums.length - 1];
    }
}