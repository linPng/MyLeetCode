import java.util.*;
import java.util.stream.Collectors;

public class demo90 {
    //子集
    //回溯算法
    public static Set<String> set = new HashSet<>();
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> r=new ArrayList<>();
        List<Integer> t=new ArrayList<>();
        r.add(new ArrayList<>());
        Arrays.sort(nums);
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
            String key=t.stream().map(String::valueOf).collect(Collectors.joining("#"));
            if(set.add(key)) {
                r.add(new ArrayList<>(t));
                f(nums, i + 1, r, t);
            }
            t.remove(d);
        }
    }
    public static void main(String[] args) {
        System.out.println(" = " + subsets(new int[]{4,4,4,1,4}));
    }

}