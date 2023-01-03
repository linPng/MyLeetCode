import java.util.List;

public class demo121 {
    //买卖股票的最佳时机 II 简单
    public static int maxProfit(int[] prices) {
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
    public static void main(String[] args) {


    }

}
