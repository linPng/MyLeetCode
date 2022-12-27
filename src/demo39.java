import java.util.*;

public class demo39 {
    //组合总和
    static List<List<Integer>> r=new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target){

        Arrays.sort(candidates);
        //candidates = Arrays.stream(candidates).boxed().sorted(((o1, o2) -> o2 - o1)).mapToInt(int1 -> int1).toArray();
        //f(candidates,target,new ArrayDeque<>(),0);
        List<List<Integer>> ret=new ArrayList<>();
        dfs(candidates,target,new ArrayDeque<>(),0,ret);
        return ret;
    }
    public static int dfs(int[] candidates, int target, Deque<Integer> l, int i,List<List<Integer>> ret){
        if(target==0){
            ret.add(new ArrayList<>(l));
            return 0;
        }
        if(target<0){
            return -1;
        }
        for(int j=i;j<candidates.length;j++){
            l.addLast(candidates[j]);
            dfs(candidates,target-candidates[j],l,j,ret);
            l.removeLast();
        }
        return target;
    }

    public static int f2(int[] candidates, int target, Deque<Integer> l, int i){
        int sum=l.stream().mapToInt(Integer::intValue).sum();
        sum+=candidates[i];
        if(sum>target){
            return -1;
        }
        if(sum==target){
            l.addLast(candidates[i]);
            r.add(new ArrayList<>(l));
            l.removeLast();
            return target;
        }
        Deque<Integer> t=new ArrayDeque<>(l);
        for(int j=0;j<candidates.length;j++){
            l=t;
            l.addLast(candidates[j]);
            int z=f2(candidates,target,l,j);
            if(z==target){
                l.removeLast();
                sum=z;
            }else if(z==-1){
                l.removeLast();
                sum=z;
            }else {
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] candidates=new int[]{1,2,3,4};
        System.out.println("combinationSum(candidates,3) = " + combinationSum(candidates,4));
    }

}