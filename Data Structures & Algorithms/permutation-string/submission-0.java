class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();

        if (n > s2.length()) return false;

        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for (int i = 0; i < n; i++) {
            f1[s1.charAt(i) - 'a']++;
            f2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(f1, f2)) return true;

        for (int droite = n; droite < s2.length(); droite++) {
            f2[s2.charAt(droite) - 'a']++;
            f2[s2.charAt(droite - n) - 'a']--;

            if (Arrays.equals(f1, f2)) {
                return true;
            }
        }

        return false;
    }
}