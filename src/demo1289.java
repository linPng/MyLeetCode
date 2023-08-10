import java.util.PriorityQueue;

public class demo1289 {
    //1289. 下降路径最小和 II
    //经典动态规划
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        int ret=Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){//初始化dp0
            dp[0][i]=grid[0][i];
            System.out.println("dp[0][i] = " + dp[0][i]);
        }
        for(int j=1;j<n;j++){
            //优先数组
            //PriorityQueue<int[]> big = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
            int[] big1=new int[]{Integer.MAX_VALUE,-1};
            int[] big2=new int[]{Integer.MAX_VALUE,-1};
            for(int i=0;i<n;i++){//求最小dpi-1
                if(dp[j-1][i]<=big1[0]){
                    big2=big1;
                    big1=new int[]{dp[j-1][i],i};
                }else if(dp[j-1][i]<=big2[0]){
                    big2=new int[]{dp[j-1][i],i};
                }
            }
            for(int i=0;i<n;i++){//求dp
                int[] t=big1;
                if(t[1]==i){
                    t=big2;
                }
                dp[j][i]=grid[j][i]+t[0];
                System.out.println("dp[j][i] = " + dp[j][i]);
            }

        }
        for(int i=0;i<n;i++){
            ret=Math.min(ret,dp[n-1][i]);
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
