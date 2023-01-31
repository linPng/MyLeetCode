public class demo174 {
    //地下城游戏
    //动态规划+贪心
    public static int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length,n=dungeon[0].length;
        int[][][] dp = new int[m][n][2];//初始生命值/当前生命值
        dp[0][0][0]=dungeon[0][0]>0?1:-dungeon[0][0]+1;
        dp[0][0][1]=dp[0][0][0]+dungeon[0][0];
        for(int j=1;j<n;j++){
            dp[0][j][1]=dp[0][j-1][1]+dungeon[0][j];
            if(dp[0][j][1]<=0){
                dp[0][j][0]=1-dp[0][j][1]+dp[0][j-1][0];
                dp[0][j][1]=1;
            }else{
                dp[0][j][0]=dp[0][j-1][0];
            }
        }
        for(int i=1;i<m;i++){
            dp[i][0][1]=dp[i-1][0][1]+dungeon[i][0];
            if(dp[i][0][1]<=0){
                dp[i][0][0]=1-dp[i][0][1]+dp[i-1][0][0];
                dp[i][0][1]=1;
            }else{
                dp[i][0][0]=dp[i-1][0][0];
            }
            for(int j=1;j<n;j++){
                //int[] t=dp[i][j-1][0]<dp[i-1][j][0]?dp[i][j-1]:dp[i-1][j];
                int[] t=dp[i][j-1],t2=new int[2],t3=new int[2];
                t2[1]=t[1]+dungeon[i][j];
                if(t2[1]<=0){
                    t2[0]=1-t2[1]+t[0];
                    t2[1]=1;
                }else{
                    t2[0]=t[0];
                }
                t=dp[i-1][j];
                t3[1]=t[1]+dungeon[i][j];
                if(t3[1]<=0){
                    t3[0]=1-t3[1]+t[0];
                    t3[1]=1;
                }else{
                    t3[0]=t[0];
                }
                if(t2[0]<t3[0]){
                    dp[i][j]=t2;
                }else if(t2[0]>t3[0]){
                    dp[i][j]=t3;
                }else{
                    if(t2[1]>t3[1]){
                        dp[i][j]=t2;
                    }else{
                        dp[i][j]=t3;
                    }
                }
            }
        }
        return dp[m-1][n-1][0];
    }
    public static void main(String[] args) {
        System.out.println("args = " + calculateMinimumHP(new int[][]{{1,-3,3},{0,-2,0},{-3,-3,-3}}));
        //System.out.println("args = " + calculateMinimumHP(new int[][]{{0,0,0},{1,1,-1}}));
        //System.out.println("args = " + calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
    }
}
