public class demo72 {
    //编辑距离  动态规划
    public static int minDistance(String word1, String word2) {
        int m=word1.length(),n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<=n;i++){
            dp[0][i]=i;
        }
        for(int a=1;a<=m;a++){
            for(int b=1;b<=n;b++){
                int x=dp[a-1][b]+1,y=dp[a][b-1]+1,z=dp[a-1][b-1];
                if(word1.charAt(a-1)!=word2.charAt(b-1)){
                    z++;
                }
                dp[a][b]=Math.min(x,Math.min(y,z));
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {

        System.out.println(" = " + minDistance("123","321"));
    }

}
