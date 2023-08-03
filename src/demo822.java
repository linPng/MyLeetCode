import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class demo822 {
    //翻转卡片游戏
    public int flipgame(int[] fronts, int[] backs) {
        PriorityQueue<Integer> pq=new PriorityQueue();
        Set set = new HashSet();
        for(int i=0;i<fronts.length;i++){
            if(fronts[i]==backs[i]){
                set.add(fronts[i]);
                continue;
            }
            pq.add(fronts[i]);
            pq.add(backs[i]);
        }
        while(pq.size()>0&&set.contains(pq.peek())){
            pq.poll();
        }
        return pq.size()>0?pq.peek():0;
    }
    public static void main(String[] args) {

    }
}
