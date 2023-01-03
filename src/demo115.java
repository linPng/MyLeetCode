public class demo115 {
    //不同的子序列  动态规划 动态转移方程 先打表
    public static int numDistinct(String s, String t) {
        int m=s.length(),n=t.length();
        if(n>m){
            return 0;
        }
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=n;i++){
            dp[i][i]=s.charAt(i-1)==t.charAt(i-1)?dp[i-1][i-1]:0;
        }
        for(int b=1;b<=n;b++){
            for(int a=b+1;a<=m;a++){
                dp[a][b]=dp[a-1][b]+(s.charAt(a-1)==t.charAt(b-1)?dp[a-1][b-1]:0);
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {

        System.out.println(" = " + numDistinct("rabbbit","rabbit"));
        System.out.println(" = " + numDistinct("babgbag","bag"));
    }

}
