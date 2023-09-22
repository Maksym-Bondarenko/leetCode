class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Idea 1: (HashMap) add elements from any of arrays into HashMap
        // iterate through another array and check wether HS contains such element
        
        Map<Integer, Integer> occurrences = new HashMap<>();    // key: number, value: amount of occurrences
        
        // fill-up map with one of arrays
        for(int num : nums1) {
            Integer amountOfOccurrences = occurrences.get(num);
            if(amountOfOccurrences != null)
                occurrences.put(num, amountOfOccurrences + 1);  // number is already in HM -> increment count
            else
                occurrences.put(num, 1);                        // number is new -> add to HM
        }
        
        // use list as we do not know amount of intersections
        List<Integer> intersectionsList = new ArrayList<>();
        
        for(int num : nums2) {
            // if HM has such value (and its its amount-of-occurrences > 0)
            // -> add to array and decrement its amount-of-occurrences
            // else -> skip
            Integer amountOfOccurrences = occurrences.get(num);
            if(amountOfOccurrences != null && amountOfOccurrences > 0) {
                intersectionsList.add(num);
                occurrences.put(num, amountOfOccurrences - 1);
            }
        }
        
        return intersectionsList.stream().mapToInt(i -> i).toArray();
        
//         // if sorted, O(n) -> sliding window (moving pointers in array, skip unequal values, add if same)
//         Arrays.sort(nums1);   // assume sorted
//         Arrays.sort(nums2);   // assume sorted
            
//         List<Integer> intersections = new LinkedList<>();
//         int pointer1 = 0;
//         int pointer2 = 0;
        
//         while(pointer1 < nums1.length && pointer2 < nums2.length) {
//             int first = nums1[pointer1];
//             int second = nums2[pointer2];
            
//             // adding to result
//             if(first == second) {
//                 intersections.add(first);
//                 pointer1++;
//                 pointer2++;
//                 continue;
//             }
            
//             // skip all duplicates of the lower number in array
//             if (second > first) {
//                 while (pointer1 < nums1.length && first == nums1[pointer1])
//                     pointer1++; // move pointer in first array
//             } else {
//                 while (pointer2 < nums2.length && second == nums2[pointer2])
//                     pointer2++; // move pointer in second array
//             }
//         }
        
//         return intersections.stream().mapToInt(Integer::intValue).toArray();
    }
}