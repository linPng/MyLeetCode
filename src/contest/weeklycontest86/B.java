package contest.weeklycontest86;

import java.util.*;

public class B {
    //841. 钥匙和房间
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set set = new HashSet();
        set.add(0);
        Deque<Integer> d = new ArrayDeque();
        for(int i:rooms.get(0)){
            d.offer(i);
        }
        while(d.size()>0){
            int i=d.poll();
            if(set.contains(i)){
                continue;
            }else{
                set.add(i);
                for(int j:rooms.get(i)){
                    d.offer(j);
                }
            }
        }
        if(set.size()==rooms.size()){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
