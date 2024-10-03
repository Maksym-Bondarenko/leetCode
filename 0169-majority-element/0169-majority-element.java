class Solution {
    public int majorityElement(int[] nums) {
        // // Idea 1: <sorting> {Time: O(N log N)}
        // // sort array and return element on the middle position (it will always be, as majority element has > n/2 occurrences)
        // Arrays.sort(nums);
        // int n = nums.length;
        // return nums[n/2];

        // // Idea 2: <hash-map> {Time: O(N), SPace: O(N)}
        // // create a HM (or array <=> hash-table) with number and amount of its appereances
        // // iterate through HM-values to find max (> n/2)

        // Map<Integer, Integer> numsCount = new HashMap<>();
        // int majorityThreshold = nums.length / 2;

        // // fill-out HM with nums-values and their amount
        // for (int num : nums)
        //     numsCount.put(num, numsCount.getOrDefault(num, 0) + 1);

        // // find key from HM-pairs (key, value), where values is > n/2
        // for (Map.Entry<Integer, Integer> entry : numsCount.entrySet()) {
        //     // majority element (occurrences > n/2)
        //     if (entry.getValue() > majorityThreshold)
        //         return entry.getKey();
        // }

        // // if no majority-element is found (should not occurre)
        // return -1;

        // Idea 3: <Moore Voting Algorithm> {Time: O(N), Space: O(1)}
        // The intuition behind the Moore's Voting Algorithm is based on the fact that if there is a majority element in an array, it will always remain in the lead, even after encountering other elements.
        // ! only works if strongly > than half of array

        int count = 0;
        int candidate = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
}