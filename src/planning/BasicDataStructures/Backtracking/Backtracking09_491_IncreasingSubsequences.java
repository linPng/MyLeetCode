package planning.BasicDataStructures.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Backtracking09_491_IncreasingSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Set<String> set=new HashSet<>();
        int n=nums.length;
        int k=1<<n;
        for(int i=3;i<k;i++){
            List<Integer> li = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((1<<(j)&i)!=0){
                    if(li.size()>0&&nums[j]<li.get(li.size()-1)){
                        break;
                    }
                    li.add(nums[j]);
                }
            }
            if(li.size()>1){
                String key=li.stream().map(String::valueOf).collect(Collectors.joining("#"));
                if(!set.contains(key)){
                    set.add(key);
                    ret.add(new ArrayList<>(li));
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Backtracking09_491_IncreasingSubsequences b = new Backtracking09_491_IncreasingSubsequences();
        System.out.println("b.findSubsequences(new int[]{4,6,7,7}) = " + b.findSubsequences(new int[]{4,6,7,7}));

        /*System.out.println(1<<1);
        System.out.println(2&3);
        System.out.println((1<<(1)&3)!=0);*/
    }


}
