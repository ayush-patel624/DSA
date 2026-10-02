class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if (prev == null)
            return head.next;

        prev.next = slow.next;

        return head;
    }
}