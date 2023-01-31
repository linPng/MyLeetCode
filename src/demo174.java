public class demo174 {
    //地下城游戏
    //动态规划+反向贪心  要想清楚依赖关系，起点的最小值以来后面的路径，所以要反向计算
    public static int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length,n=dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1]=1;
        for(int j=n-2;j>=0;j--){
            dp[m-1][j]=dungeon[m-1][j+1]>=dp[m-1][j+1]?1:dp[m-1][j+1]-dungeon[m-1][j+1];
        }
        for(int i=m-2;i>=0;i--){
            dp[i][n-1]=dungeon[i+1][n-1]>=dp[i+1][n-1]?1:dp[i+1][n-1]-dungeon[i+1][n-1];
            for(int j=n-2;j>=0;j--){
                int t=Math.min(dp[i][j+1]-dungeon[i][j+1],dp[i+1][j]-dungeon[i+1][j]);
                dp[i][j]=t>0?t:1;
            }
        }
        return dp[0][0]-dungeon[0][0]>0?dp[0][0]-dungeon[0][0]:1;
    }
    //添加哨兵，简化逻辑
    public static int calculateMinimumHP2(int[][] dungeon) {
        int m=dungeon.length,n=dungeon[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){//max int 作为哨兵
            dp[i][n]=Integer.MAX_VALUE;
        }
        for(int j=0;j<n+1;j++){//max int 作为哨兵
            dp[m][j]=Integer.MAX_VALUE;
        }
        dp[m-1][n]=1;//终点最少1点
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                dp[i][j]=Math.max(Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j],1);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        System.out.println("args = " + calculateMinimumHP(new int[][]{{-1,1}}));
//        System.out.println("args = " + calculateMinimumHP(new int[][]{{1,-3,3},{0,-2,0},{-3,-3,-3}}));
        //System.out.println("args = " + calculateMinimumHP(new int[][]{{0,0,0},{1,1,-1}}));
        //System.out.println("args = " + calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
    }
}
