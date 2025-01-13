class Solution {
    public int longestConsecutive(int[] nums) {
        // // Idea 1: (no sorting, as than time willbe >= O(n log n))
        // // Bucket-sort kinda:
        // // fill array of Booleans (or HashSet) of 'numbers-appearances'
        // // go through array and check for the longest sequence
        // // Time: O(n), Space: O(k)

        // boolean[] numsAppearances = new boolean[1024];

        // // Step 1: fill out array with appearances of numbers (with shift)
        // // ('True' -> number is in nums, 'False' -> number is not in nums)
        // // by default, at the beginning all values are 'False'
        // for(int n : nums)
        //     numsAppearances[n + 512] = true;
        
        // // Step 2: iterate through the array and check for the longest sequence
        // int longestConsecutiveSequenceLength = 0;
        // int currentConsecutiveSequenceLength = 0;
        // int i = 0;
        
        // while(i < numsAppearances.length) {
        //     // skip to the next number that is marked as 'True'
        //     while(i < numsAppearances.length && !numsAppearances[i])
        //         i++;
            
        //     // caclulate current sequence (each next 'True'-number)
        //     while(i + 1 < numsAppearances.length && numsAppearances[i + 1])
        //         currentConsecutiveSequenceLength++;
            
        //     // compare with previous sequence-length
        //     // ('+1' is neccessary as we did not count the first element of sequence)
        //     longestConsecutiveSequenceLength = Math.max(
        //         longestConsecutiveSequenceLength,
        //         currentConsecutiveSequenceLength + 1
        //     );

        //     // clear current sequence length (for next iteration)
        //     currentConsecutiveSequenceLength = 0;
        // }

        // return longestConsecutiveSequenceLength;

        // Idea 2: alternative, but with sets
        
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int key : nums) {
            if (set.contains(key)) {
                set.remove(key);
                int low = key - 1;
                while (set.contains(low)) {
                    set.remove(low);
                    low--;
                }
                int high = key + 1;
                while (set.contains(high)) {
                    set.remove(high);
                    high++;
                }
                ans = Math.max(ans, high - low - 1);
            }
        }
        return ans;
    }
}