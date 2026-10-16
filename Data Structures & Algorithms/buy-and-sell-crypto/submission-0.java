class Solution {
    public int maxProfit(int[] prices) {
        int gauche = 0;          // jour d'achat (minimum rencontré)
        int maxProfit = 0;

        for (int droite = 1; droite < prices.length; droite++) {
            if (prices[droite] < prices[gauche]) {
                gauche = droite;                       // nouveau minimum
            } else {
                maxProfit = Math.max(maxProfit, prices[droite] - prices[gauche]);
            }
        }
        return maxProfit;
    }
}