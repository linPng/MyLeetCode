import java.util.ArrayList;
import java.util.List;

public class demo78 {
    //子集
    //二进制
    public List<List<Integer>> subsets2(int[] nums) {
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {//遍历所有01的组合
            t.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {//判断对应位置是否为1
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;
    }
    //回溯算法
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> r=new ArrayList<>();
        List<Integer> t=new ArrayList<>();
        r.add(new ArrayList<>());
        f(nums,0,r,t);
        return r;
    }
    public static void f(int[] nums,int p,List<List<Integer>> r,List<Integer> t){
        if(p>=nums.length){
            return;
        }
        for(int i=p;i<nums.length;i++){
            Integer d=nums[i];
            t.add(d);
            r.add(new ArrayList<>(t));
            f(nums,i+1,r,t);
            t.remove(d);
        }
    }
    public static void main(String[] args) {
        System.out.println(" = " + subsets(new int[]{1,2,3}));
    }

}