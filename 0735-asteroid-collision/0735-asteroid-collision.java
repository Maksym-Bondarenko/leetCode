class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Idae: {Time: O(N)} use Stack for tracking asteroids
        // push to stack positive numbers (asteroids ->)
        // for negative numbers (<- asteroids) decide by poping from stack

        Stack<Integer> asteroidsStack = new Stack<>();

        for (int asteroid : asteroids) {
            // positive values (->): push to stack
            if (asteroid > 0)
                asteroidsStack.push(asteroid);
            else {
                // negative values (<-):
                // - if there are positive elements on the stack: collision + repeat
                // - if there are no/negative elements on the stack: push

                while (!asteroidsStack.isEmpty() && asteroidsStack.peek() > 0 && asteroidsStack.peek() < -asteroid) {
                    // destroy positive asteroid if its value is smaller
                    // else: do nothing (don't push new element)
                    asteroidsStack.pop();
                }

                // if true => before current asteroids all are negative or it is first
                if (asteroidsStack.isEmpty() || asteroidsStack.peek() < 0)
                    asteroidsStack.push(asteroid);

                // if values of previous positive and current negative asteroids are same
                // => destroy both
                if (asteroidsStack.peek() == -asteroid)
                    asteroidsStack.pop();
            }
        }

        // convert stack (backwards) to int-array
        int[] res = new int[asteroidsStack.size()];
        for (int i = asteroidsStack.size() - 1; !asteroidsStack.isEmpty(); i--)
            res[i] = asteroidsStack.pop();

        return res;
    }
}