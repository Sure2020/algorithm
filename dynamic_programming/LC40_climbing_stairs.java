public class LC40_climbing_stairs {
    class Solution20240618 {
        public int climbStairs(int n) {
            // int[] dp = new int[n+1];
            // Arrays.fill(dp,-1);
            int dp0=0,dp1=1,dp2=-1;
            for(int i=0;i<n;i++){
                dp2 = dp0+dp1;
                dp0 = dp1;
                dp1=dp2;
            }
            return dp2;
        }
    }
//n=1,result=1;n=2,result=2;n=3,result=3;
//n=4,result=
//1,1,1,1;
//1,1,2;
//1,2,1;
//2,1,1;
//2,2
//斐波那契数列。。。0,1,1,2,3,5
}
