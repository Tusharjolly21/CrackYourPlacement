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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        
        for (int i = 0; i < left - 1; i++){
             pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode end = start.next;
        
        for (int i = 0; i < right - left; i++) {
            start.next = end.next;
            end.next = pre.next;
            pre.next = end;
            end = start.next; 
        }
        return dummyNode.next;
    }
}
