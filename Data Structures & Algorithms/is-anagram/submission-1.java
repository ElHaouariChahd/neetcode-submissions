class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!= t.length()){
            return false;
        }
        
        Map <Character, Integer> character= new HashMap<>();
        for(char c : s.toCharArray()){
            character.put(c, character.getOrDefault(c,0)+1);
        }

        for (char c : t.toCharArray()){
            if(!character.containsKey(c)){
                return false;
            }

            character.put(c, character.get(c)-1);
            if(character.get(c)==0){
                character.remove(c);
            }
        }
        return character.isEmpty();
    }
}
