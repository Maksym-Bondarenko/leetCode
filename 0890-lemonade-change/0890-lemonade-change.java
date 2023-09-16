class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] change = {0, 0, 0};   // 5 / 10 / 20-bills

        for(int bill : bills) {
            if(bill == 5)
                change[0]++;
            else if(bill == 10) {
                if(change[0] == 0)
                    return false;
                else {
                    change[0]--;
                    change[1]++;
                }
            } else if (bill == 20) {
                // 5 needs anyway
                if(change[0] == 0)
                    return false;
                else {
                    if(change[1] >= 1 && change[0] >= 1) {
                        // 10 + 5
                        change[0]--;
                        change[1]--;
                        change[2]++;
                    } else if(change[0] >= 3) {
                        // 5 + 5 + 5
                        change[0] -= 3;
                        change[2]++;
                    } else
                        return false;
                }
            }
        }

        return true;
    }
}