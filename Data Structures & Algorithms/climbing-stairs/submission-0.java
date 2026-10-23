class Solution {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int[] prefix=new int[n+1];
        prefix[1]=1;
        prefix[2]=2;

        for(int i=3; i<=n; i++){
            prefix[i]= prefix[i-1]+prefix[i-2];
        }

        return prefix[n];
    }
}
