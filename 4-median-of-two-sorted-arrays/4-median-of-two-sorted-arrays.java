class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1>len2) return findMedianSortedArrays(nums2,nums1);
        int low = 0;
        int high = len1;
        while(low<=high){
            int i1 = (low+high)/2;
            int i2 = (len1+len2+1)/2-i1;
            
            int min1 = (i1==len1)?Integer.MAX_VALUE:nums1[i1];
            int max1 = (i1==0)?Integer.MIN_VALUE:nums1[i1-1];
            int min2 = (i2==len2)?Integer.MAX_VALUE:nums2[i2];
            int max2 = (i2==0)?Integer.MIN_VALUE:nums2[i2-1];
            if(max1<=min2 && max2<=min1){
                if((len1+len2)%2==0){
    return ((double)Math.max(max1,max2)+Math.min(min1,min2))/2;
                }else{
                    return (double)Math.max(max1,max2);
                }
            }else if(max1>min2){
                high = i1-1;
            }else{
                low = i1+1;
            }
            
        }
        return 0.0;
    }
}