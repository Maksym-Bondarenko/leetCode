class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int runningSum = carry;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while(i >= 0 || j >= 0) {
            // set carry from previous addition
            runningSum = carry;

            // need check on >= 0, if some of strings has already finished, and another has not
            if(i >= 0)
                runningSum += a.charAt(i--) - '0';
            if(j >= 0)
                runningSum += b.charAt(j--) - '0';

            // runningSum could be: 0, 1, 2 or 3. By last two need to add 1 to carry
            carry = runningSum > 1 ? 1 : 0;

            // append to result (0 -> 0, 1 -> 1, 2 -> 0, 3 -> 1)
            res.append(runningSum % 2);
        }

        // add new leading bit if needed
        if(carry != 0)
            res.append(carry);

        // reverse, as we appended to string backwords
        return res.reverse().toString();
    }
}