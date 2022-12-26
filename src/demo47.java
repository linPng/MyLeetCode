import java.util.*;
import java.util.stream.Collectors;

public class demo47 {
    //47全排列 加去重

    //暴力解:每次插入新数
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> r = new ArrayList();
        r.add(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)).subList(0,1));
        for(int i=1;i<nums.length;i++){
            int e=nums[i];
            List<List<Integer>> t = new ArrayList();
            Set<String> keys = new HashSet<>();
            for(List a:r){
                for(int j=0;j<=a.size();j++){
                    List<Integer> l=new ArrayList();
                    l.addAll(a.subList(0,j));
                    l.add(e);
                    l.addAll(a.subList(j,a.size()));
                    //String key=String.join(",", l);//不能处理list中的Integer;
                    //List<Integer>转String
                    String key=l.stream().map(String::valueOf).collect(Collectors.joining("#"));
                    if(keys.contains(key)){
                        continue;
                    }else{
                        keys.add(key);
                        t.add(l);
                    }
                }
            }
            r=t;
        }
        return r;
    }
    //递归回溯
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> r = new ArrayList();
        //todo
        return r;
    }
    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,4,5};
        permute(a);
        permute2(a);
    }
}
