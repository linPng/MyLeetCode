public class demo97 {
    //交错字符串 动态规划
    public static boolean isInterleave(String s1, String s2, String s3) {
        char[] c1=s1.toCharArray(),c2=s2.toCharArray(),c3=s3.toCharArray();
        int m=c1.length,n=c2.length,o=c3.length;
        if(o!=m+n) return false;
        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=1;i<=m;i++){
            dp[i][0]=dp[i-1][0]&&c1[i-1]==c3[i-1];
        }
        for(int j=1;j<=n;j++){
            dp[0][j]=dp[0][j-1]&&c2[j-1]==c3[j-1];
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=(dp[i][j-1]&&c2[j-1]==c3[i+j-1])||(dp[i-1][j]&&c1[i-1]==c3[i+j-1]);
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        System.out.println(" = " + isInterleave("aa", "ab", "aaba"));
        System.out.println(" = " + isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(" = " + isInterleave("", "", ""));
    }

}