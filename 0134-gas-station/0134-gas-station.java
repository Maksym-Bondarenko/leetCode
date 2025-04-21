class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Idea: the whole circular journey is possible if sum of gas >= sum of cost
        // To find the start-point we travers array making sure that running cost (gas - cost + rest from previous step) is >= 0. If it is below 0 -> try next start-index.
        // Do so, untill whole circle is done (since we sure that it is possible)
        // Time: O(n), Space: O(1)

        // edge-case: sum of costs >= sum of gas, so no circular journey is possible
        int n = gas.length;
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < n; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        if (costSum > gasSum)
            return -1;
        
        // now we are sure that circular journey is possible
        // iterate arrays to find a start-index from which running cost is >= 0
        int runningSum = 0;
        int start = 0;

        // iterate exact size of circular route (as we know that there is a solution)
        for (int i = 0; i < n; i++) {
            runningSum += (gas[i] - cost[i]);

            if (runningSum < 0) {
                // if no circular journey from current 'start-index' is possible,
                // move starting point and clear running sum
                runningSum = 0;
                start = i + 1;
            }
        }

        return start;
    }
}