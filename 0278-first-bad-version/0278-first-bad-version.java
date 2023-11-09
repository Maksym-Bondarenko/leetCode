/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // Idea 1: (brute-force)
        // Iterate array from beginning and check if each version is good or bad.
        // Time O(n), Space: O(1)
        
        // Idea 2: (binary search)
        // Using binary-search (iterative or recursive) find first occurance of a bad version
        // (frist comes only good versions, after some point only bad ones)
        // Time: O(log n), space: O(1)
        
        // corner-cases
        if(n <= 1)
            return n;
        
        int start = 1;  // counting versions from 1, not 0
        int end = n;
        
        // iterative binary-search
        while(start < end) {
            int mid = start + (end - start) / 2;
            
            if(isBadVersion(mid))
                end = mid;         // look on the left-side (FIRST bad version)
            else                   // isBadVersion(mid) == false
                start = mid + 1;   // look on the right-side (bad version)
        }
        
        // post-processing, possibilities: [good, bad] or [bad, bad]
        return isBadVersion(start) ? start : end ;
    }
}