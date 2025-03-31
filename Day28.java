// Q1 --> https://leetcode.com/problems/linked-list-cycle/description/

class Q1 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head; ListNode fast = head;
        while( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}

// TC --> 0(N)
// SC --> 0(1)

// Q2 --> https://leetcode.com/problems/middle-of-the-linked-list/description

class Q2 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head; ListNode fast = head;
        while( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

// TC --> 0(N/2)
// SC --> 0(1)