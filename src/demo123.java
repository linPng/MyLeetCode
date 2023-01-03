public class demo123 {
    //买卖股票的最佳时机 III
    //经典动态规划
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
    // 分类
    public static int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int max_i=0,min_i=0,min_t=0;
        int ret=0,ret2=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]-min>ret){
                ret=prices[i]-min;
                max_i=i;
                min_i=min_t;
            }
            if(prices[i]<min){
                min=prices[i];
                min_t=i;
            }
        }
        if(prices[max_i]-prices[min_i]>0){
            ret=prices[max_i]-prices[min_i];
        }else{
            return 0;
        }
        int[] l=new int[min_i+1],m=new int[max_i-min_i+1],r=new int[prices.length-max_i];
        //数组截取
        System.arraycopy(prices,0,l,0,l.length);
        System.arraycopy(prices,min_i,m,0,m.length);
        System.arraycopy(prices,max_i,r,0,r.length);
        ret2= Math.max(ret2,minP(m));
        ret2= Math.max(ret2,maxP(l));
        ret2= Math.max(ret2,maxP(r));
        return ret+ret2;
    }
    public static int maxP(int[] prices) {
        int min=Integer.MAX_VALUE;
        int ret=0;
        for(int i:prices){
            if(i-min>ret){
                ret=i-min;
            }
            min=Math.min(min,i);
        }
        return ret;
    }
    public static int minP(int[] prices) {
        int max=-1;
        int ret=0;
        for(int i:prices){
            if(max-i>ret){
                ret=max-i;
            }
            max=Math.max(max,i);
        }
        return ret;
    }
    public static void main(String[] args) {

        System.out.println("maxProfit(new int[]{3,3,5,0,0,3,1,4}) = " + maxProfit(new int[]{6,1,3,2,4,7}));
    }

}
