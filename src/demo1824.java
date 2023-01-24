public class demo1824 {
    //最少侧跳次数
    public static int minSideJumps(int[] obstacles) {
        int[][] dp=new int[obstacles.length][3];
        dp[0][0]=1;
        dp[0][1]=0;
        dp[0][2]=1;
        int n=obstacles.length-1;
        for(int i=1;i<obstacles.length;i++){
            int min=Integer.MAX_VALUE;
            for(int t=0;t<3;t++){
                if(obstacles[i]==t+1){
                    dp[i][t]=Integer.MAX_VALUE;
                }else{
                    if(obstacles[i-1]!=t+1){
                        dp[i][t]=dp[i-1][t];
                        min=Math.min(min,dp[i][t]);
                    }else{
                        dp[i][t]=Integer.MAX_VALUE-1;
                    }
                }
            }
            for(int t=0;t<3;t++){
                if(dp[i][t]==Integer.MAX_VALUE-1){
                    dp[i][t]=min+1;
                }
            }
        }
        return Math.min(dp[n][0],Math.min(dp[n][1],dp[n][2]));
    }
    public static void main(String[] args) {
        System.out.println("minSideJumps(new int[]{0,1,2,3,0}) = " + minSideJumps(new int[]{0,1,2,3,0}));
    }
}