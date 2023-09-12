package planning.BasicDataStructures.Backtracking;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Backtracking03_90_SubsetsII {


    //二进制剪枝
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        int n=nums.length;
        int k=1<<n;
        for(int i=0;i<k;i++){
            List<Integer> t = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    if(j>0&&(i>>(j-1)&1)==0&&nums[j]==nums[j-1]){
                        break;
                    }
                    t.add(nums[j]);
                }

            }
            ret.add(new ArrayList<>(t));

        }
        return ret;
    }
    //回溯
    List<List<Integer>> retu = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup3(int[] nums) {
        Arrays.sort(nums);
        dfs(false,nums,new ArrayList<>(),0);
        return retu;
    }
    public void dfs(boolean usePro,int[] nums,List<Integer> d,int k){
        if(k==nums.length){
            retu.add(new ArrayList<>(d));
            return;
        }

        dfs(false,nums,d,k+1);
        if(!usePro&&k > 0 && nums[k - 1] == nums[k]){
            return;
        }
        d.add(nums[k]);
        dfs(true,nums,d,k+1);
        d.remove(d.size()-1);
    }
    //哈希表
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        Set set = new HashSet();
        int n=nums.length;
        int k=1<<n;
        for(int i=0;i<k;i++){
            List<Integer> t = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    t.add(nums[j]);
                }
            }
            String key = t.stream().map(Object::toString).collect(Collectors.joining("#"));
            if(!set.contains(key)){
                ret.add(new ArrayList<>(t));
                set.add(key);
            }

        }
        return ret;
    }


}
