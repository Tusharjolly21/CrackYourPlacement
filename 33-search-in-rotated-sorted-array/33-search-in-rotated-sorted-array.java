class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[low]<=nums[mid]){ /*checking if left part is sorted*/
                if(target>=nums[low] && target<nums[mid]){ /* checking if target will lie on left hand side or right hand side*/
                    high = mid-1;
                }else{
                    low = mid+1;
                }
        }else if(nums[mid]<=nums[high]){ /*checking if right part is sorted*/
                if(target>nums[mid] && target<=nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}