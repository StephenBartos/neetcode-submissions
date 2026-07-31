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
    public void reorderList(ListNode head) {
        // Find the midpoint
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Cut off the the 1st half from the 2nd half
        ListNode tmp = slow.next;
        slow.next = null;
        slow = tmp;
        // Reverse the 2nd half of the list
        ListNode prev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        // Merge the two halves
        ListNode l1 = head;
        ListNode l2 = prev;
        while (l2 != null) {
            // Save each next
            ListNode tmp1 = l1.next;
            ListNode tmp2 = l2.next;
            // Do the merge
            l1.next = l2;
            l2.next = tmp1;
            // Advance the two pointers along the original halves
            l1 = tmp1;
            l2 = tmp2;
        }
    }
}
