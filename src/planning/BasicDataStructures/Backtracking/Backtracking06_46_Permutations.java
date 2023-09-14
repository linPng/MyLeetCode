package planning.BasicDataStructures.Backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Backtracking06_46_Permutations {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret= new LinkedList<>();
        if(nums.length==1){
            List<Integer> t = new LinkedList<>();
            t.add(nums[0]);
            ret.add(t);
            return ret;
        }
        List<List<Integer>> per = permute(Arrays.copyOfRange(nums, 0, nums.length - 1));
        for(List<Integer> li:per){
            for(int i=0;i<=li.size();i++){
                List<Integer> t = new LinkedList<>(li);
                t.add(i,nums[nums.length-1]);
                ret.add(t);
            }
        }
        return ret;
    }


}
