public class demo53 {
    //最大子数组和
    //动态规划 后无效性
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int max=Integer.MIN_VALUE;
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                dp[i]=nums[i];
            }else{
                dp[i]=dp[i-1]>0?dp[i-1]+nums[i]:nums[i];
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    //动态规划  超出内存限制
    public static int maxSubArray2(int[] nums) {
        int m = nums.length;
        int n = nums.length;
        int max=Integer.MIN_VALUE;
        int[][] dp=new int[m][n];
        for(int i=0;i<n;i++){
            dp[i][i]=nums[i];
            max=Math.max(max,dp[i][i]);
            for(int j=i+1;j<n;j++){
                dp[i][j]=dp[i][j-1]+nums[j];
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        //int[][] n=new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        //int[][] n=new int[][]{{0,1},{0,0}};
        int[] n=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(" = " + maxSubArray(n));
    }

}