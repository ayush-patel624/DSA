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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int [] res = new int[]{-1,-1};
        if(head==null) return res;
        int prev=-1;
        ListNode curr = head;
        int count=0;

        ArrayList<Integer> list = new ArrayList<>();
    
        while(curr.next!=null){
            if(prev !=-1 && curr.next!=null){
                if(prev < curr.val && curr.next.val < curr.val) list.add(count);
                else if(prev > curr.val && curr.next.val > curr.val) list.add(count);
            }
            prev=curr.val;
            count++;
            curr=curr.next;
        }

        if(list.size() < 2) return res;

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int i=1;i<list.size();i++){
            if(list.get(i)-list.get(i-1) < min) min=list.get(i)-list.get(i-1);
        }

        max = list.get(list.size()-1)-list.get(0);

        res[0]=min;
        res[1]=max;

        return res;

    }
}