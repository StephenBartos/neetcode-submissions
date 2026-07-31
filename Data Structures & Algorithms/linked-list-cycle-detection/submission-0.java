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
    public boolean hasCycle(ListNode head) {
        // Naive O(n) space solution
        Set<ListNode> seen = new HashSet<>();
        ListNode ptr = head;
        while (ptr != null) {
            if (seen.contains(ptr)) {
                return true;
            }
            seen.add(ptr);
            ptr = ptr.next;
        }
        return false;
    }
}
