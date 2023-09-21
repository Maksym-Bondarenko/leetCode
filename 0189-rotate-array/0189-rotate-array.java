class Solution {
    public void rotate(int[] nums, int k) {
        // // Idea 1: use additional array where values be putted on (i+k) places
        // // Time: O(N), Space: O(N)
        // // // Runtime: 1ms (51.11%); Memory: 55.02mb (86.51%)
        
        // int length = nums.length;
        
        // // decrease k with modulo (maximum rotation = arraySize-1)
        // k = k % length;
        
        // // edge-cases
        // if(k == 0 || length <= 1)
        //     return;
        
        // int[] rotatedNums = new int[length];
        
        // for(int i = 0; i < length; i++)
        //     rotatedNums[(i + k) % length] = nums[i];
        
        // System.arraycopy(rotatedNums, 0, nums, 0, length);

        // // Idea 1.1: (similar to Idea1, just do it in two phases)
        // // Time: O(N), Space: O(N)
        // // Runtime: 1ms (51.11%); Memory: 55.44mb (71.03%)
        

        // int length = nums.length;
        
        // // decrease k with modulo (maximum rotation = arraySize-1)
        // k = k % length;
        
        // // edge-cases
        // if(k == 0 || length <= 1)
        //     return;
        
        // int[] rotatedNums = new int[length];
        // int rotatedPtr = 0;

        // // fill-up the second part of rotated array (from k till end)
        // for(int i = k; i < length; i++)
        //     rotatedNums[i] = nums[rotatedPtr++];

        // // fill-up the first part of rotated array (from begin till k-1)
        // for(int i = 0; i < k; i++)
        //     rotatedNums[i] = nums[rotatedPtr++];

        // System.arraycopy(rotatedNums, 0, nums, 0, length);

        // // Idea 2: (in-place) set one value to its new correct (rotated) place at each step.
        // // Then set the value of rotated index to the new spot. Do it untill reached 0-index.
        // // Start from one element and keep rotating until we have rotated n different elements.
        // // Time: O(N), Space: O(1)
        // // Time: 2ms (23.43%), Memory: 55.43mb (71.03%)
        // int length = nums.length;
        
        // // decrease k with modulo (maximum rotation = arraySize-1)
        // k %= length;
        
        // // edge-cases
        // if(k == 0 || length <= 1)
        //     return;
        
        // int cntRotated = 0;
        // int start = 0;
        // int rotatedPtr = 0;     // pointer in array where to put new (rotated) value
        // int buffer = nums[0];   // for saving the value of previously changed element
        // int tmp = 0;            // for updating the buffer
        // int current = 0;        // for iteration across the array with step of k
        // // [5,6,7,1,2,3,4], k=3, buf=5
        // // [0,1,2,3,4,5,6]

        // // start with current == 0 and end with current == 0 => do_while-loop
        // // OR for-loop with amount-of-iterations = length of array

        // while(cntRotated < length) {
        //     do {
        //         rotatedPtr = (current + k) % length;    // index of array where current-element should be placed
        //         tmp = nums[rotatedPtr];                 // save old value
        //         nums[rotatedPtr] = buffer;              // set current value to the right place
        //         buffer = tmp;
        //         current = rotatedPtr;
        //         cntRotated++;
        //         // values:   [1,2,3,1,5,6,7], tmp=4, buf=4, cur=3 (1)
        //         // values:   [1,2,3,1,5,6,4], tmp=7, buf=7, cur=6 (2)
        //         // values:   [1,2,7,1,5,6,4], tmp=3, buf=3, cur=2 (3)
        //         // values:   [1,2,7,1,5,3,4], tmp=6, buf=6, cur=1 (4)
        //         // values:   [1,6,7,1,5,3,4], tmp=2, buf=2, cur=4 (5)
        //         // values:   [1,6,7,1,2,3,4], tmp=5, buf=5, cur=0 (6)
        //         // values:   [5,6,7,1,2,3,4], tmp=1, buf=1, cur=3 (7)
        //         // indicies: [0,1,2,3,4,5,6]
        //     } while(current != start);

        //         // Stop rotating the elements when we finish one cycle, 
        //         // i.e., we return to start.
        //         // Move to next element to start a new cycle.
        //         start++;
        //         current = start;
        //         buffer = nums[current];
        // }

        // Idea 3: with reversing sub-arrays and then whole array
        // // Time: O(N), Space: O(1)
        // // Time: 0ms (100%), Memory: 55.29mb (80.78%)

        int length = nums.length;
        k %= nums.length;

        if(k < 0)
            k += nums.length;

        reverse(nums, 0, length - 1);   // full array
        reverse(nums, 0, k - 1);        // first part
        reverse(nums, k, length - 1);   // second part
        // alternative:
        // reverse(nums, 0, length - k - 1);
        // reverse(nums, length - k, length - 1);
        // reverse(nums, 0, length - 1);
    }

    // help-function reverse given array (only from start till end part)
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}