public class demo122 {
    //买卖股票的最佳时机 II 简单 贪心
    public static int maxProfit(int[] prices) {
        int ret=0;
        for(int i=1;i<prices.length;i++){
            int j=prices[i]-prices[i-1];
            if(j>0){
                ret+=j;
            }
        }
        return ret;
    }
    public static void main(String[] args) {


    }

}
