class Solution {
    public int lengthOfLongestSubstring(String s) {
        int gauche = 0;
        int max =0 ;
        HashSet<Character> set= new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while(set.contains(c) ){
                set.remove(s.charAt(gauche));
                gauche++;
            }
            set.add(c);
            max = Math.max(max, right - gauche + 1);

        }
        return max;
    }
}

