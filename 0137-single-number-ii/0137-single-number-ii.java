import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public int singleNumber(int[] nums) {
        // Idea 1: (Sort) sort array an check where numbers are coming not as 3 duplicates, but as a single number

        // // Idea 2: (HashMap) use HM to store number and amount of it's occurrences. Go through HM and return number with occurrences = 1

        // Map<Integer, Integer> occurrences = new HashMap<>();

        // // fill-up the HM
        // for(int num : nums)
        //     occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        
        // // return element of HM woth value = 1 (all other have value = 3)
        // for(Entry<Integer, Integer> entry: occurrences.entrySet()) {
        //     if(entry.getValue() == 1)
        //         return entry.getKey();
        // }

        // // error (not found) case -> SHOULD NOT REACH
        // return -1;

        // // Idea 3: (Bit Manipulation)
        // // Runtime: 2ms (80.05%), Memory: 43.53mb (91.39%)

        // // Initialize the variable ans to 0. This variable will store the resulting single number.
        // int ans = 0;

        // // Iterate from i = 0 to i = 31.
        // // This loop considers each bit position from the least significant bit (LSB) to the most significant bit (MSB) of a 32-bit integer.
        // for (int i = 0; i < 32; ++i) {
        //     // Inside the loop, initialize a variable sum to 0.
        //     // This variable will keep track of the number of 1s at the current bit position (i) for all the numbers in the input array.
        //     int sum = 0;

        //     // Iterate through each number num in the input array:
        //     // Right-shift num by i positions: num >> i.
        //     // This operation moves the bit at position i to the least significant bit position.
        //     // Perform a bitwise AND with 1: (num >> i) & 1.
        //     // This extracts the value of the bit at position i from num. If it is 1, the result will be 1; otherwise, it will be 0.
        //     // Add the result of (num >> i) & 1 to sum.
        //     // This counts the number of 1s at bit position i for all the numbers in the array.
        //     for (final int num : nums)
        //         sum += num >> i & 1;

        //     // Take the modulo of sum by 3: sum %= 3.
        //     // This step is performed to handle the numbers that appear three times.
        //     // If sum is divisible by 3, it means the bit at position i has a balanced number of 1s.
        //     // Otherwise, it is an unbalanced line.
        //     sum %= 3;

        //     // Left-shift the value of sum by i positions: sum << i.
        //     // This step creates a bitmask pos where only the bit at position i is set to the value of sum.
        //     // This bitmask identifies the position of the unbalanced line.
        //     // Use the bitwise OR operation with ans and pos: ans |= pos.
        //     // This sets the corresponding bit in ans to 1 if the bit at position i is part of an unbalanced line.
        //     ans |= sum << i;
        // }

        // // After the loop completes, the value stored in ans represents the single number that appears only once in the array.
        // return ans;

        // Idea 4: (Bit Manipulation+)
        // The key idea is to use bitwise operations to keep track of the count of each bit position. By doing so, we can identify the bits that have appeared once, twice, or three times.
        // When a bit appears for the first time (ones is 0 and the bit is toggled), it is stored in ones.
        // When a bit appears for the second time (ones is 1 and the bit is toggled), it is removed from ones and stored in twos.
        // When a bit appears for the third time (ones is 0 and the bit is toggled), it is removed from both ones and twos.
        // By the end of the iteration, the bits that remain in ones represent the bits of the single number that appeared only once, while the bits in twos represent bits that appeared three times (which is not possible).

        int ones = 0;   // Tracks the bits that have appeared once.
        int twos = 0;   // Tracks the bits that have appeared twice.

        for (final int num : nums) {
            // ones ^ i XORs the current number i with the previous value of ones.
            // This operation toggles the bits that have appeared an odd number of times, keeping the bits that have appeared twice unchanged.
            // (~twos) negates the bits in twos, effectively removing the bits that have appeared twice from consideration.
            // The & operation ensures that only the bits that have appeared once (after XOR) and not twice (after negating twos) are retained.
            ones ^= (num & ~twos);  // ones = (ones ^ i) & (~twos);


            twos ^= (num & ~ones);  // twos = (twos ^ i) & (~ones);
        }

        return ones;
    }
}