package planning.BasicDataStructures.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking04_39_CombinationSum {

    List<List<Integer>> ret=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,0,new ArrayList<>(),0);
        return ret;
    }
    public void dfs(int[] c,int t,int a,List<Integer> l,int i){
        if(a>t){
            return;
        }
        if(a==t){
            ret.add(new ArrayList<>(l));
            return;
        }
        for(int j=i;j<c.length;j++){
            l.add(c[j]);
            dfs(c,t,a+c[j],l,j);
            l.remove(l.size()-1);
        }
    }


}
