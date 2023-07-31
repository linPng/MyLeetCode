import java.util.ArrayDeque;
import java.util.Deque;

public class demo739 {
    //每日温度

    //单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] ret=new int[n];
        Deque<Integer[]> d=new ArrayDeque<>();
        for(int i=n-1;i>=0;i--){
            int r=0;
            while(d.size()>0&&temperatures[i]>=d.peekLast()[1]){
                d.pollLast();
            }
            if(d.size()>0){
                r=d.peekLast()[0]-i;
            }
            ret[i]=r;
            d.addLast(new Integer[]{i,temperatures[i]});
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
