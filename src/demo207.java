import java.util.*;

public class demo207 {
    //课程表
    //拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> list = new ArrayList<>();
        //计算入度
        Map<Integer,Integer> map = new HashMap<>();//入度
        Map<Integer,Set<Integer>> map2 = new HashMap<>();//图
        for(int[] e:prerequisites){
            map.put(e[1],map.getOrDefault(e[1],0)+1);
            Set s=map2.getOrDefault(e[0],new HashSet<>());
            s.add(e[1]);
            map2.put(e[0],s);
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
        return list.size()==numCourses;
    }
    public static void main(String[] args) {

    }
}
