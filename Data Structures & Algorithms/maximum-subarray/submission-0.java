class Solution {
    public int maxSubArray(int[] nums) {
        // utiliser algo de Kanban
        int res = nums[0];
        int max = nums[0];
        
        for(int i = 1; i< nums.length; i++){
            res = Math.max(nums[i], res+nums[i]);
            max= Math.max(max, res);
        }
        return max;
    }
}
