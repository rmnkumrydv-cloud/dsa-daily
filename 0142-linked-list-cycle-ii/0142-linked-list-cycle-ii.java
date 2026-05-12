/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null) return head;
        ListNode slow=head;
        ListNode fast=head;
        boolean check =false;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                check =true;
                break;
            }
        }
        if(!check){
            return null;
        }
        ListNode slow1=head;
        
        while(slow1!=fast){
            slow1=slow1.next;
            fast=fast.next;
        }
        return slow1;
        }
}