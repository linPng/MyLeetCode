import java.util.Arrays;
import java.util.PriorityQueue;

public class demo1851 {
    //包含每个查询的最小区间
    //经典优先队列延迟删除
    public int[] minInterval(int[][] intervals, int[] queries) {
        //将区间按区间头从小到大排序
        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));
        //记录queries以及i，也就是queries[i]和i
        int[][] que = new int[queries.length][2];
        for(int i = 0; i < queries.length; ++i) {
            que[i][0] = queries[i];
            que[i][1] = i;
        }
        //将值排序，小的在前
        Arrays.sort(que, (o1, o2) -> (o1[0] - o2[0]));
        int[] res = new int[que.length];
        Arrays.fill(res, -1);//不存在就-1
        //优先级队列，区间长度小的区间优先，在队列头
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((o1, o2) -> ((o1[1] - o1[0]) - (o2[1] - o2[0])));
        //记录第几个区间，因为intervals和queries都是排好序的，所以用index记录目前走到哪里了
        int index = 0;
        for(int i = 0; i < que.length; ++i) {
            //先把区间左边界小于等于queries[i]的区间加进去
            while(index < intervals.length && que[i][0] >= intervals[index][0]) {
                queue.offer(new int[]{intervals[index][0], intervals[index][1]});
                index += 1;
            }
            //再把区间右边界小于queries[i]的区间删除
            while(!queue.isEmpty() && queue.peek()[1] < que[i][0]) {
                queue.poll();
            }
            /*
            为什么不需要动index？
            正如上面的注释，intervals和queries都是排好序的
            如果这个区间不合适被删除了，是因为这个区间是在queries[i]的左面，但是之后的queries[i + 1]都比queries[i]大
            所以这个区间在以后肯定也不合适，就删除了，不再要了
            */
            if(!queue.isEmpty()) {
                int[] t = queue.peek();
                res[que[i][1]] = t[1] - t[0] + 1;
            }
        }
        return res;

    }
    public static void main(String[] args) {

    }
}