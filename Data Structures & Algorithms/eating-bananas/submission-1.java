class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        // Trouver la plus grande pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left <= right) {
            int k = left + (right - left) / 2;

            long hours = 0;

            // Calculer le nombre d'heures nécessaires avec k
            for (int pile : piles) {
                hours += (pile + k - 1) / k;
            }

            if (hours <= h) {
                // k fonctionne, mais on cherche peut-être plus petit
                right = k - 1;
            } else {
                // k est trop petit
                left = k + 1;
            }
        }

        return left;
    }
}