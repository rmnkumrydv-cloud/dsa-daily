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
    public boolean hasCycle(ListNode head) {
      if (head == null || head.next == null) return false;

        ListNode sl = head;
        ListNode fa = head;

        while (fa != null && fa.next != null) {
            sl = sl.next;          
            fa = fa.next.next;     

            if (sl == fa) {
                return true;           
            }
        }

        return false;  
    }
}