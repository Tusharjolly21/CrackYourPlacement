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
class Solution
{
   //Function to sort the given linked list using Merge Sort.
   public ListNode sortList(ListNode head)
   {
       if(head == null || head.next == null){
           return head;
       }
       ListNode middle = getMiddle(head);
       
       
       ListNode p1 = head;
       ListNode p2 = middle.next;
      middle.next = null;    /*made another list p1 to middle and middle.next to last*/
       p1 = sortList(p1);
      
       p2 = sortList(p2);
       head = merge(p1,p2);
       return head;
      
   }
   private ListNode getMiddle(ListNode head){
       ListNode slow = head;
       ListNode fast = head;
       while(fast.next!=null && fast.next.next!=null){
           slow = slow.next;
           fast = fast.next.next;
       }
       return slow;
   }
  private ListNode merge(ListNode h1, ListNode h2){
      if(h1 == null){
          return h2;
      }
      if(h2 == null){
          return h1;
      }


       ListNode head,tail;
       if(h1.val<=h2.val){
           head = h1;
           tail = h1;
           h1 = h1.next;
           
       }else{
           head = h2;
           tail = h2;
           h2 = h2.next;
       }
       while (h1!=null && h2!=null){
           if(h1.val<= h2.val){
               tail.next = h1;
               h1 = h1.next;
               tail = tail.next;
           }else{
               tail.next = h2;
               h2 = h2.next;
               tail = tail.next;
       }
       }
       if(h1!=null){
           tail.next = h1;
       }else{
           tail.next = h2;
       }
   

return head;
}
}