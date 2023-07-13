import java.util.Arrays;

public class demo931 {
    //下降路径最小和
    //动态规划
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp=new int[n][n];
        dp[n-1]=matrix[n-1];
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int min_t=dp[i+1][j];
                if(j>0){
                    min_t=Math.min(min_t,dp[i+1][j-1]);
                }
                if(j<n-1){
                    min_t=Math.min(min_t,dp[i+1][j+1]);
                }
                dp[i][j]=min_t+matrix[i][j];
            }
        }
        /*Arrays.sort(dp[0]);
        return dp[0][0];*/
        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }

    public static void main(String[] args) {

    }
}