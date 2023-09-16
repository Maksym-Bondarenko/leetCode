class Solution {
    public String multiply(String num1, String num2) {
        // Idea: num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]
        // (same as next, but combining actions from different for-loops into one)

        StringBuilder res = new StringBuilder();
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];
    
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  
        
        for(int p : pos) {
            if(!(res.length() == 0 && p == 0))
                res.append(p);
        }

        return res.length() == 0 ? "0" : res.toString();
    }

    public String multiply_easier(String num1, String num2) {
        // Alternative: array for storing the multiplications of 2 numbers from strings

        // edge-case
        if(num1.equals("0") || num2.equals("0"))
            return "0";

        int[] nums = new int[num1.length() + num2.length()];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < num1.length(); i++){
            for(int j = 0; j < num2.length(); j++){
                // scan from back to head and store in reverse order in nums.
                nums[i+j] += (num1.charAt(num1.length()-1-i)-'0') * (num2.charAt(num2.length()-1-j)-'0');
            }
        }
        int carry = 0;
        for(int i = 0; i < nums.length; i++){
            // do mod and divide to update to only 1 digit
            int sum = nums[i] + carry;
            nums[i] = sum % 10;
            carry = sum / 10;
        }
        
        if(nums[nums.length-1] != 0)
            sb.append(nums[nums.length-1]); // do not append leading 0s
        for(int i = nums.length - 2; i >= 0; i--) 
            sb.append(nums[i]);   // store in normal order

        return sb.toString();
    }

// ***********************************************************************************************************************************************************************

    public String multiply_long_version(String num1, String num2) {
        // Idea: school-vise multiplication in columns:
        // 123 *
        // 456
        // ___
        //   8 (1)
        //  2  (1)
        // 6
        // -> 738 (only * 6)
        //   5 (1)
        //  0  (1)
        // 5
        // -> 615 (only * 5)
        //   2 (1)
        //  8
        // 4
        // -> 492 (only * 4)
        // => 738 * 1 + 615 * 10 + 492 * 100 = 56088 (= 123*456)

        String result = "0";
        String[] subMultiplication = new String[num2.length()];

        // collect all sub-multiplicators (num1 multiplicated with all digits from num2)
        for(int n2 = num2.length() - 1; n2 >= 0; n2--) {
            int multiplicator = num2.charAt(n2) - '0';
            subMultiplication[num2.length() - n2 - 1] = this.multiplyByNumber(num1, multiplicator);
        }

        // sum all sub-nultiplicators into multiplication
        for(int i = 0; i < subMultiplication.length; i++) {
            // column-vise addition with multiplication of element by 10
            result = this.add(result, subMultiplication[i] + "0".repeat(i));
        }

        return result;
    }

    // multiplicates in school-vise method string by integer and returns result as string
    private String multiplyByNumber(String num1, int n) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int num = 0;

        for(int i = num1.length() - 1; i >= 0; i--) {
            num = carry;
            num += (num1.charAt(i) - '0') * n;
            carry = num / 10;
            res.append(num % 10);
        }

        // if result is bigger than original multiplicatorA
        if(carry != 0)
            res.append(carry);

        return res.reverse().toString();
    }

    // adds two given numbers and returns their sum as string
    private String add(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        int runningSum = 0;
        int a = 0;
        int b = 0;

        while(i >= 0 && j >= 0) {
            a = num1.charAt(i) - '0';
            b = num2.charAt(j) - '0';
            runningSum = carry;

            if(i >= 0)
                runningSum += a;
            if(j >= 0)
                runningSum += b;

            // set new carry and current sum (just from 2 digits)
            carry = runningSum >= 10 ? 1 : 0;
            res.append(runningSum % 10);
        }

        return res.reverse().toString();
    }
}