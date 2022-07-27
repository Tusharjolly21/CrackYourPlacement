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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode dummyNode = new ListNode(0);
        int length = length(head);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode curr;
        ListNode nex;
        while(length>=k){
            curr = pre.next;
            nex = curr.next;
            for(int i = 1;i<k;i++){
                curr.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = curr.next;
            }
        pre = curr;
        length -= k;
    }
        return dummyNode.next;
        }
    private int length(ListNode head){
        int length = 0;
        while(head!=null){
            length++;
            head = head.next;
        }
        return length;
    }
}