public class demo44 {
    //通配符匹配 困难 动态规划
    public boolean isMatch(String s, String p) {
        char[] cs=s.toCharArray();
        char[] cp=p.toCharArray();
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for(int j=1;j<=p.length();j++){
            if(cp[j-1]=='*'){
                dp[0][j]=true;
            }else{
                break;
            }
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(cp[j-1]==cs[i-1]||cp[j-1]=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(cp[j-1]=='*'){
                    dp[i][j]=dp[i][j-1]||dp[i-1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    public static void main(String[] args) {

    }
}