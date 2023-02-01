public class demo198 {
    //打家劫舍 中等
    //动态规划
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2;i<nums.length+1;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length];
    }
    public static void main(String[] args) {

    }
}
