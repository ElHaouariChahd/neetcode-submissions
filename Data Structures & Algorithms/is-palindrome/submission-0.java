class Solution {
    public boolean isPalindrome(String s) {
        String w = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for(int i=0;i< w.length()/2; i++){
            if(w.charAt(i) != w.charAt(w.length()-i-1)){
                return false;
            }
        }
        return true;
        
    }
}
