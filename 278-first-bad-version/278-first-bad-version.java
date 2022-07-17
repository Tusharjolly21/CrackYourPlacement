/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while(low<high){
            int mid = low+(high-low)/2;
            if(isBadVersion(mid)){
                high =  mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}

/*
It is obvious that the version would looks like the following:
FFTTTT (The first two are correct version, the rest are bad ones)
So we can use binary search to find the rightmost F or the leftmost T
*/