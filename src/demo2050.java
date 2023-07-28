import java.util.*;

public class demo2050 {
    //并行课程 III
    //经典拓扑排序
    //拓扑排序+优先队列(可以使用动态规划)
    public int minimumTime(int n, int[][] relations, int[] time) {
        int ret=0;
        //计算入度
        Map<Integer,Integer> map = new HashMap<>();//入度
        Map<Integer,Set<Integer>> map2 = new HashMap<>();//图
        for(int[] e:relations){
            map.put(e[1],map.getOrDefault(e[1],0)+1);
            Set s=map2.getOrDefault(e[0],new HashSet<>());
            s.add(e[1]);
            map2.put(e[0],s);
        }
        //Deque<Set<Integer>> deque = new ArrayDeque<Set<Integer>>();
        //Set<Integer> in0set=new HashSet<>();
        //a[]==n;b[]==time;
        PriorityQueue<int[]> in0pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        //入度为0的优先队列
        for (int i=1;i<=n;i++) {
            if(!map.containsKey(i)){
                in0pq.add(new int[]{i,time[i-1]});
            }
        }
        //拓扑排序
        while (!in0pq.isEmpty()) {
            int[] i=in0pq.peek();
            if(i[1]<=ret){
                in0pq.poll();
                for(int j:map2.getOrDefault(i[0],new HashSet<>())){
                    map.put(j,map.getOrDefault(j,0)-1);//入度减一
                    if(map.getOrDefault(j,0)==0){//加入入读为零
                        in0pq.add(new int[]{j,time[j-1]+ret});
                    }
                }
            }else{
                ret=i[1];
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}