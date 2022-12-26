import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo46 {
    //46全排列

    //暴力解:每次插入新数
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> r = new ArrayList();
        r.add(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)).subList(0,1));
        for(int i=1;i<nums.length;i++){
            int e=nums[i];
            List<List<Integer>> t = new ArrayList();
            for(List a:r){
                for(int j=0;j<=a.size();j++){
                    List<Integer> l=new ArrayList();
                    l.addAll(a.subList(0,j));
                    l.add(e);
                    l.addAll(a.subList(j,a.size()));
                    t.add(l);
                }

            }
            r=t;
        }
        return r;
    }
    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,4,5};
        permute(a);
    }
}
