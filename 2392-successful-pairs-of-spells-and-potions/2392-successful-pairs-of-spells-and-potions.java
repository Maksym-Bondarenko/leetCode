class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // Idea 1: <brute-force> {Time: O(N * M)}
        // iteratively check all pairs (for each element of 'spells' together with each element of 'potions'), if it is >= 'success'

        // Idea 2: <binary-search on sorted array> {Time: O(N * log(M))}
        // sort array 'potions' and find there an element starting from which all larger elements multiplied with current 'spells'-element are >= 'success'

        int[] pairs = new int[spells.length];
        Arrays.sort(potions);

        // iterate through each 'spells'-element and cound successful pairs
        for (int i = 0; i < spells.length; i++) {
            // use binary-search on the sorted 'potions'-array to find the weakest element, multiplied with 'currentSpell' >= success (all next elements are successful too)
            long successFactor = (success + spells[i] - 1) / spells[i];
            pairs[i] = potions.length - successfulIndexBinarySearch(potions, successFactor);
        }

        return pairs;
    }

    // help-function, returning amount of elements of given sorted array, with smallest element, that is okay for 'successFactor'
    private int successfulIndexBinarySearch(int[] sortedArray, long successFactor) {
        int size = sortedArray.length;
        int leftIndex = 0;
        int rightIndex = size;

        while (leftIndex < rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            
            // if product is smaller than 'successFactor' => move right (to find >= than successRate)
            if (sortedArray[middleIndex] < successFactor)
                leftIndex = middleIndex + 1;
            // if product is not smaller than 'successFactor' => move left (to find the smallest one of those)
            if (sortedArray[middleIndex] >= successFactor)
                rightIndex = middleIndex;
        }

        // return amount of elements those product is >= 'successFactor'
        return rightIndex;
    }
}