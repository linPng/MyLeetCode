import java.util.*;
import java.util.stream.Collectors;

public class demo40 {
    //组合总和2(不可重复使用)
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        Arrays.sort(candidates);
        //Set<String> set=new HashSet<>();
        List<List<Integer>> ret=new ArrayList<>();
        dfs(candidates,target,new ArrayDeque<>(),0,ret);
        return ret;
    }
    public static int dfs(int[] candidates, int target, Deque<Integer> l, int i,List<List<Integer>> ret){
        if(target==0){
            //set去重
            //String key=l.stream().map(String::valueOf).collect(Collectors.joining("#"));
            //if(!set.contains(key)){
                //set.add(key);
                ret.add(new ArrayList<>(l));
            //}
            return 0;
        }
        if(target<0){
            return -1;
        }
        for(int j=i;j<candidates.length;j++){
            l.addLast(candidates[j]);
            dfs(candidates,target-candidates[j],l,j+1,ret);
            l.removeLast();
            while(j+1<candidates.length&&candidates[j]==candidates[j+1]){
                j++;
            }
        }
        return target;
    }

    public static void main(String[] args) {
        /*[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
30*/
        int[] candidates=new int[]{10,1,2,7,6,1,5};
        System.out.println("combinationSum() = " + combinationSum(candidates,8));

        candidates=new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println("combinationSum() = " + combinationSum(candidates,30));

    }

}
