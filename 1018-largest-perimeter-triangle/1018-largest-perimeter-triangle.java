class Solution {
    public int largestPerimeter(int[] nums) {
        // triangle rule: sum of any 2 sides > third side (for all sides)

//        // Idea: try all possible sets of 3 elements
//        // Time: O(n^3)

//        int size = nums.length;
//        int maxPerimeter = 0;

//        for(int a = 0; a < size - 2; a++) {
//            for(int b = a + 1; b < size - 1; b++) {
//                for(int c = b + 1; c < size; c++) {
//                    if(isValidTriangle(nums[a], nums[b], nums[c]))
//                        maxPerimeter = Math.max(maxPerimeter, nums[a] + nums[b] + nums[c]);
//                }
//            }
//        }

//        return maxPerimeter;

        // Idea: sort array. Start from the end (largest potential perimeter), if valid triangle -> ok, not valid -> step left
        // Time: O(nlogn)
        
        Arrays.sort(nums);

        for(int i = nums.length - 1; i >= 2; i--) {
            // do not need to check full triangle-rule, just check 1 unequality
            if(nums[i] < nums[i-1] + nums[i-2])
                return nums[i] + nums[i-1] + nums[i-2];
        }

        return 0;
    }

    private boolean isValidTriangle(int a, int b, int c) {
        return 
            a + b > c &&
            a + c > b &&
            b + c > a;
    }
}