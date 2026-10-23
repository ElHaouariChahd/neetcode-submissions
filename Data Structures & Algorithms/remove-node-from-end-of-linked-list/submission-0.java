
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode curr = head;

        // 1. Calculer la longueur
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // 2. Cas où il faut supprimer la tête
        if (length == n) {
            return head.next;
        }

        // 3. Aller au nœud précédent celui à supprimer
        curr = head;
        for (int i = 0; i < length - n - 1; i++) {
            curr = curr.next;
        }

        // 4. Supprimer le nœud
        curr.next = curr.next.next;

        return head;
    }
}
