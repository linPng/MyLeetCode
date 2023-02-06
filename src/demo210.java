import java.util.*;

public class demo210 {
    //课程表 II
    //拓扑排序
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> list = new LinkedList<>();
        //计算入度
        Map<Integer,Integer> map = new HashMap<>();//入度
        Map<Integer,Set<Integer>> map2 = new HashMap<>();//图
        for(int[] e:prerequisites){
            map.put(e[0],map.getOrDefault(e[0],0)+1);
            Set s=map2.getOrDefault(e[1],new HashSet<>());
            s.add(e[0]);
            map2.put(e[1],s);
        }
        Deque<Integer> deque = new ArrayDeque<Integer>();
        //入度为0的优先队列
        for (int i=0;i<numCourses;i++) {
            if(!map.containsKey(i)){
                deque.addLast(i);
            }
        }
        //拓扑排序
        while (!deque.isEmpty()) {
            int i=deque.pollFirst();
            list.add(i);
            for(int j:map2.getOrDefault(i,new HashSet<>())){
                map.put(j,map.getOrDefault(j,0)-1);//入度减一
                if(map.getOrDefault(j,0)==0){
                    deque.addLast(j);
                }
            }
        }
        //list转数组
        return list.size()==numCourses?list.stream().mapToInt(Integer::intValue).toArray():new int[]{};
    }
    public static void main(String[] args) {

    }
}
