class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        int res=0;
        for(int i: nums){
            if(!set.contains(i)){
                set.add(i);
            }else{
                res= i;
                break;
            }
        }
        return res;
    }
}
