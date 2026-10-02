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

        if (head == null || head.next == null) {
            return;
        }

        Stack<ListNode> stack = new Stack<>();

        ListNode curr = head;

        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        // 2. Reorder the list
        curr = head;

        while (curr != null) {

            ListNode last = stack.pop();

            // If we reached the same node, stop
            if (curr == last || curr.next == last) {
                last.next = null;
                break;
            }

            ListNode next = curr.next;

            curr.next = last;
            last.next = next;

            curr = next;
        }
    }
}
