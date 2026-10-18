class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] need = new int[128];
        for (char c : t.toCharArray()) need[c]++;

        int manque = t.length();
        int gauche = 0;
        int debut = 0, minLen = Integer.MAX_VALUE;

        for (int droite = 0; droite < s.length(); droite++) {
            char c = s.charAt(droite);
            if (need[c] > 0) manque--; 
            need[c]--;                 

            while (manque == 0) {
                if (droite - gauche + 1 < minLen) {
                    minLen = droite - gauche + 1;
                    debut = gauche;
                }
                char l = s.charAt(gauche);
                need[l]++;               
                if (need[l] > 0) manque++;  
                gauche++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(debut, debut + minLen);
    }
}