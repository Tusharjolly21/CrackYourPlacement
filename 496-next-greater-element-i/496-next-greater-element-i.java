class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int num:nums2){
            while(!stack.isEmpty() && num>stack.peek())
                map.put(stack.pop(),num);
            stack.push(num);
        }
        int i = 0;
        for(int num:nums1)
        ans[i++] = map.getOrDefault(num,-1);
        return ans;
    }
}
/*
We iterate through nums2[] and push each element into a stack.
If the current element in the iteration is greater than the top most element in the stack, then we pop it out and add the popped out element as key and the current element as the value (next greater number).
We repeat this process as long as the current element is greater than the top most element in the stack or the stack is empty.
The current element is also added to the stack.
The last element in the nums2[] will not have a next element. Hence we are not adding that to the map.
Similarly if there are elements in the stack which does not have a next greater element, remains in the stack and is not moved to the map as the requirement for these elements is to default it to -1, which is being taken care while fetching values from the map.*/