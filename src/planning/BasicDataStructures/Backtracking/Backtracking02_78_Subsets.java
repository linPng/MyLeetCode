package planning.BasicDataStructures.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Backtracking02_78_Subsets {


    //二进制
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int n=nums.length;
        int k=1<<n;
        for(int i=0;i<k;i++){
            List<Integer> t = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    t.add(nums[j]);
                }
            }
            ret.add(new ArrayList<>(t));
        }
        return ret;
    }

    //回溯
    List<List<Integer>> retu = new ArrayList<>();
    public List<List<Integer>> subsets2(int[] nums) {
        dfs(nums,new ArrayList<>(),0);
        return retu;
    }
    public void dfs(int[] nums,List<Integer> d,int k){
        if(k==nums.length){
            retu.add(new ArrayList<>(d));
            return;
        }
        d.add(nums[k]);
        dfs(nums,d,k+1);
        d.remove(d.size()-1);
        dfs(nums,d,k+1);
    }

}
