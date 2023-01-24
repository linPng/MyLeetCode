import java.util.HashMap;
import java.util.Map;

public class demo1817 {
    //查找用户活跃分钟数
    //模拟
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
        for(int i=0;i<logs.length;i++){
            int id=logs[i][0];
            int time=logs[i][1];
            //map.putIfAbsent(id,new HashMap<>());
            if(!map.containsKey(id)){
                map.put(id,new HashMap<>());
            }
            map.get(id).put(time,map.get(id).getOrDefault(id,0)+1);
        }
        int[] ret=new int[k];
        for(int key:map.keySet()){
            int size=map.get(key).size();
            if(size<=k){
                ret[size-1]+=1;
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}