// Q1 --> https://bit.ly/3QD4hHs

class Q1 {
    static boolean searchKey(int n, Node head, int key) {
        Node temp = head;
        while(temp != null) {
            if(temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }
}

// TC --> 0(N);
// SC --> 0(1)
// Approach --> Transverse through the linked list and applied linear search

// Q2 --> https://bit.ly/3Epriup

class Q2 {
    Node addNode(Node head, int p, int x) {
        if(head == null) return new Node(x);
        Node temp = head;
        for(int i = 0;  i<p && temp.next!= null; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(x);
        Node temp2 = temp.next;
        newNode.prev = temp;
        temp.next = newNode;
        
        if(temp2 != null) {
            newNode.next = temp2;
            temp2.prev = newNode;
        }
        return head;
        
    }
}

// TC --> 0(N)
// SC --> 0(1)
