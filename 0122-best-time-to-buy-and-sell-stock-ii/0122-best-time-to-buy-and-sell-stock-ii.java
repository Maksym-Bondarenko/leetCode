class Solution {
    public int maxProfit(int[] prices) {
        // Idea: buy at consiquetive lowest point; sell at consiquetive highest point (Greedy)
        // Time: O(n), Space: O(1)
        
        int profit = 0;
        int buyPrice = 0;
        int sellPrice = 0;
        int length = prices.length;
        
        for(int i = 0; i < length; i++) {
            // skip till end of FALLING sequence
            while(i < length - 1 && prices[i] >= prices[i + 1])
                i++;
            
            buyPrice = prices[i];
            
            // skip till end of RISING sequence
            while(i < length - 1 && prices[i] <= prices[i + 1])
                i++;
            
            sellPrice = prices[i];
            
            profit += sellPrice - buyPrice;
        }
        
        return profit;
    }
}