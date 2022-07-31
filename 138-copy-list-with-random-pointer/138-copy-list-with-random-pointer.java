/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node curr = head;
        while(curr!=null){
            Node temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = temp;
        }
        curr = head;
        while(curr!=null){
            if(curr.next!=null){
                curr.next.random = (curr.random!=null)?curr.random.next:null;
            }
            curr = curr.next.next;
        }
        Node org = head;
        Node copy = head.next;
        Node temp = copy;
        while(org!=null){
            org.next = org.next.next;
            copy.next = (copy.next!=null)?copy.next.next:null;
            org = org.next;
            copy = copy.next;
        }
        return temp;
    }
}