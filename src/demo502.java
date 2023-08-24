import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class demo502 {
    //502. IPO
    //排序优先队列
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        int[][] d=new int[n][2];
        for(int i=0;i<n;i++) {
            d[i] = new int[]{capital[i], profits[i]};
        }
        Arrays.sort(d,(a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> high = new PriorityQueue<Integer>((a, b) -> b - a);//大堆
        int l=0;
        for(int i=0;i<k;i++){
            while(l<n&&d[l][0]<=w){
                high.offer(d[l][1]);
                l++;
            }
            if(high.size()==0){
                return w;
            }
            int c=high.poll();
            w+=c;
        }
        return w;
    }
    public static void main(String[] args) {

    }
}
