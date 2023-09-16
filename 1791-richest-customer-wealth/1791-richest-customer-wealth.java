class Solution {
    public int maximumWealth(int[][] accounts) {
        int runningWealth = 0;
        int maxWealth = 0;

        for(int i = 0; i < accounts.length; i++) {
            runningWealth = 0;
            for(int j = 0; j < accounts[i].length; j++)
                runningWealth += accounts[i][j];
            maxWealth = Math.max(maxWealth, runningWealth);
        }

        return maxWealth;
    }
}