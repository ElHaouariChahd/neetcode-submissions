class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int droite = 0; droite < n; droite++) {

            while (!deque.isEmpty() && deque.peekFirst() <= droite - k) {
                deque.pollFirst();
            }

            // 2. Supprimer les éléments plus petits que nums[droite]
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] <= nums[droite]) {
                deque.pollLast();
            }

            // 3. Ajouter l'indice actuel
            deque.offerLast(droite);

            // 4. Enregistrer le maximum lorsque la fenêtre est complète
            if (droite >= k - 1) {
                result[droite - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}