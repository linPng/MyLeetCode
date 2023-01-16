import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class demo146 {
    //LRU 缓存  LinkHashMap 数组+红黑树+链表
    class LRUCache {
        int maxsize=0;
        Map<Integer,Integer> map;
        //List<Integer,Integer> list=new
        public LRUCache(int capacity) {
            maxsize=capacity;
            map = new LinkedHashMap<>();
        }

        public int get(int key) {
            return map.get(Integer.valueOf(key));
        }

        public void put(int key, int value) {
            map.put(key,value);
            if(map.size()>maxsize){
                //map.();
            }
        }
    }
}