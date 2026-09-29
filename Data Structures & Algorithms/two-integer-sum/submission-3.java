class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int left = 0; left< nums.length; left++){
            for (int right =nums.length-1; right> left; right--){
                if(nums[left]+nums[right]==target){
                    return new int[]{left, right};
                    
                }
            }
        }
        return new int[]{};
    }
}
