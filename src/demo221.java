public class demo221 {
    //最大正方形

    //经典动态规划
    public int maximalSquare(char[][] matrix) {
        int ret=0;
        int y = matrix.length;
        int x = matrix[0].length;
        int[][] dp = new int[y][x];
        for(int i=y-1;i>=0;i--){
            for(int j=x-1;j>=0;j--){
                if(matrix[i][j]=='0'){
                    dp[i][j]=0;
                }else if(j==x-1||i==y-1){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i+1][j+1])+1;
                }
                ret=Math.max(ret,dp[i][j]);
            }
        }
        return ret*ret;
    }
    public static void main(String[] args) {
/*
* [["1","0","1","0","0"]
* ,["1","0","1","1","1"]
* ,["1","1","1","1","1"]
* ,["1","0","0","1","0"]]*/
    }
}