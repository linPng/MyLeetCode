import java.util.HashSet;
import java.util.Set;

public class demo2341 {
    //数组能形成多少数对 简单
    public int[] numberOfPairs(int[] nums) {
        int[] ret=new int[2];
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
                ret[0]++;
            }else{
                set.add(nums[i]);
            }
        }
        ret[1]=set.size();
        return ret;
    }
    public static void main(String[] args) {

    }
}
