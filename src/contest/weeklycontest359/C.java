package contest.weeklycontest359;

import java.util.LinkedList;
import java.util.List;

public class C {
    //2830. 销售利润最大化
    //经典动态规划
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        int[] dp=new int[n+1];
        List<int[]>[] group=new List[n];
        for(int i=0;i<n;i++){
            group[i]=new LinkedList<int[]>();
        }
        for(List<Integer> o:offers){
            group[o.get(1)].add(new int[]{o.get(0),o.get(2)});
        }
        for(int i=1;i<n+1;i++){
            dp[i]=dp[i-1];
            List<int[]> t=group[i-1];
            for(int[] r:t){
                dp[i]=Math.max(dp[i],dp[r[0]]+r[1]);
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {

    }
}
