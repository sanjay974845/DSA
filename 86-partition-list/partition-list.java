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
    public ListNode partition(ListNode head, int x) {
        ListNode lessDummy = new ListNode(0);
        ListNode geDummy = new ListNode(0);
        ListNode less = lessDummy, ge = geDummy;

        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                ge.next = head;
                ge = ge.next;
            }
            head = head.next;
        }

        ge.next = null;              // terminate to avoid a cycle
        less.next = geDummy.next;    // join the two lists
        return lessDummy.next;
    }
}

        
  
