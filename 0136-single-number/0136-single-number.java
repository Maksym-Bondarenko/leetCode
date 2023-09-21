class Solution {
    public int singleNumber(int[] nums) {
        // // Idea 1: (has set) put element in the hashSet by first occurence and remove it by second.
        // // the only element in HS has no pair
        
        // Set<Integer> numberPairs = new HashSet<>();
        
        // // add/remove elements to/from HS
        // for(int num : nums) {
        //     if(numberPairs.contains(num))
        //         numberPairs.remove(num);
        //     else
        //         numberPairs.add(num);
        // }
        
        // // return last single element (it has no pair)
        // return duplicateSet.iterator().next();

        // Idea 2: (bit-manipulation) XOR all elements, last one is without pair (as element XOR same element brings 0)
        // Time: O(N), Space: O(1)
        int ans = 0;
        for(int num : nums)
            ans ^= num;
        return ans;
    }
}