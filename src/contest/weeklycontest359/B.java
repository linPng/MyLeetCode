package contest.weeklycontest359;

public class B {
    //2829. k-avoiding 数组的最小总和
    //模拟
    public int minimumSum(int n, int k) {
        int ret=0;
        int[] d=new int[n];
        for(int i=1;i<=n;i++){
            d[i-1]=i;
            ret+=i;
        }
        int t=Math.max(n+1,k);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(d[i]+d[j]==k){
                    ret-=d[j];
                    d[j]=t;
                    t++;
                    ret+=d[j];
                }
            }
        }
        return ret;
    }
    //数学
    public int minimumSum2(int n, int k) {
        int m = Math.min(k / 2, n);
        return (m * (m + 1) + (k * 2 + n - m - 1) * (n - m)) / 2;
    }

    public static void main(String[] args) {

    }
}
