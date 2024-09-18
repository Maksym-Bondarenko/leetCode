class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Idea 1: calculate mproduct of all numbers.
        // For each number divide the product by this number and save result

        // Idea 2: keep track of left-product and right-product of each element (total product = preffix * suffix)
        // new array first contains product of all previous elements, than multiplied with product of all next elements => for each element

        int res[] = new int[nums.length];
        int currentProduct = 1;

        // product of prefixes (left), iterating forwards
        for(int i = 0; i < nums.length; i++) {
            res[i] = currentProduct;
            currentProduct *= nums[i];
        }

        currentProduct = 1;

        // profuct of suffixes (right), iterating backwards
        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] *= currentProduct;
            currentProduct *= nums[i];
        }

        return res;
    }
}