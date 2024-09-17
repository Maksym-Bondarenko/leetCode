class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // Idea:
        // 1. find the biggest element(s) in array
        // 2. iterate through array by adding 'extraCandies' to each current element and checking if it is >= max.element
        // (no corner-cases, according to the task)

        int maximumCandies = getKidWithMaxCandies(candies);
        List kidsWithGreatestNumberOfCandies = new ArrayList<Boolean>(candies.length);

        for(int i = 0; i < candies.length; i++)
            kidsWithGreatestNumberOfCandies.add(candies[i] + extraCandies >= maximumCandies);
        
        return kidsWithGreatestNumberOfCandies;
    }

    private int getKidWithMaxCandies(int candies[]) {
        int currentMax = -1;

        for (int cur : candies) {
            if (cur > currentMax)
                currentMax = cur;
        }

        return currentMax;
    }
}