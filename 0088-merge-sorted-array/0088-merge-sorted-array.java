class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Idea 1: (brute-force, additional space)
        // Create a new array for merged sorted elements and fill it.
        
        // // Idea 2: (m+n time and constant space)
        // // Two-pointers approach. Fill array from the last elements (largest first),
        // // taking into account only meaningfull elements (not zero at the end of array1).
        
        // int i1 = m - 1;  // index of last (meaningfull) element in nums1
        // int i2 = n - 1;  // index of last element in nums2
        
        // // iterate through the larger array (with 0-elements)
        // for(int i = nums1.length - 1; i >= 0; i--) {
        //     // cases if one of arrays is already done
        //     if(i1 < 0) {
        //         // copy rest of nums2
        //         while(i >= 0)
        //             nums1[i--] = nums2[i2--];
        //         break;
        //     } else if(i2 < 0) {
        //         // copy rest of nums1
        //         while(i >= 0)
        //             nums1[i--] = nums1[i1--];
        //         break;
        //     } else {
        //         // normal cases (when neither of arrays is done)
        //         if(nums1[i1] > nums2[i2])
        //             nums1[i] = nums1[i1--];
        //         else
        //             nums1[i] = nums2[i2--];
        //     }
        // }

        // Alternative:

        int i = m - 1;      // array1 (bigger) last meaningfull element
        int j = n - 1;      // array2 last meaningfull element
        int k = m + n - 1;  // array1 last element (zero)
        
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
    }
}