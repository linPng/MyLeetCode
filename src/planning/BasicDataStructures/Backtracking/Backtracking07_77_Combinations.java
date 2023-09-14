package planning.BasicDataStructures.Backtracking;

import java.util.LinkedList;
import java.util.List;

public class Backtracking07_77_Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new LinkedList<>();
        if(k==1){
            for(int i=1;i<=n;i++){
                List<Integer> t = new LinkedList<>();
                t.add(i);
                ret.add(t);
            }
            return ret;
        }
        List<List<Integer>> pre= combine( n, k-1);
        for(List<Integer> li: pre){
            for(int i=1;i<=n;i++){
                if(i>li.get(li.size()-1)){
                    List<Integer> t=new LinkedList<>(li);
                    t.add(i);
                    ret.add(t);
                }
                /*if(!li.contains(i)){
                    List<Integer> t=new LinkedList<>(li);
                    t.add(i);
                    ret.add(t);
                }*/
            }
        }
        return ret;
    }



}
