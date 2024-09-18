class Solution {
    public int maxOperations(int[] nums, int k) {
        // rephrase: how many DISTINCT pares that comes up to k in the array nums
        // Idea 1 <Time: O(N * log N)>: sort array and use two-pointers approach (one from start, second from end, moving to each other) check if sum of array on pointers = k
        // Idea 2 <Time: O(N)>: use HashMap with value of (k-i) for each array-value

        // (key, value); key = needed value to build a pair; value = amount of keys
        Map<Integer, Integer> numsMap = new HashMap();
        int operationsCount = 0;

        for(int i = 0; i < nums.length; i++) {
            // value to build a pair with 'nums[i]'
            int res = k - nums[i];

            if(numsMap.containsKey(res)) {
                operationsCount++;
                if(numsMap.get(res) == 1)
                    numsMap.remove(res);
                else
                    numsMap.put(res, numsMap.get(res) - 1);
            } else
                numsMap.put(nums[i], numsMap.getOrDefault(nums[i], 0) + 1);
        }

        return operationsCount;
    }
}