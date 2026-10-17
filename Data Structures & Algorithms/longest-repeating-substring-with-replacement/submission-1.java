class Solution {
    public int characterReplacement(String s, int k) {
        
        HashMap<Character, Integer> map = new HashMap<>();

        int gauche = 0;
        int maxFreq = 0;
        int resultat = 0;

        for (int droite = 0; droite < s.length(); droite++) {
            char c = s.charAt(droite);

            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));

            while ((droite - gauche + 1) - maxFreq > k) {
                char gaucheChar = s.charAt(gauche);
                map.put(gaucheChar, map.get(gaucheChar) - 1);
                gauche++;
            }

            resultat = Math.max(resultat, droite - gauche + 1);
        }

        return resultat;
    }
}