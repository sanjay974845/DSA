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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                int dupVal = curr.val;
                // Skip every node with this value
                while (curr != null && curr.val == dupVal) {
                    curr = curr.next;
                }
                prev.next = curr;   // unlink the whole run
            } else {
                prev = curr;        // curr is distinct, keep it
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
    
        
    
