class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Time: O(n)
        
        int[] answer = new int[temperatures.length];   // initially all values are 0
        Stack<Integer> tempIndices = new Stack<>();    // to save 'falling' sequence of temperatures

        for (int i = 0; i < temperatures.length; i++) {
            // if today temperature is above any day of before (that are still 0)
            // add days-differenz to result-array and remove value from stack
            // important: repear for possible multiple values!
            while (!tempIndices.isEmpty() &&
                    temperatures[i] > temperatures[tempIndices.peek()]) {
                // set values for some previous day (= saved index in stack)
                // how many days <=> indices, not array-values!
                int idx = tempIndices.pop();
                answer[idx] = i - idx;
            }
            
            tempIndices.push(i);
        }

        return answer;
    }
}