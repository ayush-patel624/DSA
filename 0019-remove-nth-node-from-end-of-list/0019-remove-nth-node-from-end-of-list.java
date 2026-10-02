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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null) return null;

        int count=1;
        int total=1;
        ListNode prev=null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
            count+=1;
            if(fast!=null){
                total+=2;
            }else{
                total+=1;
            }
        }  

        System.out.println(total);
        System.out.println(count);


        if(total-n+1 > count){
            while(count!=total-n+1){
                prev=slow;
                slow=slow.next;
                count++;
            }
            prev.next=slow.next;
        }else{
            count=1;
            prev=null;
            slow=head;
            while(count!=total-n+1){
                prev=slow;
                slow=slow.next;
                count++;
            }
            if(prev==null) return head.next;
            prev.next=slow.next;
        }

        return head;

    }
}