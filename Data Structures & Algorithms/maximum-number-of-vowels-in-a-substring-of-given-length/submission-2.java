class Solution {
    public int maxVowels(String s, int k) {
        int left = 0;
        Set<Character> set = Set.of('e', 'a', 'i', 'o', 'u');
        int maxVowls = 0;
        int vowels = 0;

        for (int right = 0; right < s.length(); right++) {
            if (set.contains(s.charAt(right))) {
                vowels++;
            }

            if (right - left + 1 > k) {
                if (set.contains(s.charAt(left))) {
                    vowels--;
                }
                left++;
            }

            if (right - left + 1 == k) {
                maxVowls = Math.max(maxVowls, vowels);
            }
        }

        return maxVowls;
    }
}