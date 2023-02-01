import java.util.Arrays;

public class demo188 {
    //买卖股票的最佳时机 IV 困难 不会
    //动态规划
    public static int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);//n天最多n/2次交易
        //输入等于卖出-买入
        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];
        //买入是记为负数
        //0次买入无意义，但是再边界上要满足第一天可以卖出，第0天就必须买入
        // buy[0][0] + prices[1]
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; ++i) {
            //用一个非常小的数字表示无效
            //0 <= prices[i] <= 1000 所以Integer.MIN_VALUE / 2 足够小，且相加不会溢出 哨兵
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            //不买,或者买
            // buy[1][0] = Math.max(buy[0][0], sell[0][0] - prices[1]); === max{-prices[0],-prices[1]}
            //就算选择之前最低的单次买入加 之前没买过,sell[i - 1][0]肯定都是0,=== max{max_buy,-prices[i]}
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                //buy[1][1] = Math.max(buy[0][1], sell[0][1] - prices[1]);
                //sell[1][1] = Math.max(sell[0][1], buy[0][0] + prices[1]);
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }
    public static void main(String[] args) {
        System.out.println("maxProfit = " + maxProfit(2,new int[]{3,2,6,5,0,3}));
    }
}
