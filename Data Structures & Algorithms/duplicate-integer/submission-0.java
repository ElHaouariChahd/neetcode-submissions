class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer , Integer> hash=new HashMap<>();
        for (int i : nums){
            if (hash.containsKey(i)){
                return true;
            }else{
                hash.put(i,0);
            }
        }
        return false;
        
    }
}