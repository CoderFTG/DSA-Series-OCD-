// Q1 --> https://leetcode.com/problems/delete-node-in-a-linked-list/

class Q1 {
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while(node!=null && node.next!=null){
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        if(node != null){//Means list is not empty
            if(prev != null) prev.next = null;
            else node = null;//Means list has only one node
        }
    }
}

// TC --> 0(1)
// SC --> 0(1)

// Q2 --> https://bit.ly/3w9pEIt

class Q2 {
    Node insertAtEnd(Node head, int x) {
        if(head==null){
            return new Node(x);
        }
        
        Node newNode=new Node(x);
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        return head;
    }
}

// TC --> 0(1)
// SC --> 0(1)