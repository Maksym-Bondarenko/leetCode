class Solution {
    public int maxArea(int[] height) {
        // Idea: two-pointers approach, sliding window | Time: O(), Space: O()
        // <to calculate water-volume we need a product between 2 pointers (i*j) and smaller of their values (height[i], height[j])>
        // move first pointer -> if its height is less than second one
        // move second pointer <- if its height is less than first one

        int currentArea = 0;
        int maxArea = 0;

        for(int left = 0, right = height.length - 1; left < right; ) {
            // check if current container contains more water than saved maximum
            currentArea = (right - left) * (Math.min(height[left], height[right]));
            maxArea = Math.max(currentArea, maxArea);

            // move pointers
            if(height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}