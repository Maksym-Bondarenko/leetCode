class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Idea: use HashSet, add elements to the set and checking if element with such value exists
        // if element exists -> return fales
        
        Set<Integer> numSet = new HashSet<>();
        
        for(int num : nums) {
            if(numSet.contains(num))
                return true;
            else
                numSet.add(num);
        }
        
        return false;
    }
}