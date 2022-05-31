/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return divide(lists,0,lists.length-1);
    }
    // using merge sort first dividing the list
    public ListNode divide(ListNode[] lists,int low,int high){
        if(low==high) return lists[low];
        int mid = low+(high-low)/2;
        ListNode list1 = divide(lists,low,mid);
        ListNode list2 = divide(lists,mid+1,high);
        return merge(list1,list2);
    }
    // then we will merge
    public ListNode merge(ListNode list1,ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        while(curr1!=null || curr2!=null){
            if(curr1==null){
                curr.next = curr2;
                break;
            }else if(curr2==null){
                curr.next = curr1;
                break;
            }else{
                 if(curr1.val<=curr2.val){
                curr.next = curr1;
                curr1 = curr1.next;
            }else{
                curr.next = curr2;
                curr2 = curr2.next;
            }
                curr = curr.next;
        }
        
    }
        return dummy.next;
    
}
}