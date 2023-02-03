package rank;

public class hard_100_2312_2363 {
    //卖木头块
    //动态规划
    public long sellingWood2(int m, int n, int[][] prices) {
        long[][] dp = new long[m + 1][n + 1];
        for (int[] p : prices){
            dp[p[0]][p[1]] = p[2];
        }
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k < j; k++){ dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[i][j - k]);} // 垂直切割
                for (int k = 1; k < i; k++){ dp[i][j] = Math.max(dp[i][j], dp[k][j] + dp[i - k][j]);} // 水平切割
            }
        }
        return dp[m][n];
    }
    //优化剪枝
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long[m + 1][n + 1];
        for (int[] p : prices){
            dp[p[0]][p[1]] = p[2];
        }
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= j/2; k++){ dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[i][j - k]);} // 垂直切割
                for (int k = 1; k <= i/2; k++){ dp[i][j] = Math.max(dp[i][j], dp[k][j] + dp[i - k][j]);} // 水平切割
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {

    }
}
