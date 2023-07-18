public class demo264 {
    //丑数 II
    public int nthUglyNumber(int n) {//第N个只能是dp[i2|i3|i5]*2|*3|*5来的,每次都不能重复,所以i在使用后要++;三组i要分开记录;
        int ret=1;
        int a=0,b=0,c=0;
        int[] dp=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            ret=Math.min(Math.min(dp[a]*2,dp[b]*3),dp[c]*5);
            dp[i]=ret;
            if(ret==dp[a]*2){
                a++;
            }
            if(ret==dp[b]*3){
                b++;
            }
            if(ret==dp[c]*5){
                c++;
            }
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        demo264 d = new demo264();
        System.out.println("d.nthUglyNumber(10) = " + d.nthUglyNumber(11));
    }
}