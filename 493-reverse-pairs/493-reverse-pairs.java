class Solution {
    public int reversePairs(int[] nums) {
        return merge(nums,0,nums.length-1);
    }
    private int merge(int[] nums,int low,int high){
        int count = 0;
        if(low<high){
            int mid = low+(high-low)/2;
            count+=merge(nums,low,mid);
            count+=merge(nums,mid+1,high);
            count+=mergeAndCount(nums,low,mid,high);
        }
        return count;
    }
    private int mergeAndCount(int[] nums,int low,int mid,int high){
        int n1 = mid-low+1;
        int n2 = high-mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for(int i = 0;i<n1;i++){
            left[i] = nums[low+i];
        }
        for(int j = 0;j<n2;j++){
            right[j] = nums[mid+1+j];
        }
        int i = 0;
        int j = 0;
        int count = 0;
        while(i<n1 && j<n2){
            if((long)left[i]>(long)2*right[j]){
                count+=(n1-i);
                j++;
            }else{
                i++;
            }
        }
        i = 0;
        j = 0;
        int k = low;
        while(i<n1 && j<n2){
            if(left[i]<right[j]){
                nums[k++] = left[i++];
            }else{
                nums[k++] = right[j++];
            }
        }
        while(i<n1){
            nums[k++] = left[i++];
        }
        while(j<n2){
            nums[k++] = right[j++];
        }
        return count;
    }
}