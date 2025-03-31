// Q1 --> https://bit.ly/3w6hUaa

class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        if(head == null || head.next == null) return head;
        DLLNode back = null;
        DLLNode current = head;
        while(current != null) {
            back = current.prev;
            current.prev = current.next;
            current.next = back;
            current = current.prev;
        }
        return back.prev;
    }
}
// TC --> 0(N)
// SC --> 0(1)

// Q2 --> https://bit.ly/3QlEoMx

class Q2 {
    public Node deleteNode(Node head, int x) {
        if(head == null) return null;
        if(x == 1) {
            head = head.next;
            head.prev = null;
            return head;
        }
        Node temp = head;
        for(int i=1;i<x-1;i++){
            temp=temp.next;
        }
        
        if(temp.next.next==null){
            temp.next=null;
            return head;
        }
        
        temp.next.next.prev=temp;
        temp.next=temp.next.next;
       //temp.next.prev=temp;
        return head;
    }
}

// TC --> 0(N)
// SC --> 0(1)