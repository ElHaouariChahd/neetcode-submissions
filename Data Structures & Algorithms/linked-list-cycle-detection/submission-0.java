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

        HashMap<ListNode, Integer> hash = new HashMap<>();

        ListNode curr = head;

        while (curr != null) {
            if (hash.containsKey(curr.next)) {
                return true;
            } else {
                hash.put(curr.next, 1);
            }
            curr = curr.next;
        }
        return false;
    }
}
