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
    public ListNode mergeNodes(ListNode head) {
     ListNode res=new ListNode(0) ;
        if(head==null) return null;
        ListNode temp=head;
        ListNode temp3=new ListNode(0);
        while(temp!=null&&temp.next!=null){
            int val=0;
            temp=temp.next;
            
            while(temp.val!=0){
                val+=temp.val;
                temp=temp.next;
            }
            if(res.val==0){
                res=new ListNode(val);
                
                 temp3=new ListNode(res.val);
                 res.next=temp3;
            }
            else{
                ListNode temp2=new ListNode(val);
                temp3.next=temp2;
                temp3=temp2;
            }

        }
        return res.next;

    }
}