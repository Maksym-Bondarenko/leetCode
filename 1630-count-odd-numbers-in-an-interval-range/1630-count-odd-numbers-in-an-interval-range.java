class Solution {
    public int countOdds(int low, int high) {
        // trivial solution, time O(n) -> go fom low to high, counting the odd numbers
        // better, time O(1) -> math. Do from even odd by incrementing low or decrementing high

        // odd, odd   => (h-l)/2+1
        // odd, even  => (h-l-1)/2+1
        // even, odd  => (h+1-l)/2+1
        // even, even => (h+1-l-1)/2+1

        if(high % 2 == 0)
            high--;
        if(low % 2 == 0)
            low++;
        return (high - low) / 2 + 1;
    }
}