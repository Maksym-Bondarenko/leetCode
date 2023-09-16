class Solution {
    public int arraySign(int[] nums) {
        boolean isPositive = true;

        for(int num : nums) {
            if(num == 0)
                return 0;
            else if(num < 0)
                isPositive = !isPositive;
        }

        return isPositive ? 1 : -1;
    }
}