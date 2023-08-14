package contest.weeklycontest85;

import java.util.ArrayDeque;
import java.util.Deque;

public class C {
    //837. 新 21 点 经典 动态规划
    //   bfs不行,需要考虑每一轮的概率，不能直接累加结果
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0) {
            return 1.0;
        }
        double[] dp = new double[k + maxPts];//最多拿到的数字是k-1+maxPts;
        for (int i = k; i <= n && i < k + maxPts; i++) {//初始化最后一次的概率
            dp[i] = 1.0;
        }
        dp[k - 1] = 1.0 * Math.min(n - k + 1, maxPts) / maxPts;//需要再抽一次，计算抽中的数少于n的概率
        for (int i = k - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + maxPts + 1] - dp[i + 1]) / maxPts;//dp[i+1]加上f(i+1)减去f(i+maxPts+1)
        }
        return dp[0];
    }
    //动态规划
    public double new21GameError(int n, int k, int maxPts) {
        int total=0;
        int less=0;
        Deque<Integer> d= new ArrayDeque<>();
        for(int i=1;i<=maxPts;i++){
            d.offer(i);
        }
        while(!d.isEmpty()){
            int t=d.poll();
            if(t>=k){
                total++;
                if(t<=n){
                    less++;
                }
            }else{
                for(int i=1;i<=maxPts;i++){
                    d.offer(t+i);
                }
            }
        }
        if (less==0){
            return 0l;
        }else{
            return (double) less/total;
        }
    }
    public static void main(String[] args) {
        C c=new C();
        System.out.println("c.new21Game(21,17,10) = " + c.new21Game(21,17,10));
    }
}
