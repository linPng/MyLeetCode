import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class demo128 {
    //最长连续序列
    public static int longestConsecutive(int[] nums) {
        int ret=0;
        //数组转set
        Set<Integer> set = new HashSet<>(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)));
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int j=nums[i];
                int t=1;
                while(set.contains(++j)){
                    t++;
                }
                if(t>ret){
                    ret=t;
                }
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(" = " + longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

}